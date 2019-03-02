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
	 * @param coupon will let me manipulate data on the COUPON table's data members
	 *               on the DB
	 * @throws Exception , SQLException
	 */
	// private ConnectionPool connectionPool;
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public boolean isCouponExists(String title, int companyID) throws Exception {
		Connection connection = null;

		try {
			connection = connectionPool.getConnection();
			String sql = String.format("SELECT Count(*) AS Count FROM COUPONS WHERE TITLE = '%s' AND COMPANY_ID='%s'  ",
					title, companyID);

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					resultSet.next();
					int count = resultSet.getInt("Count");
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

	public boolean isCouponPurchaseExists(int customerID, int couponID) throws Exception {
		Connection connection = null;
		try {
			connection = connectionPool.getConnection();
			String sql = String.format(
					"SELECT COUNT(*) AS COUNT FROM CUSTOMERS_VS_COUPONS WHERE CUSTOMER_ID=%d AND COUPON_ID=%d",
					customerID, couponID);

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
		if (isCouponExists(coupon.getTitle(), coupon.getCompany_id())) {
			throw new ObjectExists("This Coupon already exists on the Data Base");
		} else {

			Connection connection = null;
			try {
				System.out.println("entering");
				connection = connectionPool.getConnection();
				String sql = String.format(
						"INSERT INTO COUPONS(company_id ,category_id ,title ,description ,"
								+ " start_date , end_date, amount, price, image) "
								+ "VALUES (%d, %d, '%s', '%s','%s', '%s', %d, '%.2f', '%s' ) ",
						coupon.getCompany_id(), coupon.getCategory_id(), coupon.getTitle(), coupon.getDescription(),
						new java.sql.Date(coupon.getStart_date().getTime()),new java.sql.Date(coupon.getEnd_date().getTime()),
						coupon.getAmount(), coupon.getPrice(),coupon.getImage());

				try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
						PreparedStatement.RETURN_GENERATED_KEYS)) {

					preparedStatement.executeUpdate();

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

		Connection connection = null;
		try {
			connection = connectionPool.getConnection();
			String sql = String.format(
					" UPDATE COUPONS SET  CATEGORY_ID=%d, TITLE = '%s',DESCRIPTION='%s',START_DATE= %tD,"
							+ "END_DATE=%tD,AMOUNT=%d, PRICE= %.2f,IMAGE= '%s' WHERE COUPON_ID = %d",
					coupon.getCategory_id(), coupon.getTitle(), coupon.getDescription(), coupon.getStart_date(),
					coupon.getEnd_date(), coupon.getPrice(), coupon.getImage(), coupon.getId());
			System.out.println("update coupons has done");
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.executeUpdate();
				System.out.println("Coupon Updated Succesfully");
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}

	}

	public ArrayList<Coupon> getAllCoupons(int companyId) throws Exception {
		Connection connection = null;

		try {
			connection = connectionPool.getConnection();

			String sql = String.format("SELECT * FROM COUPONS WHERE COMPANY_ID=%d", companyId);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					ArrayList<Coupon> AllCoupons = new ArrayList<Coupon>();

					while (resultSet.next()) {
						int id = resultSet.getInt("COUPON_ID");
						int company_id = resultSet.getInt("COMPANY_ID");
						int category_id = resultSet.getInt("CATEGORY_ID");
						String title = resultSet.getString("TITLE");
						String description = resultSet.getString("DESCRIPTION");
						Date start_date = resultSet.getDate("START_DATE");
						Date end_date = resultSet.getDate("END_DATE");
						int amount = resultSet.getInt("AMOUNT");
						double price = resultSet.getDouble("PRICE");
						String image = resultSet.getString("IMAGE");

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

	public ArrayList<Coupon> getCouponsByCtgry(int categoryID, int companyID) throws Exception {
		ArrayList<Coupon> catgoryCouponList = new ArrayList<Coupon>();
		
		Connection connection = null;

		try {
			connection = connectionPool.getConnection();

			String sql = String.format("SELECT * FROM COUPONS WHERE CATEGORY_ID=%d AND COMPANY_ID=%d", categoryID,
					companyID);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					while (resultSet.next()) {
						int id = resultSet.getInt("COUPON_ID");
						int company_id = resultSet.getInt("COMPANY_ID");
						int category_id = resultSet.getInt("CATEGORY_ID");
						String title = resultSet.getString("TITLE");
						String description = resultSet.getString("DESCRIPTION");
						Date start_date = resultSet.getDate("START_DATE");
						Date end_date = resultSet.getDate("END_DATE");
						int amount = resultSet.getInt("AMOUNT");
						double price = resultSet.getDouble("PRICE");
						String image = resultSet.getString("IMAGE");

						Coupon coupon = new Coupon(id, company_id, category_id, title, description, image, start_date,
								end_date, amount, price);
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

	public Coupon getOneCoupon(int couponID) throws Exception {

		Connection connection = null;

		try {
			connection = connectionPool.getConnection();

			String sql = String.format("SELECT * FROM COUPONS WHERE COUPON_ID=%d", couponID);

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					resultSet.next();
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
					return coupon;

				}
			}
		} finally {
			connectionPool.restoreConnection(connection);

		}
	}

	@Override
	public void deleteCoupon(int couponID) throws Exception {
		Connection connection = null;

		try {

			connection = connectionPool.getConnection();

			String sql = String.format("DELETE FROM COUPONS WHERE COUPON_ID=%d", couponID);
			String custSql = String.format("DELETE FROM CUSTOMERSVSCOUPONS WHERE COUPON_ID=%d", couponID);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.executeUpdate();
			}
			try (PreparedStatement preparedStatement = connection.prepareStatement(custSql)) {
				System.out.println("Deleting coupon purchase history.");
				preparedStatement.executeUpdate();
			}
			System.out.println("Deleted succesfully");
		} finally {
			connectionPool.restoreConnection(connection);
		}

	}

	@Override
	public void addCouponPurchase(int customerID, int couponID) throws Exception {

		if (!isCouponAvailble(couponID) || isCouponPurchaseExists(customerID, couponID)) {
			throw new ObjectExists("Coupon is not available");
		} else {
			Connection connection = null;
			try {
				connection = connectionPool.getConnection();
				String sql = String.format("INSERT INTO CUSTOMERS_VS_COUPONS(CUSTOMER_ID , COUPON_ID)VALUES(%d, %d)",
						customerID, couponID);
				String amountSet = String.format("UPDATE COUPONS SET AMOUNT=(AMOUNT-1) WHERE COUPON_ID=%d ", couponID);
				try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
						PreparedStatement.RETURN_GENERATED_KEYS)) {

					preparedStatement.executeUpdate();
					System.out.println("Coupon purchase succesfully");

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

		Connection connection = null;

		try {

			connection = connectionPool.getConnection();

			String sql = String.format("DELETE FROM CUSTOMERS_VS_COUPONS WHERE COUPON_ID=%d", couponID);

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.executeUpdate();
				System.out.println("Delete coupon purchase complete.");
			}

		} finally {
			connectionPool.restoreConnection(connection);
		}

	}

	public ArrayList<Coupon> getCouponsByPrice(int companyID, double couponPrice) throws Exception {

		Connection connection = null;

		try {

			connection = connectionPool.getConnection();
			String sql = String.format("SELECT FROM COPOUNS WHERE COMPANY_ID=%d AND PRICE =%.2f", companyID,
					couponPrice);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					ArrayList<Coupon> couponPriceList = new ArrayList<>();
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
		Connection connection = null;
		int upAmount = 0;
		Date dateValidate = new Date();
		Date current = new Date();
		try {
			connection = connectionPool.getConnection();

			String sql = String.format("SELECT AMOUNT FROM COUPONS WHERE COUPON_ID=%d", couponID);
			String dateSql = String.format("SELECT END_DATE FROM COUPONS WHERE COUPON_ID=%d", couponID);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					resultSet.next();
					upAmount = resultSet.getInt("AMOUNT");
				}
			}
			try (PreparedStatement preparedStatement = connection.prepareStatement(dateSql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					resultSet.next();

					dateValidate = resultSet.getDate("END_DATE");
				}
			}
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
	public ArrayList<Coupon> getCouponsByCstmr(int customerID) throws Exception {

		ArrayList<Coupon> customerCouponList = new ArrayList<Coupon>();
		Connection connection = null;

		try {
			connection = connectionPool.getConnection();

			String sql = String.format("SELECT * FROM COUPONS WHERE CUSTOMER_ID=%d", customerID);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					while (resultSet.next()) {
						int id = resultSet.getInt("COUPON_ID");
						int company_id = resultSet.getInt("COMPANY_ID");
						int category_id = resultSet.getInt("CATEGORY_ID");
						String title = resultSet.getString("TITLE");
						String description = resultSet.getString("DESCRIPTION");
						Date start_date = resultSet.getDate("START_DATE");
						Date end_date = resultSet.getDate("END_DATE");
						int amount = resultSet.getInt("AMOUNT");
						double price = resultSet.getDouble("PRICE");
						String image = resultSet.getString("IMAGE");

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
	public ArrayList<Coupon> getCustomersCouponsByCtgry(int categoryID, int customerID) throws Exception {
		Connection connection = null;

		try {

			connection = connectionPool.getConnection();
			String sql = String.format("SELECT FROM COPOUNS WHERE CATEGORY_ID=%d AND CUSTOMER_ID=%d", categoryID,
					customerID);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

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
		Connection connection = null;

		try {

			connection = connectionPool.getConnection();
			String sql = String.format("SELECT FROM COPOUNS WHERE CUSTOMER_ID=%d AND PRICE<=%.2f", customerID,
					couponPrice);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					ArrayList<Coupon> customerCouponPriceList = new ArrayList<>();
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
	
	public void deleteExpCoupons() throws Exception{
		System.out.println("Checking for expiared coupons");
		Connection connection=null;
		try {
			connection=connectionPool.getConnection();
			String couponsSql="DELETE FROM COUPONS WHERE END_DATE < CURDATE()";
			String historySql="DELETE FROM CUSTOMERS_VS_COUPONS WHERE END_DATE < CURDATE()";
			try (PreparedStatement preparedStatement = connection.prepareStatement(couponsSql)) {
				preparedStatement.executeUpdate();
			}
			try (PreparedStatement preparedStatement = connection.prepareStatement(historySql)) {
				System.out.println("Deleting coupon purchase history.");
				preparedStatement.executeUpdate();
			}

			System.out.println("Deleted succesfully");
		} finally {
			connectionPool.restoreConnection(connection);
		}

	
	}
	
	
}
