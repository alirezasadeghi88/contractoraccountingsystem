package ir.university.accounting.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    private static String url;
    private static String user;
    private static String password;

    static {
    try {
        Properties properties = new Properties();
       InputStream in = DBConnection.class
               .getClassLoader()
               .getResourceAsStream("db.properties");

       properties.load(in);

       url = properties.getProperty("db.url");
       user = properties.getProperty("db.user");
       password = properties.getProperty("db.password");

       Class.forName(properties.getProperty("db.driver"));

    } catch (Exception e) {
        System.out.println("Database configuration error❌ ");
        e.printStackTrace();
    }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection( url, user, password);
    }
}
