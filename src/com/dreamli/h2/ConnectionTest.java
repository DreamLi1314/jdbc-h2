package com.dreamli.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionTest {
	public static void main(String[] args) throws Exception {
		
		Class.forName("org.h2.Driver");
		Connection connection = DriverManager.getConnection("jdbc:h2:./db/test", "dreamli", "dreamli");
		System.out.println(connection);
		Statement statement = connection.createStatement();
//		statement.executeUpdate("insert into users values(null, 'cc')");
		ResultSet resultSet = statement.executeQuery("select * from users");
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			System.out.println(id + "---" + name);
		}
		
		statement.close();
		connection.close();
	}
}
