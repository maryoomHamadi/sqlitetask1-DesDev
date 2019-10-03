package sadia.desdev.task1sqlitee;

public class namelist {
    private String username,password;

    public namelist(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public namelist() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
