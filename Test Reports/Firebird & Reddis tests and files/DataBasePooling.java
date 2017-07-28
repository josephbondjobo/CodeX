package com.reroute.tools;

import javax.sql.DataSource;
import org.apache.log4j.Logger;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataBasePooling {
	static Logger log = Logger.getLogger(DataBasePooling.class.getName());

	private static GetProperties getproperties = new GetProperties();
	private static DataSource datasource;

	//----------------------------
	public static DataSource setConnection(String pDirName) {
		String url = "";

		if (datasource == null) {
			HikariConfig config = new HikariConfig();
			// config.setDriverClassName("");

			String os = System.getProperty("os.name");

			if (os.startsWith("W")) {
				String serverName = "localhost";
				String mydatabase = pDirName; //
				url = "jdbc:firebirdsql:" + serverName + ":" + mydatabase
					+ "?defaultResultSetHoldable=True"; // a JDBC url
			} else {
				//String serverName = "154.0.161.181";
				String serverName = getproperties.GetProperty("SERVER_IP");
				if (serverName.trim().equals("")) {
					log.error(url+" ->>>>>>>>>>>>>>>>>Empty IP address>>> ");
				}
				//String mydatabase = "//home//reroutepharma//smartserver"; //
				String mydatabase = pDirName;
				 url = "jdbc:firebirdsql:" + serverName + ":" + mydatabase
					+ "?defaultResultSetHoldable=True"; // a JDBC url
			}
			String username = getproperties.GetProperty("SERVER_UNAME"); //"sysdba";
			String password = getproperties.GetProperty("SERVER_PWORD"); //"testrr";
			// JDBC
																													// url
			config.setJdbcUrl(url);
			config.setUsername(username);
			config.setPassword(password);

			config.setMaximumPoolSize(10);
			// The maximum number of connections, idle or busy, that can be present in the pool.
			config.setAutoCommit(false);
			config.addDataSourceProperty("cachePrepStmts", "true");
			// Whether to cache Prepared Statements or not.
			config.addDataSourceProperty("prepStmtCacheSize", "250");
			// Number of Prepared Statements to be cached per connection.
			// This property will work only if the cachePrepStmts switch is turned-on.

			config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
			// The maximum length of the SQL Statement that the connection will cache.

			config.setAutoCommit(true);

			datasource = new HikariDataSource(config);

		}
		return datasource;
	}
}
