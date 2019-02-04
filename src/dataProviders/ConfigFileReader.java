package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Properties;




public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";


	public ConfigFileReader()
	{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			}
			catch (IOException e) {

				e.printStackTrace();
			}
		}catch (FileNotFoundException e) {

			e.printStackTrace();
			throw new RuntimeException("configuration Properties not found at "+propertyFilePath);

		}
	}

	public Boolean getBrowserWindowMaximized() {
		String windowSize = properties.getProperty("whindowMaximize");
		if(windowSize !=null) return Boolean.valueOf(windowSize);
		return true;
	}

	public String getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowSize");
		if (windowSize != null) return windowSize;
		else throw new RuntimeException("windowSize Not specified in the Configuration.properties file");
	}

	public String getDriverPath()
	{
		String driverPath = properties.getProperty("driverPath");
		if(driverPath != null) return driverPath;
		else throw new RuntimeException("driverPath Not specified in the Configuration.properties file");
	}

	public Long getImplicitWait()
	{
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait !=null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait is not specified in the Configuration.properties file");
	}

	public String getPathToInstaller() {
		String installerPath = properties.getProperty("pathToInstaller");
		if(installerPath != null) return installerPath;
		else throw new RuntimeException("installer Path is not specified in the Configuration.properties file");
	}

	public String getDatabaseHostName() {
		String value = properties.getProperty("databaseHostName");
		if(value != null) return value;
		else throw new RuntimeException("Database Host Name is not specified in the Configuration.properties file");
	}

	public String getDatabasePort() {
		String value = properties.getProperty("databasePort");
		if(value != null) return value;
		else throw new RuntimeException("Database Port is not specified in the Configuration.properties file");
	}

	public String getDatabaseName() {
		String value = properties.getProperty("databaseName");
		if(value != null) return value;
		else throw new RuntimeException("Database Name is not specified in the Configuration.properties file");
	}

	public String getDatabaseUsername() {
		String value = properties.getProperty("databaseUsername");
		if(value != null) return value;
		else throw new RuntimeException("Database Username is not specified in the Configuration.properties file");
	}

	public String getDatabasePassword() {
		String value = properties.getProperty("databasePassword");
		if(value != null) return value;
		else throw new RuntimeException("Database password is not specified in the Configuration.properties file");
	}

	public Boolean getDatabaseSameDbUser() {
		String value = properties.getProperty("databaseSameDatabaseUser");
		if(value != null) return Boolean.valueOf(value);
		else throw new RuntimeException("database Same Database User is not specified in the Configuration.properties file");
	}

	public String getOrganizationName() {
		String value = properties.getProperty("organizationName");
		if(value != null) return value;
		else throw new RuntimeException("organization Name is not specified in the Configuration.properties file");
	}

	public String getOrganizationCountry() {
		String value = properties.getProperty("organizationCountry");
		if(value != null) return value;
		else throw new RuntimeException("organization Country is not specified in the Configuration.properties file");
	}

	public String getOrganizationLanguage() {
		String value = properties.getProperty("organizationLanguage");
		if(value != null) return value;
		else throw new RuntimeException("organization Language is not specified in the Configuration.properties file");
	}

	public String getOrganizationTimeZone() {
		String value = properties.getProperty("organizationTimeZone");
		if(value != null) return value;
		else throw new RuntimeException("organization Time Zone is not specified in the Configuration.properties file");
	}

	public String getAdminFirstName() {
		String value = properties.getProperty("adminFirstName");
		if(value != null) return value;
		else throw new RuntimeException("admin First Name is not specified in the Configuration.properties file");
	}

	public String getAdminLastName() {
		String value = properties.getProperty("adminLastName");
		if(value != null) return value;
		else throw new RuntimeException("Admin Last Name is not specified in the Configuration.properties file");
	}

	public String getAdminEmail() {
		String value = properties.getProperty("adminEmail");
		if(value != null) return value;
		else throw new RuntimeException("Admin Email is not specified in the Configuration.properties file");
	}

	public String getAdminContact() {
		String value = properties.getProperty("adminContact");
		if(value != null) return value;
		else throw new RuntimeException("Admin Email is not specified in the Configuration.properties file");
	}

	public String getAdminUserName() {
		String value = properties.getProperty("adminUsername");
		if(value != null) return value;
		else throw new RuntimeException("Admin Username is not specified in the Configuration.properties file");
	}

	public String getAdminPassowrd() {
		String value = properties.getProperty("adminPassword");
		if(value != null) return value;
		else throw new RuntimeException("Admin Password is not specified in the Configuration.properties file");
	}

	public String getSaveScreenShotPath() {
		String value = properties.getProperty("saveScreenShotPath");
		if(value != null) return value;
		else throw new RuntimeException("save Screen Shot Path is not specified in the Configuration.properties file");
	}

	public Boolean getIgnoreCertificateErrors() {
		String value = properties.getProperty("ignoreCertificateErrors");
		if (value != null) return Boolean.valueOf(value);
		return true;
	}

	public String getVerboseLogging() {
		String value = properties.getProperty("verboseLogging");
		if (value != null) return value;
		return "false";
	}
}
