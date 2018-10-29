package cri.promotion.monitortool.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author kapil.Soni
 * 
 */

public class GetConnection {

	private static Logger logger = Logger.getLogger(cri.promotion.monitortool.utility.GetConnection.class);
	private static Connection connection = null;

	public static void main(String[] args) {

		Properties prop = new Properties();
		InputStream input = null;
		
		System.out.println(DBConnectionWithStore.getConnection());

		try {
			if (connection == null) {
				input = new FileInputStream("config.properties");
				// load a properties file
				prop.load(input);
				// Load driver
				String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				Class.forName(driverName);
				// Create a connection to the database
				String hostName = prop.getProperty("dbhostName");
				String serverPort = prop.getProperty("dbserverPort");
				String database = hostName + ":" + serverPort;
				String url = "jdbc:sqlserver://" + database;
				String username = prop.getProperty("dbusername");
				String password = prop.getProperty("dbpassword");
				connection = DriverManager.getConnection(url, username, password);
				System.out.println("");
				logger.info("Successfully Connected to the database hostname:  " + hostName);
				if (connection != null) {
					DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
					logger.info("Driver name: " + dm.getDriverName());
					logger.info("Driver version: " + dm.getDriverVersion());
					logger.info("Product name: " + dm.getDatabaseProductName());
					logger.info("Product version: " + dm.getDatabaseProductVersion());

				}
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			logger.error("Could not find the database driver " + e.getMessage());
		} catch (SQLException e) {
			logger.error("Could not connect to the database " + e.getMessage());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			logger.info("Check for open connections");
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			logger.info("connections closed");

		}

	}

}
