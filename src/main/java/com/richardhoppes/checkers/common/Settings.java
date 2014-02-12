package com.richardhoppes.checkers.common;

import com.richardhoppes.checkers.exception.PropertyNotFoundException;

import java.util.Properties;

public class Settings {

	private Properties configProperties;

	private String getProperty(String property) throws PropertyNotFoundException {
		String retVal = configProperties.getProperty(property);
		if(retVal == null) {
			throw new PropertyNotFoundException("Property not found: " + property);
		}
		return retVal;
	}

	public String getMode() throws PropertyNotFoundException {
		return getProperty("mode");
	}

	public String getJdbcReadWriteDriver() throws PropertyNotFoundException {
		return getProperty("jdbc.readWrite.driver");
	}

	public String getJdbcReadWriteUrl() throws PropertyNotFoundException {
		return getProperty("jdbc.readWrite.base.url") + "/" + getProperty("jdbc.readWrite.db") + "?" + getProperty("jdbc.readWrite.params");
	}

	public String getJdbcReadWriteUser() throws PropertyNotFoundException {
		return getProperty("jdbc.readWrite.user");
	}

	public String getJdbcReadWritePassword() throws PropertyNotFoundException {
		return getProperty("jdbc.readWrite.password");
	}

	public String getDateFormatString() throws PropertyNotFoundException {
		return getProperty("date.format.string");
	}

	public Properties getConfigProperties() {
		return configProperties;
	}

	public void setConfigProperties(Properties configProperties) {
		this.configProperties = configProperties;
	}
}
