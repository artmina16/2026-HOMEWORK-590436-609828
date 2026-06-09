package it.uniroma3.diadia;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DiaDiaProperties {

    private static final String FILE_PROPERTIES = "diadia.properties";
    private static Properties properties = new Properties();

    static {
        try {
            InputStream input = DiaDiaProperties.class
                    .getClassLoader()
                    .getResourceAsStream(FILE_PROPERTIES);

            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getCfuIniziali() {
        return Integer.parseInt(properties.getProperty("cfu.iniziali"));
    }

    public static int getPesoMaxBorsa() {
        return Integer.parseInt(properties.getProperty("borsa.pesoMax"));
    }
}