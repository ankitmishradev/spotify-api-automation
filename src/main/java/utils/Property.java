package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Property {
    private static final String path = "src/test/resources/config.properties";

    private static Properties reader() {
        Properties properties;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at " + path);
        }

        return properties;
    }

    private static RuntimeException exception(String key) {
        return new RuntimeException(key + " not specified in the \"config.properties\" file");
    }

    public static String get(String key) {
        String value = reader().getProperty(key);
        if (value == null) throw exception(key);
        else return value;
    }

    public static void set(String key, String value) {
        Properties property = reader();
        property.setProperty(key, value);

        try {
            OutputStream output = Files.newOutputStream(Paths.get(path));
            property.store(output, null);
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}