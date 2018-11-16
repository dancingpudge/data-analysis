package com.pudge.demo.utils;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author liuhu
 */
public class DataBase {
    private static String url;
    private static String driver;
    private static String username;
    private static String password;

    static {
        Properties prop = new Properties();
        InputStream in = DataBase.class.getResourceAsStream("/database.properties");
        try {
            prop.load(in);
            url = prop.getProperty("jdbc.url").trim();
            driver = prop.getProperty("jdbc.driver").trim();
            username = prop.getProperty("jdbc.username").trim();
            password = prop.getProperty("jdbc.password").trim();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return url;
    }

    public static String getDriver() {
        return driver;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}