package com.spiral.zillow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ZillowProperties {

    private static final String PROPERTIES_FILE = "zillow.properties";

    private Properties properties = new Properties();

    public ZillowProperties() {
        try {
            FileInputStream input = new FileInputStream(PROPERTIES_FILE);
            properties.load(input);
        } catch (Throwable t) {
            throw new RuntimeException(t); // Fix this
        }
    }

    public String getApiBaseUrl() { return properties.getProperty("apiBaseUrl"); }

    public String getZwsId() { return properties.getProperty("zwsId"); }

}
