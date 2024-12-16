package aqa_course.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    private static Properties property = null;

    public static String getProperty(String key) {
        if (property == null) {
            property = new Properties();
            try {
                property.load(new FileInputStream("src/main/resources/config.properties"));
            } catch (IOException e) {
                throw new RuntimeException("Failed to load config.properties", e);
            }
        }
        return property.getProperty(key);
    }
}
