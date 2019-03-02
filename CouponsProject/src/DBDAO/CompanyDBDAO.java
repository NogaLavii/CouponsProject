package DBDAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DAO.CompanyDAO;
import exceptionHandling.ObjectExists;
import javaBeans.Company;
import javaBeans.ConnectionPool;

public class CompanyDBDAO implements CompanyDAO<Company> {

	/**
	 * @author Vision
	 * @param Company company will let me manipulate data on the COMPANY table on
	 *                the DB
	 * @throws SQLException , Exception
	 */
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public boolean isCompanyExists(String email, String password) throws Exception {

		Connection connection = null; 

		try {
			connection = connectionPool.getConnection();

			String sql = String.format("SELECT Count(*) AS Count FROM COMPANIES WHERE EMAIL = "
					+ "'%s' AND PASSWORD = '%s'",
					email, password);

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

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
		if (isCompanyExists(company.getEmail(), company.getPassword())) {
			throw new ObjectExists("Error. This company exsits on the Data Base already.");
		} else {

			Connection connection = null;

			try {

				connection = connectionPool.getConnection();

				String sql = String.format(
						"INSERT INTO COMPANIES(COMPANY_NAME, EMAIL, PASSWORD) " + "VALUES('%s', '%s', '%s')",
						company.getName(), company.getEmail(), company.getPassword());

				try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
						PreparedStatement.RETURN_GENERATED_KEYS)) {

					preparedStatement.executeUpdate();
					System.out.println("Company added Succesefully !");
					try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
						resultSet.next();
						int id = resultSet.getInt(1);
						company.setId(id); // Add the new created id into the company object.
					}
				}
			} finally {
				connectionPool.restoreConnection(connection);
			}
		}

	}

	@Override
	public void updateCompany(Company company) throws Exception {
		Connection connection = null;

		try {

			connection = connectionPool.getConnection();

			String sql = String.format("UPDATE COMPANIES SET EMAIL='%s' , PASSWORD='%s' WHERE COMPANY_ID=%d",
					company.getEmail(),	company.getPassword(),company.getId());
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.executeUpdate();
				System.out.println("Company updated Succesfully !");
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}

	}

	@Override
	public void deleteCompany(int companyID) throws Exception {

		Connection connection = null;

		try {
			connection = connectionPool.getConnection();

			String sql = String.format("DELETE FROM COMPANIES WHERE COMPANY_ID=%d", companyID);
			String couponSql = String.format("DELETE FROM COUPONS WHERE  COMPANY_ID=%d", companyID);
			String custVSCop = String.format("DELETE FROM CUSTOMERS_VS_COUPONS WHERE COMPANY_ID=%d", companyID);
			System.out.println(sql + "| " + couponSql + "| " + custVSCop);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.executeUpdate();
				System.out.println("Delete success!");
			}
			try (PreparedStatement preparedStatement = connection.prepareStatement(couponSql)) {
				System.out.println("Deleting all company's Coupons");
				preparedStatement.executeBatch();
				System.out.println("Delete success!");
			}
			try (PreparedStatement preparedStatement = connection.prepareStatement(custVSCop)) {
				System.out.println("Deleting customers perchase history");
				preparedStatement.executeUpdate();
				System.out.println("Delete success and complete!");
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

	@Override
	public ArrayList<Company> getAllCompanies() throws Exception {

		Connection connection = null;

		try {
			connection = connectionPool.getConnection();

			String sql = "SELECT * FROM COMPANIES";

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					ArrayList<Company> allCompanies = new ArrayList<Company>();

					while (resultSet.next()) {

						int id = resultSet.getInt("COMPANY_ID");
						String name = resultSet.getString("COMPANY_NAME");
						String email = resultSet.getString("EMAIL");
						String password = resultSet.getString("PASSWORD");

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
	public Company getOneCompany(int companyID) throws Exception {
		Connection connection = null;

		try {
			connection = connectionPool.getConnection();

			String sql = String.format("SELECT * FROM COMPANIES WHERE COMPANY_ID=%d", companyID);

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					resultSet.next();

					String name = resultSet.getString("COMPANY_NAME");
					String email = resultSet.getString("EMAIL");
					String password = resultSet.getString("PASSWORD");

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
