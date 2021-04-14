package kea.gruppe6.miniprojekt.domain;

public class LoginControl{

    private IUser user = null;

    public LoginControl(IUser user) {
        this.user = user;
    }

    public User login(String email, String pwd) throws LoginWishLinkException{
        return user.login(email,pwd);
    }

    public User createUser(String email, String username, String pwd) throws LoginWishLinkException{
        User newUser = new User(email, pwd, username);
        user.createUser(newUser);

        return newUser;
    }
}


