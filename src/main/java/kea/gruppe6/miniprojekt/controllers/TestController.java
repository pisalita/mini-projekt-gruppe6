package kea.gruppe6.miniprojekt.controllers;

import kea.gruppe6.miniprojekt.data.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class TestController {


    @GetMapping("/testSQLConnection")
    @ResponseBody
    public String testSQLConnection() throws SQLException {
        Connection conn = DBManager.getConnection();
        Statement stmt = conn.createStatement();

        String sql;
        ResultSet rs;

        sql = "SELECT * FROM usr";
        rs = stmt.executeQuery(sql);
        int id = 0;
        String username = "";
        String email= "";
        String password= "";
        while(rs.next()){
            id = rs.getInt("id");
            username = rs.getString("username");
            email = rs.getString("email");
            password = rs.getString("pwd");

        }

        return id + "\t" + username +"\t" + email + "\t" + password;
    }
}
