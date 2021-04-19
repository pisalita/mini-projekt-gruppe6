package kea.gruppe6.miniprojekt.data;


import kea.gruppe6.miniprojekt.domain.User;
import kea.gruppe6.miniprojekt.domain.Wish;
import kea.gruppe6.miniprojekt.domain.WishList;

import java.sql.*;

public class WishMapper {

    /**
     * Creates wish in mySQL database
     * @param wish object consisting of title, link, comment, reserved status and email
     */

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

    /**
     * Finds wishlist in mySQL database
     * @param email the email provided by the user in url
     * @return returns wishlist if found
     */

    public WishList readWish(String email){
        Wish wish;
        WishList wishList = new WishList();
        try {
            Connection conn = DBManager.getConnection();
            String SQL = "SELECT * FROM wishlist WHERE email=?";

            PreparedStatement ps = conn.prepareStatement(SQL);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String link = rs.getString("link");
                String cmnt = rs.getString("cmnt");
                boolean reserved = rs.getBoolean("reserved");

                wish =  new Wish(title,link,cmnt,reserved,email);
                wish.setId(id);
                wishList.addWish(wish);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wishList;
    }


    /**
     * Reserves a wish in the mySQL database
     * @param id the id of the wish getting reserved
     */

    public void reserveWish(int id){
        try {
            Connection conn = DBManager.getConnection();
            String SQL = "UPDATE wishlist  SET reserved =1 WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(SQL);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
