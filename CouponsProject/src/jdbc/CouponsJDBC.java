 package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CouponsJDBC {
	/**
	 *  the jdbc coupons file. contains connections and sql statements so that i can manipulate data on the db
	 */
	public static String USERNAME = "root";
	public static String PASSWORD = null;
	public static String URL = "jdbc:mysql://localhost:3306";

	public static void builtDB() {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "CREATE TABLE coupons (" + "id INT PRIMARY KEY AUTO_INCREMENT, " + "copany_id INT NOT NULL, "
					+ "category_id INT  NOT NULL ," + "title VARCHAR (80) NOT NULL "
					+ " description VARCHAR (250) NOT NULL " + "start_date DATE NOT NULL," + "end_date DATE NOT NUll,"
					+ "amount INT NOT NULL," + " price DOUBLE NOT NULL," + "image VARCHAR (50) )";

			statement = connection.createStatement();
			statement.executeUpdate(sql);

			System.out.println("Coupons Tabel successfuly created. ");
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

	public static void insert(int id, int company_id, int category_id, String title, String description,
			Date start_date, Date end_date, int amount, double price, String image) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = String.format(
					" INSERT INTO coupuns (company_id ,category_id ,title ,description , start_date , end_date, amount, price, image) "
							+ "VALUES (d%, d%, 's%', 's%', %tD, %tD, %d, %.2f, 's%' ) ",
					company_id, category_id, title, description, start_date, end_date, amount, price, image);
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
			String sql = "SELECT * FROM coupons";
			ResultSet resultSet = statement.executeQuery(sql);

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

				System.out.println("ID: " + id + ".\nCompany ID: " + company_id + "\nCategory ID: " + category_id
						+ ".\nTitle: " + title + ".\nDescription: " + description + "\nStart Date: " + start_date
						+ "\nEnd Date: " + end_date + "\nAmont of Coupons: " + amount + "\nPrice: " + price
						+ "\nImage: " + image);

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

	public static void update(int id, int company_id, int category_id, String title, String description,
			Date start_date, Date end_date, int amount, double price, String image) throws SQLException {
		
			Connection connection = null;
			PreparedStatement preparedStatement = null;
		
			try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = String.format(
					"UPDATE coupons SET company_id =%d ,category_id = %d, title = '%s' ,desciption = '%s',"
					+ " start_date = %tD, end_date = %tD, amount= %d, price = %.2f, image='%s' WHERE id = %d",
					company_id, category_id, title, description, start_date, end_date, amount, price, image);
			
			
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
			String sql = String.format("DELETE FROM coupons WHERE id = %d ", id);
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
