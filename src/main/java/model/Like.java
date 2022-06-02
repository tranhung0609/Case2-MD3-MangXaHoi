package model;

import java.time.LocalDateTime;

public class Like {
    private int id;
    private Post post;
    private User user;
    private LocalDateTime time;
    private LikeStatus likeStatus;


    public Like(int id, Post post, User user, LocalDateTime time, LikeStatus likeStatus) {
        this.id = id;
        this.post = post;
        this.user = user;
        this.time = time;
        this.likeStatus = likeStatus;
    }

    public Like() {
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LikeStatus getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(LikeStatus likeStatus) {
        this.likeStatus = likeStatus;
    }
}
