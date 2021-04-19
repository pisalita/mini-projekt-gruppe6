package kea.gruppe6.miniprojekt.data;

import kea.gruppe6.miniprojekt.domain.IUser;
import kea.gruppe6.miniprojekt.domain.LoginWishLinkException;
import kea.gruppe6.miniprojekt.domain.User;

public class UserImpl implements IUser {
    private UserMapper userMapper = new UserMapper();

    /**
     * Log's the user in if credentials match SQL data
     * @param email the email provided by the user
     * @param pwd the password provided by the user
     * @return returns the userMapper's login method (Pathway to SQL data)
     * @throws LoginWishLinkException if exception found
     */

    public User login(String email, String pwd) throws LoginWishLinkException {
        return userMapper.login(email,pwd);
    }


    /**
     * Creates the user if credentials are valid
     * @param user object consisting of email, password and username
     * @return returns the user object
     * @throws LoginWishLinkException if exeption found
     */
    public User createUser(User user) throws LoginWishLinkException {
        userMapper.createUser(user);
        return user;
    }

}
