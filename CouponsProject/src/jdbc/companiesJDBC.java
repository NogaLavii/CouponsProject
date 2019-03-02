package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompaniesJDBC {
	/**
	 *  companiesJBDC contains connections and sql statements to manipulate data in the Companies table in the DB
	 */
	public static String USERNAME = "root";
	public static String PASSWORD = null;
	public static String URL = "jdbc:mysql://localhost:3306/ProjectConnection";
	public static void buildDB()
	{
		// init
		Connection connection = null;
		Statement statement = null;

		try {
			// get connection
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// prepare query
			String sql = "CREATE TABLE Companies (" + "id INT PRIMARY KEY AUTO_INCREMENT, "
					+ "name VARCHAR(50) NOT NULL, " + "email VARCHAR (20) NOT NULL ,"
					+ " password VARCHAR (20) NOT NULL  )";
			statement = connection.createStatement();
			
			// execute query
			statement.executeUpdate(sql);

			// report success
			System.out.println("Companies tabel created successfuly");
			
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
		
		// init
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// get connection
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			// prepare query
			String sql = String.format("INSERT INTO Conpanies (name, email, password) VALUES ('s%' , 's%' , 's%')",
					name, email, password);
			preparedStatement = connection.prepareStatement(sql);
			
			// execute statement
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if (connection != null) {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void readAll() {
		
		// init
		Connection connection = null;
		Statement statement = null;
		
		try {
			// get connection and statement
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			
			// prepare and execute query
			String sql = "SELECT * FROM companies";
			ResultSet resultSet = statement.executeQuery(sql);

			// report results
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");

				System.out.println("ID: " + id + "\nName: " + name + "\nemail: " + email + "\nPassword" + password);
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
		
		// init
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			// get connection
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			// prepare query
			String sql = String.format("UPDATE Companies SET name = '%s', email = '%s', password = '%s' WHERE id = %d",
					name, email, password);
			preparedStatement = connection.prepareStatement(sql);

			// execute query
			preparedStatement.executeQuery(sql);
			
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

		// init
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// get connection
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			// prepare query
			String sql = String.format("DELETE FROM Companies WHERE id = %d ", id);
			preparedStatement = connection.prepareStatement(sql);
			
			// execute statement
			int res = preparedStatement.executeUpdate();
			
			// report success
			if (res != 0)
				System.out.println("Deleted Succesfully");

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
