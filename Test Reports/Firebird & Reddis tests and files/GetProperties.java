package com.reroute.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class GetProperties {
	 static Logger log = Logger.getLogger(GetProperties.class.getName());
	private static final String PROP_FILE = "SystemConfig.properties";

	public String GetProperty(String p_propertyname) {
		String propertyValue = "";
		String fileAndPath = "";
		//this part will be mainly used in portal on windows to link test user to test database
		//the reason for this is that portal has only one environment
		if (p_propertyname.trim().equals("DATABASE")) {
			String userName = System.getProperty("user.name");
			if (userName.toUpperCase().startsWith("TESTUSER")) {
				p_propertyname = "DATABASE_TEST";
			}
		}

		try {
			String workingDir = "";
			String os = System.getProperty("os.name");
			if (os.startsWith("Linux")) {
				//workingDir = "/WEB-INF";
			//	workingDir = "WEB-INF";
				workingDir = System.getProperty("user.dir"); // + "/webapps/SmartServerPharma/WEB-INF";
			} else {
				workingDir = System.getProperty("user.dir");
			}
			fileAndPath = workingDir  + File.separator + PROP_FILE;
			//log.info(p_propertyname+"----------->>>>>>>>>>>>>>>>>.filepath "+	fileAndPath);
			File f = new File(fileAndPath);

			if (f.exists()) {
				Properties prop = new Properties();
				prop.load(new FileInputStream(fileAndPath));
				propertyValue = prop.getProperty(p_propertyname);
			} else {
				propertyValue = "";
		//		log.info(p_propertyname+"----------->>>>>>>>>ERROR file does not exist "+	fileAndPath);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	//	log.info("Property Name.>>"+p_propertyname+"<<>>>>>>>GetProperties>>>fileAndPath>>> "+fileAndPath+"<<<<propertyValue>>>>>"+propertyValue);
		return propertyValue;
	}

	// ------------------------------
	public void InitializeLogger() {
		Properties logProperties = new Properties();

		try {
			// load our log4j properties / configuration file
		//	System.out.println(" ->>>>>>>InitializeLogger>>>>111>>> ");
			String file2Load = GetProperty("LOG_PROPERTIES_FILE");
			File f = new File(file2Load);
			if (f.exists()) {
				logProperties.load(new FileInputStream(file2Load));
			//	System.out.println(" ->>>>>>>InitializeLogger>>>>2222>>> ");
				PropertyConfigurator.configure(logProperties);
			//	System.out.println(" ->>>>>>>InitializeLogger>>>>33333>>> ");
			//	log.info("Logging initialized.");
			} else {
				System.out.println(" ->>>62>>>>InitializeLogger>>>>File does not exist>>> "+file2Load);
			}
		} catch (IOException e) {
			String workingDir = System.getProperty("user.dir");
			String fileAndPath = workingDir  + File.separator + PROP_FILE;
			throw new RuntimeException("Unable to load logging property :LOG_PROPERTIES_FILE - in File : "
					+ fileAndPath);
		}
	}

}
