package DBDAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DAO.CompanyDAO;
import exceptionHandling.ObjectExists;
import javaBeans.Company;
import javaBeans.ConnectionPool;
import javaBeans.Coupon;

public class CompanyDBDAO implements CompanyDAO<Company> {

	/**
	 * @author Vision
	 * @param CompanyDBDAO allows to manipulate data in the Companies table in the DB
	 * @throws SQLException, Exception
	 */
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public boolean doesCompanyExist(String email, String password) throws Exception
	{
		// init Connection object
		Connection connection = null; 

		try {
			// get connection
			connection = connectionPool.getConnection();

			// prepare query
			String sql = String.format("SELECT Count(*) AS Count FROM Companies WHERE email = "
					+ "'%s' AND password = '%s'", email, password);

			// Execute query
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					
					// test whether company is returned from the db
					resultSet.next();
					int count = resultSet.getInt("Count");
					return count > 0;
				}
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

	@Override
	public void addCompany(Company company) throws Exception {
		
		if (doesCompanyExist(company.getEmail(), company.getPassword())) {
			// If the company already exists in the db - bail out
			throw new ObjectExists("Error. This company exsits on the Data Base already.");
		}
		else {

			// init Connection
			Connection connection = null;

			try {
				// get connection
				connection = connectionPool.getConnection();

				// prepare query
				String sql = String.format(
						"INSERT INTO Companies(company_name, email, password) " + "VALUES('%s', '%s', '%s')",
						company.getName(), company.getEmail(), company.getPassword());
				
				// execute query
				try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
						PreparedStatement.RETURN_GENERATED_KEYS)) {

					preparedStatement.executeUpdate();
					
					// report success
					System.out.println("Company added Succesefully");
					try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
						resultSet.next();
						int id = resultSet.getInt(1);
						// add the newly created id to the company object.
						company.setId(id);
					}
				}
			} finally {
				connectionPool.restoreConnection(connection);
			}
		}
	}

	@Override
	public void updateCompany(Company company) throws Exception {
		// init Connection
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();

			// prepare and execute query
			String sql = String.format("UPDATE Companies SET email = '%s', password = '%s' WHERE company_id = %d",
					company.getEmail(),	company.getPassword(), company.getId());
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.executeUpdate();
				
				// report success
				System.out.println("Company updated Succesfully !");
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

	@Override
	public void deleteCompany(int companyID) throws Exception {

		// init Connection
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();

			// prepare queries to remove company and its coupons from all relevant tables
			CouponDBDAO couponDBDAO = new CouponDBDAO();
			ArrayList<Coupon> coupons = couponDBDAO.getCouponsByCompany(companyID);
			for (Coupon coupon : coupons) {
				String custVSCop = String.format("DELETE FROM Customers_vs_Coupons WHERE coupon_id = %d", coupon.getId());
				try (PreparedStatement preparedStatement = connection.prepareStatement(custVSCop)) {
					preparedStatement.executeUpdate();
					System.out.println("Coupon deleted from Customers_vs_Coupons");
				}
			}
			
			String sql = String.format("DELETE FROM Companies WHERE company_id = %d", companyID);
			String couponSql = String.format("DELETE FROM Coupons WHERE  company_id = %d", companyID);
			
			
			System.out.println(sql + "| " + couponSql);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.executeUpdate();
				System.out.println("Delete success!");
			}
			try (PreparedStatement preparedStatement = connection.prepareStatement(couponSql)) {
				System.out.println("Deleting all company's Coupons");
				preparedStatement.executeBatch();
				System.out.println("Delete success!");
			}

		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

	@Override
	public ArrayList<Company> getAllCompanies() throws Exception {

		// init Connection
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();

			// prepare query
			String sql = "SELECT * FROM Companies";

			// execute query
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					// get results and convert them to Company objects
					ArrayList<Company> allCompanies = new ArrayList<Company>();

					while (resultSet.next()) {

						int id = resultSet.getInt("company_id");
						String name = resultSet.getString("company_name");
						String email = resultSet.getString("email");
						String password = resultSet.getString("password");

						Company company = new Company(id, name, email, password);

						allCompanies.add(company);
					}
					System.out.println(allCompanies.toString());
					return allCompanies;
				}
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

	@Override
	public Company getCompanyByID(int companyID) throws Exception {
		
		// init Connection
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();

			// prepare query
			String sql = String.format("SELECT * FROM Companies WHERE company_id = %d", companyID);

			// execute query
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					// Select requested company from results and convert it to Company object
					resultSet.next();

					String name = resultSet.getString("company_name");
					String email = resultSet.getString("email");
					String password = resultSet.getString("password");

					Company company = new Company(companyID, name, email, password);
					System.out.println(company);
					return company;
				}
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

}
