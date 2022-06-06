package model;

import java.time.LocalDateTime;

public class Like {
    private int id;
    private Post post;
    private User user;
    private String time;
    private LikeStatus likeStatus;

    public Like() {
    }

    public Like(Post post, User user, String time) {
        this.post = post;
        this.user = user;
        this.time = time;
    }

    public Like(int id, Post post, User user, String time) {
        this.id = id;
        this.post = post;
        this.user = user;
        this.time = time;
    }

    public Like(int id, Post post, User user, String time, LikeStatus likeStatus) {
        this.id = id;
        this.post = post;
        this.user = user;
        this.time = time;
        this.likeStatus = likeStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LikeStatus getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(LikeStatus likeStatus) {
        this.likeStatus = likeStatus;
    }
}
