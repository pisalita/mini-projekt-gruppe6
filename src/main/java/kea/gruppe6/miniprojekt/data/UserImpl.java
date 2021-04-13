package kea.gruppe6.miniprojekt.data;

import kea.gruppe6.miniprojekt.domain.IUser;
import kea.gruppe6.miniprojekt.domain.LoginWishLinkException;
import kea.gruppe6.miniprojekt.domain.User;

public class UserImpl implements IUser {
    private UserMapper userMapper = new UserMapper();


    public User login(String email, String pwd) throws LoginWishLinkException {
        return userMapper.login(email,pwd);
    }


    public User createUser(User user) throws LoginWishLinkException {
        userMapper.createUser(user);
        return user;
    }
}
