package cri.promotion.monitortool.utility;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/*
 * @author Kapil.Soni
 */

public class DBConnectionWithXRelate {

	private static Connection connection;

	private DBConnectionWithXRelate() {
	}

	public static Connection getConnection() {
		try {
			if (connection == null) {
				FileReader reader = new FileReader("src\\config.properties");
				Properties properties = new Properties();
				properties.load(reader);
				Class.forName(properties.getProperty("sqlserver_driver_name"));
				connection = DriverManager.getConnection(properties.getProperty("xrelate_sqlserver_url"),
						properties.getProperty("xrelate_sqlserver_username"), properties.getProperty("xrelate_sqlserver_password"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException exception) {

		}

		return connection;

	}
}
