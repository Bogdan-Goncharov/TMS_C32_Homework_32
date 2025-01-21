package model;



public class User {
    private final String username;
    private final String password;
    private final String role;



    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
    public User(String username,String password, String role ) {
        this.username = username;
        this.password = password;
        this.role = role;

    }

}