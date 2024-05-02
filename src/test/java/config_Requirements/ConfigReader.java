package config_Requirements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties apiProperties;
    private static Properties dbProperties;

    static {
        apiProperties = loadPropertiesFile("src/test/java/config_Requirements/api.properties");
        dbProperties = loadPropertiesFile("src/test/java/config_Requirements/db.properties");
    }

    private static Properties loadPropertiesFile(String fileName) {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getProperty(String file , String key) {
        if (file.equalsIgnoreCase("api")) {
            return apiProperties.getProperty(key);
        } else if (file.equalsIgnoreCase("db")) {
            return dbProperties.getProperty(key);
        } else {
            throw new IllegalArgumentException("Invalid file name: " + file);
        }
    }
}