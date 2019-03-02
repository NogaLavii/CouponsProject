package DBDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DAO.CustomerDAO;
import exceptionHandling.ObjectExists;
import javaBeans.Customer;
import javaBeans.ConnectionPool;

public class CustomerDBDAO implements CustomerDAO<Customer> {
	/**
	 * @param customer will let me manipulate data on the CUSTOMER table's data
	 *                 members on the DB
	 * @throws Exception , SQLException
	 */
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public boolean isCustomerExists(String email, String password) throws Exception {
		Connection connection = null;
		try {
			connection = connectionPool.getConnection();

			String sql = String.format("SELECT Count(*) AS Count FROM CUSTOMERS WHERE EMAIL ='%s' AND PASSWORD = '%s'",
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
	public void addCustomer(Customer customer) throws Exception {
		if (isCustomerExists(customer.getEmail(), customer.getPassword())) {
			throw new ObjectExists("This Customer already exists on the Data Base");
		} else {

			Connection connection = null;

			try {

				connection = connectionPool.getConnection();

				String sql = String.format(
						"INSERT INTO CUSTOMERS (FIRST_NAME,LAST_NAME, EMAIL, PASSWORD) VALUES('%s', '%s', '%s','%s')",
						customer.getFirst_name(), customer.getLast_name(), customer.getEmail(), customer.getPassword());

				try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
						PreparedStatement.RETURN_GENERATED_KEYS)) {

					preparedStatement.executeUpdate();

					try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
						resultSet.next();
						int id = resultSet.getInt(1);
						customer.setId(id); // Add the new created id into the customer object.
						System.out.println("Customer added Succesfully!");
					}
				}
			} finally {
				connectionPool.restoreConnection(connection);
			}
		}
	}

	@Override
	public void updateCustomer(Customer customer) throws Exception {

		Connection connection = null;

		try {

			connection = connectionPool.getConnection();

			String sql = String.format(
					"UPDATE CUSTOMERS SET FIRST_NAME='%s', LAST_NAME='%s', EMAIL='%s', PASSWORD='%s' WHERE CUSTOMER_ID=%d",
					customer.getFirst_name(), customer.getLast_name(), customer.getEmail(), customer.getPassword(),
					customer.getId());
			System.out.println("Updated Succesfully!");
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			connectionPool.restoreConnection(connection);
		}

	}

	@Override
	public void deleteCustomer(int customerID) throws Exception {

		Connection connection = null;

		try {

			connection = connectionPool.getConnection();

			String sql = String.format("DELETE FROM CUSTOMERS WHERE CUSTOMER_ID=%d", customerID);
			String cstmrSql = String.format("DELETE FROM CUSTOMERS_VS_COUPONS WHERE CUSTOMER_ID=%d", customerID);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.executeUpdate();
				System.out.println("Deleted Succesfully");
			}
			try (PreparedStatement preparedStatement = connection.prepareStatement(cstmrSql)) {
				System.out.println("Deleting all customer purchase history.");
				preparedStatement.executeUpdate();
				System.out.println("Delete succsesful!");
			}

		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

	@Override
	public ArrayList<Customer> getAllCustomers() throws Exception {
		Connection connection = null;

		try {
			connection = connectionPool.getConnection();

			String sql = "SELECT * FROM CUSTOMERS";

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					ArrayList<Customer> allCustomers = new ArrayList<Customer>();

					while (resultSet.next()) {

						int id = resultSet.getInt("CUSTOMER_ID");
						String first_name = resultSet.getString("FIRST_NAME");
						String last_name = resultSet.getString("LAST_NAME");
						String email = resultSet.getString("EMAIL");
						String password = resultSet.getString("PASSWORD");
						allCustomers = getAllCustomers();

						Customer customer = new Customer(id, first_name, last_name, email, password);

						allCustomers.add(customer);
					}

					return allCustomers;
				}
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

	@Override
	public Customer getOneCustomer(int customerID) throws Exception {

		Connection connection = null;

		try {
			connection = connectionPool.getConnection();

			String sql = String.format("SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID=%d", customerID);

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					resultSet.next();

					int id = resultSet.getInt("CUSTOMER_ID");
					String first_name = resultSet.getString("FIRST_NAME");
					String last_name = resultSet.getString("LAST_NAME");
					String email = resultSet.getString("EMAIL");
					String password = resultSet.getString("PASSWORD");

					Customer customer = new Customer(id, first_name, last_name, email, password);
					System.out.println("get one customer complete"+customer.toString());
					return customer;
				}
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

}
