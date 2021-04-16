package kea.gruppe6.miniprojekt.domain;

import java.util.ArrayList;


public class WishList {

    private ArrayList<Wish> list = new ArrayList<>();
    private boolean isShared = false;

    public WishList(){
    }

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        isShared = shared;
    }

    public void addWish(Wish wish){
        list.add(wish);
    }

    public ArrayList<Wish> getList() {
        return list;
    }


}
