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
	 * @param customer allows to manipulate data in the Customers table in the database
	 * @throws Exception , SQLException
	 */
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public boolean doesCustomerExist(String email, String password) throws Exception {
		// init
		Connection connection = null;
		try {
			// get connection
			connection = connectionPool.getConnection();
			// prepare query
			String sql = String.format("SELECT COUNT(*) AS count FROM Customers WHERE email = '%s' AND password = '%s'",
					email, password);

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				// execute
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					resultSet.next();

					// return answer
					int count = resultSet.getInt("count");

					return count > 0;
				}
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}

	}

	@Override
	public void addCustomer(Customer customer) throws Exception {
		if (doesCustomerExist(customer.getEmail(), customer.getPassword())) {
			throw new ObjectExists("This Customer already exists in the database");
		} else {
			// init
			Connection connection = null;

			try {
				// get connection
				connection = connectionPool.getConnection();
				
				// prepare query
				String sql = String.format(
						"INSERT INTO Customers (first_name, last_name, email, password) VALUES('%s', '%s', '%s','%s')",
						customer.getFirst_name(), customer.getLast_name(), customer.getEmail(), customer.getPassword());

				try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
						PreparedStatement.RETURN_GENERATED_KEYS)) {
					// execute
					preparedStatement.executeUpdate();

					// get new id assigned by db
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
		// init
		Connection connection = null;

		try {
			// get connection
			connection = connectionPool.getConnection();
			
			// prepare query
			String sql = String.format(
					"UPDATE Customers SET first_name = '%s', last_name = '%s', email = '%s', password = '%s' WHERE customer_id = %d",
					customer.getFirst_name(), customer.getLast_name(), customer.getEmail(), customer.getPassword(),
					customer.getId());
			System.out.println("Customer updated succesfully!");
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

			String sql = String.format("DELETE FROM Customers WHERE customer_id = %d", customerID);
			String cstmrSql = String.format("DELETE FROM Customers_vs_Coupons WHERE customer_id = %d", customerID);
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.executeUpdate();
				System.out.println("Deleted Succesfully");
			}
			try (PreparedStatement preparedStatement = connection.prepareStatement(cstmrSql)) {
				System.out.println("Deleting all customer purchase history.");
				preparedStatement.executeUpdate();
				System.out.println("Deleted succsesfully");
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

			String sql = "SELECT * FROM Customers";

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					ArrayList<Customer> allCustomers = new ArrayList<Customer>();

					while (resultSet.next()) {

						int id = resultSet.getInt("customer_id");
						String first_name = resultSet.getString("first_name");
						String last_name = resultSet.getString("last_name");
						String email = resultSet.getString("email");
						String password = resultSet.getString("password");

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
	public Customer getCustomerByID(int customerID) throws Exception {

		Connection connection = null;

		try {
			connection = connectionPool.getConnection();

			String sql = String.format("SELECT * FROM Customers WHERE customer_id = %d", customerID);

			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {

					resultSet.next();

					int id = resultSet.getInt("customer_id");
					String first_name = resultSet.getString("first_name");
					String last_name = resultSet.getString("last_name");
					String email = resultSet.getString("email");
					String password = resultSet.getString("password");

					Customer customer = new Customer(id, first_name, last_name, email, password);
					System.out.println(customer.toString());
					return customer;
				}
			}
		} finally {
			connectionPool.restoreConnection(connection);
		}
	}

}
