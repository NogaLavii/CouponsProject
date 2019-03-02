package DBDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Date;

import DAO.CouponDAO;
import exceptionHandling.ObjectExists;

import javaBeans.ConnectionPool;
import javaBeans.Coupon;

public class CouponDBDAO implements CouponDAO<Coupon> {
	/**
	 * 
	 * @param CouponDBDAO allows to manipulate data in the Coupons table in the database
	 * @throws Exception , SQLException
	 */
	// private ConnectionPool connectionPool;
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public boolean doesCouponExist(String title, int companyID) throws Exception {
		// init Connection
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();
			
			// prepare query
			String sql = String.format("SELECT COUNT(*) AS count FROM Coupons WHERE title = '%s' AND company_id = '%s' ",
					title, companyID);

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					resultSet.next();
					int count = resultSet.getInt("count");
					return count > 0;
				}

			}

		} finally {
			try {

				connectionPool.restoreConnection(connection);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public boolean isCouponPurchased(int customerID, int couponID) throws Exception {
		// init
		Connection connection = null;
		
		try {
			// get connection
			connection = connectionPool.getConnection();
			
			// prepare query
			String sql = String.format(
					"SELECT COUNT(*) AS count FROM Customers_vs_Coupons WHERE customer_id = %d AND coupon_id = %d",
					customerID, couponID);

			// execute query
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					
					// return answer
					resultSet.next();
					int count = resultSet.getInt("Count");
					return count > 0;

				} catch (Exception e) {
					System.out.println(e.getMessage());
					return false;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

	@Override
	public void addCoupon(Coupon coupon) throws Exception {
		if (doesCouponExist(coupon.getTitle(), coupon.getCompany_id())) {
			throw new ObjectExists("This coupon already exists in the Data Base");
		}
		else {
			// init
			Connection connection = null;
			
			try {
				// get connection
				connection = connectionPool.getConnection();
				
				// prepare query
				String sql = String.format(
						"INSERT INTO Coupons (company_id ,category_id ,title ,description ,"
								+ " start_date , end_date, amount, price, image) "
								+ "VALUES (%d, %d, '%s', '%s','%s', '%s', %d, '%.2f', '%s' ) ",
						coupon.getCompany_id(), coupon.getCategory_id(), coupon.getTitle(), coupon.getDescription(),
						new java.sql.Date(coupon.getStart_date().getTime()),new java.sql.Date(coupon.getEnd_date().getTime()),
						coupon.getAmount(), coupon.getPrice(),coupon.getImage());
				
				try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
						PreparedStatement.RETURN_GENERATED_KEYS)) {
				// execute
				preparedStatement.executeUpdate();

				// report success
					try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
						resultSet.next();
						int id = resultSet.getInt(1);
						coupon.setId(id);
						System.out.println("Coupon Added succesfully!");
					}
				} catch (SQLException e) {
					e.getStackTrace();
				}
			} finally {
				connectionPool.restoreConnection(connection);
			}
		}
	}

	@Override
	public void updateCoupon(Coupon coupon) throws Exception {

		// init Connection
		Connection connection = null;
		
		try {
			// get connection
			connection = connectionPool.getConnection();
			
			// prepare query
			String sql = String.format(
					" UPDATE Coupons SET category_id = %d, title = '%s', description = '%s', start_date = %tD,"
							+ "end_date = %tD, amount = %d, price = %.2f, image = '%s' WHERE coupon_id = %d",
					coupon.getCategory_id(), coupon.getTitle(), coupon.getDescription(), coupon.getStart_date(),
					coupon.getEnd_date(), coupon.getPrice(), coupon.getImage(), coupon.getId());

			// execute and report success
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.executeUpdate();
				System.out.println("Coupon Updated Succesfully");
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}

	}

	public ArrayList<Coupon> getAllCoupons(int companyId) throws Exception {
		
		// init Connection
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();

			// prepare query
			String sql = String.format("SELECT * FROM Coupons WHERE company_id = %d", companyId);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				// execute
				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					ArrayList<Coupon> AllCoupons = new ArrayList<Coupon>();

					// get results and convert them into Coupon objects
					while (resultSet.next()) {
						int id = resultSet.getInt("id");
						int company_id = resultSet.getInt("company_id");
						int category_id = resultSet.getInt("category_id");
						String title = resultSet.getString("title");
						String description = resultSet.getString("description");
						Date start_date = resultSet.getDate("start_date");
						Date end_date = resultSet.getDate("end_date");
						int amount = resultSet.getInt("amount");
						double price = resultSet.getDouble("price");
						String image = resultSet.getString("image");

						Coupon coupon = new Coupon(id, company_id, category_id, title, description, image, start_date,
								end_date, amount, price);
						AllCoupons.add(coupon);
						AllCoupons = getAllCoupons(company_id);

					}
					return AllCoupons;
				}
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

	public ArrayList<Coupon> getCouponsByCategory(int categoryID, int companyID) throws Exception {
		
		// init
		ArrayList<Coupon> catgoryCouponList = new ArrayList<Coupon>();
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();

			// prepare query
			String sql = String.format("SELECT * FROM Coupons WHERE category_id = %d AND company_id = %d",
					categoryID, companyID);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				// execute
				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					// get results and convert them into Coupon objects
					while (resultSet.next()) {
						int id = resultSet.getInt("id");
						int company_id = resultSet.getInt("company_id");
						int category_id = resultSet.getInt("category_id");
						String title = resultSet.getString("title");
						String description = resultSet.getString("description");
						Date start_date = resultSet.getDate("start_date");
						Date end_date = resultSet.getDate("end_date");
						int amount = resultSet.getInt("amount");
						double price = resultSet.getDouble("price");
						String image = resultSet.getString("image");

						Coupon coupon = new Coupon(id, company_id, category_id, title, description, image,
								start_date, end_date, amount, price);
						catgoryCouponList.add(coupon);
						catgoryCouponList = getCouponsByCtgry(categoryID, company_id);
					}
					return catgoryCouponList;
				}
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}

	}

	public Coupon getCouponByID(int couponID) throws Exception {

		// init
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();

			// prepare query
			String sql = String.format("SELECT * FROM Coupons WHERE id = %d", couponID);

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				// execute
				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					// convert result into Coupon object
					resultSet.next();
					int id = resultSet.getInt("id");
					int company_id = resultSet.getInt("company_id");
					int category_id = resultSet.getInt("category_id");
					int amount = resultSet.getInt("amount");
					String title = resultSet.getString("title");
					String description = resultSet.getString("description");
					Date start_date = resultSet.getDate("start_date");
					Date end_date = resultSet.getDate("end_date");
					String image = resultSet.getString("image");
					double price = resultSet.getDouble("price");

					Coupon coupon = new Coupon(id, company_id, category_id, title, description, image, start_date,
							end_date, amount, price);
					return coupon;

				}
			}
		} finally {
			connectionPool.restoreConnection(connection);

		}
	}

	@Override
	public void deleteCoupon(int couponID) throws Exception {
		// init
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();

			// prepare and execute queries
			String sql = String.format("DELETE FROM Coupons WHERE id = %d", couponID);
			String custSql = String.format("DELETE FROM Customers_vs_Coupons WHERE coupon_id = %d", couponID);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.executeUpdate();
			}
			try (PreparedStatement preparedStatement = connection.prepareStatement(custSql)) {
				System.out.println("Deleting coupon purchase history.");
				preparedStatement.executeUpdate();
			}
			
			// report success
			System.out.println("Deleted succesfully");
			
		} finally {
			connectionPool.restoreConnection(connection);
		}

	}

	@Override
	public void purchaseCoupon(int customerID, int couponID) throws Exception {

		if (!isCouponAvailble(couponID) || isCouponPurchased(customerID, couponID)) {
			throw new ObjectExists("Coupon is not available");
		} else {
			// init
			Connection connection = null;
			try {
				// get connection
				connection = connectionPool.getConnection();
				// prepare query
				String sql = String.format("INSERT INTO Customers_vs_Coupons (customer_id, coupon_id) VALUES(%d, %d)",
						customerID, couponID);
				String amountSet = String.format("UPDATE Coupons SET amount = (amount-1) WHERE id = %d ", couponID);
				try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
						PreparedStatement.RETURN_GENERATED_KEYS)) {
					// execute
					preparedStatement.executeUpdate();
					// report success
					System.out.println("Coupon purchased succesfully");

				}
				try (PreparedStatement preparedStatement = connection.prepareStatement(amountSet,
						PreparedStatement.RETURN_GENERATED_KEYS)) {
					preparedStatement.executeUpdate();

				}
			} finally {
				connectionPool.restoreConnection(connection);
			}
		}
	}

	@Override
	public void deleteCouponPurchase(int customerID, int couponID) throws Exception {

		// init
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();

			// prepare query
			String sql = String.format("DELETE FROM Customers_vs_Coupons WHERE coupon_id = %d", couponID);

			// execute and report success
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.executeUpdate();
				System.out.println("Purchase deleted successdsfully");
			}

		} finally {
			connectionPool.restoreConnection(connection);
		}

	}

	public ArrayList<Coupon> getCouponsByPrice(int companyID, double couponPrice) throws Exception {
		// init Connection
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();
			
			// prepare query
			String sql = String.format("SELECT FROM Coupons WHERE company_id = %d AND price = %.2f",
					companyID, couponPrice);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				// execute query
				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					// get results and convert them into Coupon objects
					ArrayList<Coupon> couponPriceList = new ArrayList<>();
					while (resultSet.next()) {
						int id = resultSet.getInt("id");
						int company_id = resultSet.getInt("company_id");
						int category_id = resultSet.getInt("category_id");
						int amount = resultSet.getInt("amount");
						String title = resultSet.getString("title");
						String description = resultSet.getString("description");
						Date start_date = resultSet.getDate("start_date");
						Date end_date = resultSet.getDate("end_date");
						String image = resultSet.getString("image");
						double price = resultSet.getDouble("price");

						Coupon coupon = new Coupon(id, company_id, category_id, title, description, image, start_date,
								end_date, amount, price);
						couponPriceList.add(coupon);
						couponPriceList = getCouponsByPrice(companyID, couponPrice);
					}
					return couponPriceList;
				}
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

	@Override
	public boolean isCouponAvailble(int couponID) throws Exception {
		// init
		Connection connection = null;
		int upAmount = 0;
		Date dateValidate = new Date();
		Date current = new Date();
		
		try {
			// get connection
			connection = connectionPool.getConnection();

			// prepare and execute queries
			String sql = String.format("SELECT amount FROM Coupons WHERE id = %d", couponID);
			String dateSql = String.format("SELECT end_date FROM Coupons WHERE id = %d", couponID);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					resultSet.next();
					upAmount = resultSet.getInt("amount");
				}
			}
			try (PreparedStatement preparedStatement = connection.prepareStatement(dateSql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					resultSet.next();

					dateValidate = resultSet.getDate("END_DATE");
				}
			}
			
			// Test validity
			if (upAmount > 0 && current.after(dateValidate)) {
				System.out.println("Coupon is available");
				return true;
			}

			System.out.println("Coupon is not available");
			return false;

		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

	@Override
	public ArrayList<Coupon> getCouponsByCustomer(int customerID) throws Exception {

		// init
		ArrayList<Coupon> customerCouponList = new ArrayList<Coupon>();
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();

			// prepare and execute query
			String sql = String.format("SELECT * FROM Coupons WHERE customer_id = %d", customerID);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					// get results and convert them into Coupon objects
					while (resultSet.next()) {
						int id = resultSet.getInt("id");
						int company_id = resultSet.getInt("company_id");
						int category_id = resultSet.getInt("category_id");
						String title = resultSet.getString("title");
						String description = resultSet.getString("description");
						Date start_date = resultSet.getDate("start_date");
						Date end_date = resultSet.getDate("end_date");
						int amount = resultSet.getInt("amount");
						double price = resultSet.getDouble("price");
						String image = resultSet.getString("image");

						Coupon coupon = new Coupon(id, company_id, category_id, title, description, image, start_date,
								end_date, amount, price);
						customerCouponList.add(coupon);
						customerCouponList = getCouponsByCstmr(customerID);
					}
					return customerCouponList;
				}
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}

	}

	@Override
	public ArrayList<Coupon> getCustomersCouponsByCategory(int categoryID, int customerID) throws Exception {
		// init
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();
			
			// prepare query
			String sql = String.format("SELECT FROM Coupons WHERE category_id = %d AND customer_id = %d",
					categoryID, customerID);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				// execute query
				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					// get results and convert them into Coupon objects
					ArrayList<Coupon> customerCouponCtgryList = new ArrayList<>();
					while (resultSet.next()) {
						int id = resultSet.getInt("COUPON_ID");
						int company_id = resultSet.getInt("COMPANY_ID");
						int category_id = resultSet.getInt("CATEGORY_ID");
						int amount = resultSet.getInt("AMOUNT");
						String title = resultSet.getString("TITLE");
						String description = resultSet.getString("DESCRIPTION");
						Date start_date = resultSet.getDate("START_DATE");
						Date end_date = resultSet.getDate("END_DATE");
						String image = resultSet.getString("IMAGE");
						double price = resultSet.getDouble("PRICE");

						Coupon coupon = new Coupon(id, company_id, category_id, title, description, image, start_date,
								end_date, amount, price);
						customerCouponCtgryList.add(coupon);
						customerCouponCtgryList = getCustomersCouponsByCtgry(categoryID, customerID);
					}
					return customerCouponCtgryList;
				}
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

	public ArrayList<Coupon> getCustomersCouponsByPrice(int customerID, double couponPrice) throws Exception {
		// init
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();
			
			// prepare query
			String sql = String.format("SELECT FROM Coupons WHERE customer_id = %d AND price <= %.2f",
					customerID, couponPrice);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				// execute
				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					// get results and convert them into Coupon objects
					ArrayList<Coupon> customerCouponPriceList = new ArrayList<>();
					while (resultSet.next()) {
						int id = resultSet.getInt("id");
						int company_id = resultSet.getInt("company_id");
						int category_id = resultSet.getInt("category_id");
						int amount = resultSet.getInt("amount");
						String title = resultSet.getString("title");
						String description = resultSet.getString("description");
						Date start_date = resultSet.getDate("start_date");
						Date end_date = resultSet.getDate("end_date");
						String image = resultSet.getString("image");
						double price = resultSet.getDouble("price");

						Coupon coupon = new Coupon(id, company_id, category_id, title, description, image, start_date,
								end_date, amount, price);
						customerCouponPriceList.add(coupon);
						customerCouponPriceList = getCustomersCouponsByPrice(customerID, couponPrice);
					}
					return customerCouponPriceList;
				}
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}
	
	public void deleteExpiredCoupons() throws Exception{
		System.out.println("Checking for expiared coupons...");
		Connection connection=null;
		try {
			connection=connectionPool.getConnection();
			String couponsSql="DELETE FROM Coupons WHERE end_date < CURDATE()";
			String historySql="DELETE FROM Customers_vs_Coupons WHERE end_date < CURDATE()";
			try (PreparedStatement preparedStatement = connection.prepareStatement(couponsSql)) {
				preparedStatement.executeUpdate();
			}
			try (PreparedStatement preparedStatement = connection.prepareStatement(historySql)) {
				System.out.println("Deleting coupon purchase history.");
				preparedStatement.executeUpdate();
			}

			System.out.println("Expired coupons deleted succesfully");
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}
	
}
