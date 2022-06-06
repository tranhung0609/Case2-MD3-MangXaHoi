package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String avatar;
    private String dateOfBirth;
    private String password;
    List<FriendShip> friendShips;

    public User() {
    }

    public User(String fullName, String email, String avatar, String dateOfBirth, String password) {
        this.fullName = fullName;
        this.email = email;
        this.avatar = avatar;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public User(int id, String fullName, String email, String avatar, String dateOfBirth, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.avatar = avatar;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public List<FriendShip> getFriendShips() {
        return friendShips;
    }

    public void setFriendShips(List<FriendShip> friendShips) {
        this.friendShips = friendShips;
    }

    public User(int id, String fullName, String email, String avatar, String dateOfBirth, String password, List<FriendShip> friendShips) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.avatar = avatar;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.friendShips = friendShips;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
