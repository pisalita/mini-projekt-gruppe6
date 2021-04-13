package kea.gruppe6.miniprojekt.domain;

public interface IUser {

    public User login(String email, String pwd) throws LoginWishLinkException;
    public User createUser(User user) throws LoginWishLinkException;
}