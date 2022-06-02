package model;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private String postId;
    private User user;
    private LocalDateTime time;
    private String content;

    public Comment() {

    }

    public Comment(int id, String postId, User user, LocalDateTime time, String content) {
        this.id = id;
        this.postId = postId;
        this.user = user;
        this.time = time;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
