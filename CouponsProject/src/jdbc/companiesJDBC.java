package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class companiesJDBC {
	/**
	 *  the jdbc companies file. contains connections and sql statements so that i can manipulate data on the db
	 */
	public static String USERNAME = "root";
	public static String PASSWORD = null;
	public static String URL = "jdbc:mysql://localhost:3306/ProjectConnection";
	public static void builtDB() {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "CREATE TABLE companies (" + "id INT PRIMARY KEY AUTO_INCREMENT, "
					+ "name VARCHAR(50) NOT NULL, " + "email VARCHAR (20) NOT NULL ,"
					+ " password VARCHAR (20) NOT NULL  )";

			statement = connection.createStatement();
			statement.executeUpdate(sql);

			System.out.println("companies Tabel successfuly created. ");
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

	public static void insert(String name, String email, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = String.format(" INSERT INTO conpanies (name, email, password) VALUES ('s%' , 's%' , 's%' ) ",
					name, email, password);
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
			String sql = "SELECT * FROM companies";
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");

				System.out.println("ID" + id + ".\nName: " + name + ".\neMail: " + email + ".\nPassword" + password);

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

	public static void update(int id, String name, String email, String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = String.format(
					"UPDATE companies SET name = '%s' , email = '%s' , password = '%s' WHERE id = %d", name, email,
					password);
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
			String sql = String.format("DELETE FROM companies WHERE id = %d ", id);
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
