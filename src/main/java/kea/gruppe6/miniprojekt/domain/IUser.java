package kea.gruppe6.miniprojekt.domain;

public interface IUser {

    /**
     * Contract for login
     * @param email email provided by the user
     * @param pwd password provided by the user
     * @return returns user object
     * @throws LoginWishLinkException if exception found
     */
    User login(String email, String pwd) throws LoginWishLinkException;

    /**
     * Contract for creating user
     * @param user object consisting of email, username and password
     * @return returns the user object
     * @throws LoginWishLinkException if exception found
     */

    User createUser(User user) throws LoginWishLinkException;

}