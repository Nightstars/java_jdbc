package com.christ.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtil2 {
	public static Connection getDBConnection() {
		Connection conn = null;
		Properties properties=new Properties();
		InputStream inputStream=JdbcUtil2.class.getResourceAsStream("/db.properties");
		try {
			properties.load(inputStream);
			String driver=properties.getProperty("driver");
			String url=properties.getProperty("url");
			String username=properties.getProperty("user");
			String password=properties.getProperty("password");
			Class.forName(driver);
			//通过driverManageer的getConnection方法获取连接对象
			conn=DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return conn;
	}
}
