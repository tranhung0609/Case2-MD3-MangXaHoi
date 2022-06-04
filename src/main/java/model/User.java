package model;

import java.text.DateFormat;
import java.util.Date;

public class User {
    private int id;
    private String full_name;
    private String email;
    private String avatar;
    private String date_of_birth;
    private String password;

    public User() {
    }

    public User(int id, String full_name, String email, String avatar, String date_of_birth, String password) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.avatar = avatar;
        this.date_of_birth = date_of_birth;
        this.password = password;
    }

    public User(String full_name, String email, String avatar, String date_of_birth, String password) {
        this.full_name = full_name;
        this.email = email;
        this.avatar = avatar;
        this.date_of_birth = date_of_birth;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


