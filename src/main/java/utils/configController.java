package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class configController {


    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/application-UATB.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file.");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

}
