package cri.promotion.monitortool.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class StoreConnectionUtility {

	private static Connection connection;

	public static Connection getConnectionByStoreNumber(Integer storeNumber) {
		if (storeNumber == null || storeNumber.intValue() < 1)
			return null;
		try {
			Properties properties = null;
				FileReader reader = new FileReader("src\\config.properties");
				properties = new Properties();
				properties.load(reader);
				Class.forName(properties.getProperty("sqlserver_driver_name"));
				
//			connection = DriverManager.getConnection(properties.getProperty(storeNumber + "_sqlserver_url"),
//					properties.getProperty(storeNumber + "_sqlserver_username"),
//					properties.getProperty(storeNumber + "_sqlserver_password"));
			String url = properties.getProperty("store_sqlserver_url").replace("localhost", "CR"+storeNumber+"-1");
			String url = properties.getProperty("store_sqlserver_url").replace("localhost", "storeNumber");
			
//			String url = properties.getProperty("store_sqlserver_url");
			connection = DriverManager.getConnection(url,
					properties.getProperty("store_sqlserver_username"),
					properties.getProperty("store_sqlserver_password"));

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;

	}
}
