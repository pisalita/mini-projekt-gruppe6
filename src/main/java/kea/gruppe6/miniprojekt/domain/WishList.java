package kea.gruppe6.miniprojekt.domain;

import java.util.ArrayList;


public class WishList {
    private ArrayList<Wish> list = new ArrayList<>();

    public WishList(){
    }

    public void addWish(Wish wish){
        list.add(wish);
    }

    public ArrayList<Wish> getList() {
        return list;
    }


}
