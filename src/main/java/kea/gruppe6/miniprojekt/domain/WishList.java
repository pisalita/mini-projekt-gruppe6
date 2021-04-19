package kea.gruppe6.miniprojekt.domain;

import java.util.ArrayList;


public class WishList {

    private ArrayList<Wish> list = new ArrayList<>();
    private boolean isShared = false;

    /**
     * Constructor of wishlist
     */
    public WishList(){
    }

    /**
     * Returns if wishlist is shared or not
     * @return returns true if wishlist is shared, else false
     */

    public boolean isShared() {
        return isShared;
    }

    /**
     * Sets if the wishlist is shared or not
     * @param shared boolean is true if shared, else false
     */

    public void setShared(boolean shared) {
        isShared = shared;
    }

    /**
     * Adds wish to arraylist
     * @param wish object consisting of title, comment, link, reserved status and email
     */

    public void addWish(Wish wish){
        list.add(wish);
    }

    /**
     * Returning the wishlist
     * @return returns wishlist
     */

    public ArrayList<Wish> getList() {
        return list;
    }


}
