package model;

import java.time.LocalDate;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String avatar;
    private LocalDate dateOfBirth;
    private String password;

    public User() {
    }

    public User(int id, String fullName, String email, String avatar, LocalDate dateOfBirth, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.avatar = avatar;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
