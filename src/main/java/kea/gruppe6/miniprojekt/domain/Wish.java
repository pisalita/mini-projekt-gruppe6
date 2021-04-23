package kea.gruppe6.miniprojekt.domain;

public class Wish {

    private int id;
    private String title;
    private String link;
    private String cmnt;
    private boolean reserved;
    private String email;

    /**
     * Constructor instantiating a wish with title, link, comment, reserved and email
     * @param title title of wish
     * @param link link to a wish
     * @param cmnt comment for a wish
     * @param reserved is true or false based on if the wish is reserved by others or not
     * @param email the specific email of the user who creates the wish
     */

    public Wish(String title, String link, String cmnt, boolean reserved, String email) {
        this.title = title;
        this.link = link;
        this.cmnt = cmnt;
        this.reserved = reserved;
        this.email = email;
    }

    /**
     * Gets the link of a wish
     * @return returns the wish link
     */

    public String getLink() {
        return link;
    }

    /**
     * Gets the comment of a wish
     * @return returns the wish comment
     */

    public String getCmnt() {
        return cmnt;
    }

    /**
     * Gets the boolean reserved
     * @return true or false based on if the wish is reserved by others or not
     */

    public boolean isReserved() {
        return reserved;
    }


    /**
     * Gets the id of a wish
     * @return returns the wish id
     */

    public int getId() {
        return id;
    }

    /**
     * Sets the id of a wish
     * @param id contains the wish id
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the title of a wish
     * @return returns the wish title
     */

    public String getTitle() {
        return title;
    }

    /**
     * Gets the email of the user who created the wish
     * @return returns the specific email of the user who created the wish
     */

    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user who created the wish
     * @param email contains the specific email of the user who created the wish
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * toString method used for testing purposes
     * @return returns a string that is formatted in a specific way
     */

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
