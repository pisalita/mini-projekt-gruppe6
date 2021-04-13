package kea.gruppe6.miniprojekt.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {

    private static String usr;
    private static String pwd;
    private static String url;
    private static Connection connection = null;

    public static Connection getConnection(){
        if (connection != null) return connection;
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            url = properties.getProperty("url");
            usr = properties.getProperty("usr");
            pwd = properties.getProperty("pwd");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url,usr, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
