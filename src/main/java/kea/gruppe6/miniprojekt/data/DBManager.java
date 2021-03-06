package kea.gruppe6.miniprojekt.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
/*
    private static String usr;
    private static String pwd;
    private static String url;
*/
    private static String usr = "remote";
    private static String pwd = "1234";
    private static String url = "jdbc:mysql://18.156.136.69/wishlink?serverTimezone=UTC";


    private static Connection connection = null;

    /**
     * Returns a connection
     * @return returns the connection to the mySQL database
     */

    public static Connection getConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }

        if (connection != null) return connection;

/*
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            url = properties.getProperty("url");
            usr = properties.getProperty("usr");
            pwd = properties.getProperty("pwd");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        */


        try {
            connection = DriverManager.getConnection(url,usr, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
