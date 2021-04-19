package kea.gruppe6.miniprojekt.domain;

import org.springframework.ui.Model;

public class User {

    private int id;
    private String email;
    private String username;
    private String pwd;
    private boolean loggedIn = false;

    /**
     * Constructor instantiating a user with email, password and username
     * @param email email of user
     * @param pwd password of user
     * @param username username of user
     */

    public User(String email, String pwd, String username){
        this.email = email;
        this.pwd = pwd;
        this.username = username;
    }

    /**
     * Checks if the user is logged in by returning boolean
     * @return returns true if user is logged in, else returns false
     */

    public boolean isLoggedIn(){
        return loggedIn;
    }

    /**
     * Set user to be logged in after succesfull login attempt or create account
     * @param loggedIn is true if user is logged in, else false
     */

    public void setLoggedIn(boolean loggedIn){
        this.loggedIn = loggedIn;
    }

    /**
     * Gets the id of a user
     * @return returns the id of a user
     */

    public int getId() {
        return id;
    }

    /**
     * Sets the id of a user
     * @param id contains the id of a user
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the email of a user
     * @return returns email of a user
     */

    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of a user
     * @param email contains the email of a user
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the username of a user
     * @return returns username of a user
     */

    public String getUsername() {
        return username;
    }

    /**
     * Gets the password of a user
     * @return returns password of a user
     */

    public String getPwd() {
        return pwd;
    }

    /**
     * Sets the password of a user
     * @param pwd contains the password of a user
     */

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
