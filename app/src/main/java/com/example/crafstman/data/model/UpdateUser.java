package com.example.crafstman.data.model;

public class UpdateUser {

    private String username;
    private String email;
    private String newEmail;
    private String newUsername;

    public UpdateUser(String username, String email, String newEmail, String newUsername) {
        this.username = username;
        this.email = email;
        this.newEmail = newEmail;
        this.newUsername = newUsername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }
}
