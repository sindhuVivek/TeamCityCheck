package utilities.common;

// Selenium imports
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //If you want to use a config file to save user details URL's and
    // such use this for reading and setting config values.
    public Properties loadConfig() {

        Properties prop = new Properties();
        FileInputStream configLocation = null;

        try {

            configLocation = new FileInputStream(
                    "global.properties");

        } catch (FileNotFoundException e) {

            System.out.println("You've forgot to create the global.properties file!");

        }

        try {

            prop.load(configLocation);

        } catch (IOException e) {

            System.out.println("You've got a config file but the code was " +
                    "unable to load it. Please investigate");

        }

        return prop;

    }


    //Call this method within your scripts to get values from the properties file.
    public String getConfigValue(String requestedValue) {

        Properties prop = loadConfig();

        String value = null;
        value = prop.getProperty(requestedValue);

        return value;

    }

}