package com.joyowo.exchange.utils;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class DataBase {
    private static String url;
    private static String driver;
    private static String username;
    private static String password;

    private static String url2;
    private static String driver2;
    private static String username2;
    private static String password2;
    static {
        Properties prop = new Properties();
        InputStream in = DataBase.class.getResourceAsStream("/database.properties");
        try {
            prop.load(in);
            url = prop.getProperty("jdbc.url").trim();
            driver = prop.getProperty("jdbc.driver").trim();
            username = prop.getProperty("jdbc.username").trim();
            password = prop.getProperty("jdbc.password").trim();

            url2 = prop.getProperty("jdbc2.url").trim();
            driver2 = prop.getProperty("jdbc2.driver").trim();
            username2 = prop.getProperty("jdbc2.username").trim();
            password2 = prop.getProperty("jdbc2.password").trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private DataBase() {
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

    public static String getUrl2() {
        return url2;
    }

    public static String getDriver2() {
        return driver2;
    }

    public static String getUsername2() {
        return username2;
    }

    public static String getPassword2() {
        return password2;
    }
}