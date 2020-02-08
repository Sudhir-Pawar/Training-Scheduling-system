 package com.zensar.tss.connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	
static Connection connection = null;
	
	public static Connection getConnection(){
		FileReader fileReader;
		try {
			fileReader = new FileReader("config.properties");
			Properties properties = new Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("drivername"));  
			  
			connection = DriverManager.getConnection(  
					properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
