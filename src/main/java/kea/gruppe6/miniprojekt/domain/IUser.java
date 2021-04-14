package kea.gruppe6.miniprojekt.domain;

public interface IUser {

    User login(String email, String pwd) throws LoginWishLinkException;
    User createUser(User user) throws LoginWishLinkException;
}