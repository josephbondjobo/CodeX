package com.reroute.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DataBaseConnect {
	static Logger log = Logger.getLogger(DataBaseConnect.class.getName());

	private static GetProperties getproperties = new GetProperties();
	// --------------------------------------------------
	public static Connection setConnection(String pDirName) {
		//log.warn(" ->>>>>>>>>>>>>>>>>>setConnection>>> ");
		Connection connection = null;
		String url = "";
		try {
			// File dir1 = new File ("."));
			// String sPath = dir1.getCanonicalPath()+"\\x.FDB";
			// pDirName = sPath;
			// Load the JDBC driver
			// firebird

			 System.out.println("Db Directory path:" + pDirName);

			String driverName = "org.firebirdsql.jdbc.FBDriver"; // JDBC driver
			Class.forName(driverName).newInstance(); // load the appropriate
														// driver
			String os = System.getProperty("os.name");
			//log.info(" ->>>>>>>Operating system1>>> " + os);

			if (os.startsWith("W")) {
				String serverName = "localhost";
				String mydatabase = pDirName; //
				url = "jdbc:firebirdsql:" + serverName + ":" + mydatabase
					+ "?defaultResultSetHoldable=True"; // a JDBC url
			} else {
				//String serverName = "127.0.0.1";
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
			String password = getproperties.GetProperty("SERVER_PWORD"); //"masterkey";
			//log.warn(url+" ->>>>>>>>>>>>>>>>>>>>>>>>open>>> " + pDirName);
			DriverManager.setLoginTimeout(1);

			connection = DriverManager.getConnection(url, username, password); //
			//log.warn(" ->>>>>>>>>>>>2222>>>>>>>>>>>Timeout>>> " + DriverManager.getLoginTimeout());

			if (connection == null) {
				log.warn(" ->>>>>>>connection = null >>> ");
				//ExceptionLogger.logException(log, null,"No connection to database: " + pDirName);
				System.out.println("No connection to database: " + pDirName);
			}
			return connection;

		} catch (ClassNotFoundException e) {
			// Could not find the database driver
			String err = "11****ERROR***** > JCA-JDBC driver not found in class path - "+ e;
			System.out.println(err);
			//ExceptionLogger.logException(log, e, err);
		} catch (SQLException e) {
			// Could not connect to the database
			String err = pDirName
					+ "12****ERROR***** > Could not open database " + e;
			System.out.println(err);
			//ExceptionLogger.logException(log, e, err);
		} catch (Exception e) {
			// Could not connect to the database
			String err = pDirName
					+ "13****ERROR***** > Could not open database " + e;
			System.out.println(err);
			//ExceptionLogger.logException(log, e, err);
		}
		return connection;
	}

	// --------------------
	public static void close(ResultSet rs, PreparedStatement pstmnt,
			Connection connection) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				/* Ignore */
			}
		}
		//
		if (pstmnt != null) {
			try {
				pstmnt.close();
			} catch (SQLException e) {
				/* Ignore */
			}
		}
			//
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					/* Ignore */
				}
			}

	}
	// --------------------
	public static void close(ResultSet rs, PreparedStatement pstmnt,Connection connection,Statement statement) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				/* Ignore */
			}
		}
		//
		if (pstmnt != null) {
			try {
				pstmnt.close();
			} catch (SQLException e) {
				/* Ignore */
			}
		}
		//
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				/* Ignore */
			}
		}

			//
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					/* Ignore */
				}
			}
		}
	// --------------------
	public static void close(ResultSet rs, Statement smnt,	Connection connection) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				/* Ignore */
			}
		}
		//
		if (smnt != null) {
			try {
				smnt.close();
			} catch (SQLException e) {
				/* Ignore */
			}
		}
			//
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					/* Ignore */
				}
			}

	}
}
