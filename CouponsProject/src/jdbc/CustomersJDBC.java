package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomersJDBC {
	/**
	 *  the jdbc customers file. contains connections and sql statements so that i can manipulate data on the db
	 */
	public static String USERNAME = "root";
	public static String PASSWORD = null;
	public static String URL = "jdbc:mysql://localhost:3306";

	public static void builtDB() {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "CREATE TABLE customers (" + "id INT PRIMARY KEY AUTO_INCREMENT, "
					+ "first_name VARCHAR (20) NOT NULL, " + "last_name VARCHAR (20) NOT NULL ,"
					+ " email VARCHAR (20) NOT NULL  " + " password VARCHAR (20) NOT NULL  )";

			statement = connection.createStatement();
			statement.executeUpdate(sql);

			System.out.println("customers Tabel successfuly created. ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (connection != null)
				try {
					statement.close();
					connection.close();

				} catch (SQLException e2) {
					System.out.println(e2.getMessage());
				}

		}
	}

	public static void insert(int id, String first_name, String last_name, String email, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = String.format(
					" INSERT INTO customers (first_name , last_name , email , password) VALUES ( 's%' , 's%', 's%', 's%' ) ",
					first_name, last_name, email, password);
			preparedStatement = connection.prepareStatement(sql);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if (connection != null)
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

	public static void readAll() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			String sql = "SELECT * FROM customers";
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String first_name = resultSet.getString("first_name");
				String last_name = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");

				System.out.println("ID" + id + ".\nFirst Name: " + first_name + "\nLastName" + last_name + ".\neMail: "
						+ email + ".\nPassword" + password);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (connection != null)
				try {
					connection.close();
					statement.close();

				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
		}
	}

	public static void update(int id, String first_name, String last_name, String email, String password)
			throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = String.format(
					"UPDATE customers SET first_name = '%s' ,last_name = '%s',  email = '%s' , password = '%s' WHERE id = %d",
					first_name, last_name, email, password);
			preparedStatement = connection.prepareStatement(sql);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			if (connection != null)
				try {
					preparedStatement.close();
					connection.close();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
		}

	}

	public static void delete(int id) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = String.format("DELETE FROM customers WHERE id = %d ", id);
			preparedStatement = connection.prepareStatement(sql);
			int res = preparedStatement.executeUpdate();
			if (res != 0)
				System.out.println("Delete Succesfully Executed ");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		finally {
			if (connection != null)
				try {
					connection.close();
					preparedStatement.close();

				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}

		}
	}

}
