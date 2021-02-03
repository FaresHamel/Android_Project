package com.example.crafstman.data.model;

public class CreateUser {

    private String username;
    private String firstName;


    private String lastName;
    private String email;
    private String password;
    private long numberPhone;
    private String city;
    private String ville;


    public CreateUser(String username, String firstName, String lastName, String email, String password, long numberPhone, String city, String ville) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.numberPhone = numberPhone;
        this.city = city;
        this.ville = ville;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public long getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(long numberPhone) {
        this.numberPhone = numberPhone;
    }
}
