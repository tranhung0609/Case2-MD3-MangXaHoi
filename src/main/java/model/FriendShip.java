package model;

public class FriendShip {
    private int id;
    private User user1;
    private User user2;
    private Status status;

    public FriendShip() {
    }

    public FriendShip(User user1, User user2, Status status) {
        this.user1 = user1;
        this.user2 = user2;
        this.status = status;
    }

    public FriendShip(int id, User user1, User user2, Status status) {
        this.id = id;
        this.user1 = user1;
        this.user2 = user2;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
