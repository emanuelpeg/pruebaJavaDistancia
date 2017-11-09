package com.gugler.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		String sql = "select email, fullname from user";
		String url = "jdbc:mysql://127.0.0.1:3306/prueba?user=root&password=titocosa";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("full name: " + rs.getString(2));
				System.out.println("email : " + rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

	}
}
