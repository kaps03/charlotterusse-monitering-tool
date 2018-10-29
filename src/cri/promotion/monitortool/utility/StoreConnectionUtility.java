package cri.promotion.monitortool.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class StoreConnectionUtility {

	private static Connection connection;
	private static Logger logger = Logger.getLogger(cri.promotion.monitortool.utility.StoreConnectionUtility.class);

	public static Connection getConnectionByStoreNumber(Integer storeNumber) {
		if (storeNumber == null || storeNumber.intValue() < 1) {
			logger.info("Store Id is null.");
			return null;
		}
		try {
			Properties properties = null;
				FileReader reader = new FileReader("src\\config.properties");
				properties = new Properties();
				properties.load(reader);
				Class.forName(properties.getProperty("sqlserver_driver_name"));
				
//			String url = properties.getProperty("store_sqlserver_url").replace("localhost", "CR"+storeNumber+"-1");
//			String url = properties.getProperty("store_sqlserver_url").replace("localhost", "storeNumber");
			
			String url = properties.getProperty("store_sqlserver_url");
			connection = DriverManager.getConnection(url,
					properties.getProperty("store_sqlserver_username"),
					properties.getProperty("store_sqlserver_password"));
			logger.info("Connection has established with database.");

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			logger.info("Store has closed.");
			return null;
		}
		
		return connection;

	}
}
