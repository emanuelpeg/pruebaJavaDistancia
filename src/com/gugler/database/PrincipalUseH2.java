package com.gugler.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrincipalUseH2 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select nombre from usuario";
		String url = "jdbc:h2:~/test";
		try {
			Class.forName("org.h2.Driver").newInstance();
			Connection con = DriverManager.getConnection(url,"sa","");
			//createTables(con);
			//insertTables(con);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("name : " + rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}

	private static void createTables(Connection con) throws SQLException {
		Statement st = con.createStatement();
		st.execute("CREATE TABLE mensajes ("
				+ "id int(11) NOT NULL AUTO_INCREMENT, "
				+ "id_usuario_origen int(11) NOT NULL, "
				+ "id_usuario_destino int(11) NOT NULL, "
				+ "mensaje text NOT NULL, PRIMARY KEY (id))");
		st.execute("CREATE TABLE usuario ("
				  +"id int(11) NOT NULL AUTO_INCREMENT,"
				  +"nombre varchar(20) NOT NULL,"
				  +"password varchar(20) NOT NULL,"
				  +"PRIMARY KEY (id))");
		st.close();
	}
	
	private static void insertTables(Connection con) throws SQLException {
		Statement st = con.createStatement();
		st.execute("insert into usuario values (60,'Alverto','pass123')");
		st.close();
	}

}
