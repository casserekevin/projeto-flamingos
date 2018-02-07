package br.com.flamingos.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	private String driver;
	private String url;
	private String user;
	private String password;

	public ConnectionDB(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public ConnectionDB() {
		this.driver = "com.mysql.jdbc.Driver";
		this.url = "jdbc:mysql://localhost/db_flamingos";
		this.user = "root";
		this.password = "kevi1810";
	}

	public Connection createConnection() throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);

		return connection;

	}

}
