package kea.gruppe6.miniprojekt.domain;

public class Wish {

    private int id;
    private String title;
    private String link;
    private String cmnt;
    private boolean reserved;
    private String email;

    public Wish(String title, String link, String cmnt, boolean reserved, String email) {
        this.title = title;
        this.link = link;
        this.cmnt = cmnt;
        this.reserved = reserved;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCmnt() {
        return cmnt;
    }

    public void setCmnt(String cmnt) {
        this.cmnt = cmnt;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", cmnt='" + cmnt + '\'' +
                ", reserved=" + reserved +
                '}';
    }
}
