package javaBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPool {
	/**
	 * this is the connection pool, from here i can pull connections
	 * jdbc:mysql://127.0.0.1:3306/?user=root
	 */
	public static String USERNAME = "root";
	public static String PASSWORD = null;
	public static String URL = "jdbc:mysql://localhost:3306/projectdb";

	// -----------------------Singleton---------------------

	public static ConnectionPool instance = new ConnectionPool();

	// --------------------a Stack to hold connections---------------
	public Stack<Connection> connections = new Stack<>();

	// --------------------fill up the stack with connections------------
	private ConnectionPool() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {}
		
		for (int i = 1; i < 10; i++) {
			try {
			
				Connection conn = DriverManager.getConnection(URL, "root", null);
				connections.push(conn);
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			} 
		}
	}

	/**
	 * get a connection from the stack (if its empty wait, it will fill up in a sec)
	 * 
	 * @return void
	 * @throws InterruptedException its JAVA built-in exception
	 */

	// ---------------get the single to instance-----------------
	public static ConnectionPool getInstance() {

		return instance;
	}

	public Connection getConnection() throws InterruptedException {

		synchronized (connections) {

			if (connections.isEmpty()) {
				connections.wait();
			}

			return connections.pop();
		}
	}

	/**
	 * restore the connection after finish with it and notify to the fellow threads
	 * 
	 * @param conn is a connection instance
	 */
	public void restoreConnection(Connection conn) {
		synchronized (connections) {
			connections.push(conn);
			connections.notify();
		}
	}

	// ------------------close all the connections-----------------------
	public void closeAllConnections() throws InterruptedException {
		synchronized (connections) {
			while (connections.size() < 10) {
				connections.wait();

			}
			for (Connection conn : connections) {
				try {
					conn.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
