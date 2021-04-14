package kea.gruppe6.miniprojekt.data;


import kea.gruppe6.miniprojekt.domain.Wish;

import java.sql.*;

public class WishMapper {

    public void createWish(Wish wish){
        try {
            Connection conn = DBManager.getConnection();
            String SQL = "INSERT INTO wishlist (title, link, cmnt, reserved, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, wish.getTitle());
            ps.setString(2, wish.getLink());
            ps.setString(3, wish.getCmnt());
            ps.setBoolean(4, wish.isReserved());
            ps.setString(5, wish.getEmail());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            wish.setId(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readWish(){

    }

    public void updateWish(){

    }

    public void deleteWish(){

    }

    public void reserveWish(){

    }



}
