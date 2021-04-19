package kea.gruppe6.miniprojekt.domain;

public class LoginControl{

    private IUser user = null;

    /**
     * Constructer for initializing user
     * @param user the user object
     */

    public LoginControl(IUser user) {
        this.user = user;
    }

    /**
     * logs in the user
     * @param email email provided by the user
     * @param pwd password provided by the user
     * @return returns the logged in user
     * @throws LoginWishLinkException if exeption found
     */

    public User login(String email, String pwd) throws LoginWishLinkException{
        return user.login(email,pwd);
    }

    /**
     * Creates user
     * @param email email provided by the user
     * @param username username provided by the user
     * @param pwd password provided by the user
     * @return returns a new user
     * @throws LoginWishLinkException if exeption found
     */

    public User createUser(String email, String username, String pwd) throws LoginWishLinkException{
        User newUser = new User(email, pwd, username);
        user.createUser(newUser);

        return newUser;
    }
}


