package conector.apps;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
 private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("No se encontró el fichero application.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("ERROR cargando el fichero de configuración: " + ex.getMessage());
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
