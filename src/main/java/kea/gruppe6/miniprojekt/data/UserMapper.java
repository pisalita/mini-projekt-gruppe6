package kea.gruppe6.miniprojekt.data;
import kea.gruppe6.miniprojekt.domain.LoginWishLinkException;
import kea.gruppe6.miniprojekt.domain.User;

import java.sql.*;

public class UserMapper {

    public void createUser(User user) throws LoginWishLinkException{
        try {
            Connection conn = DBManager.getConnection();
            String SQL = "INSERT INTO usr (username, email, pwd) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPwd());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            user.setId(id);

        }catch(SQLException e){
            throw new LoginWishLinkException(e.getMessage());
        }
    }

    public User login(String email, String pwd) throws LoginWishLinkException{
        try {
            Connection conn = DBManager.getConnection();
            String SQL ="SELECT * FROM usr WHERE email=? AND pwd=?";
            PreparedStatement ps = conn.prepareStatement(SQL);

            ps.setString(1, email);
            ps.setString(2, pwd);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                String username = rs.getString("username");
                int id = rs.getInt("id");

                User user = new User(email,pwd,username);
                user.setId(id);
                return user;
            } else {
                return null;
            }

        }catch(SQLException e){
            throw new LoginWishLinkException(e.getMessage());
        }
    }
}
