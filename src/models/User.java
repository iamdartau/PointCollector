package models;

public class User {
    private String email;
    private String password;
    private String group;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String email, String password, String group, int id) {

        this.email = email;
        this.password = password;
        this.group = group;
        this.id = id;

    }

    public User(String email, String password, String group) {
        this.email = email;
        this.password = password;
        this.group = group;
    }

    public User(String email, String password, int id) {

        this.email = email;
        this.password = password;
        this.id = id;
    }

    public User(int id) {

        this.id = id;
    }

    public User(String email, String password) {

        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
