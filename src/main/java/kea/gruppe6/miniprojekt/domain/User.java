package kea.gruppe6.miniprojekt.domain;

public class User {

    private int id;
    private String email;
    private String username;
    private String pwd;

    public User(String email, String pwd, String username){
        this.email = email;
        this.pwd = pwd;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}