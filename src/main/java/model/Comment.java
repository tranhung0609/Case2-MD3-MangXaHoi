package model;

import java.time.LocalDateTime;

public class Comment {
    private int id;
//    private int postId;
    private Post post;
    private User user;
    private String time;
    private String content;

    public Comment() {

    }

    public Comment(int id, Post post, User user, String time, String content) {
        this.id = id;
        this.post = post;
        this.user = user;
        this.time = time;
        this.content = content;
    }

    public Comment(Post post, User user, String time, String content) {
        this.post = post;
        this.user = user;
        this.time = time;
        this.content = content;
    }
//    public Comment(int postId, User user, String time, String content) {
//        this.postId = postId;
//        this.user = user;
//        this.time = time;
//        this.content = content;
//    }
//
//    public Comment(int id, int postId, User user, String time, String content) {
//        this.id = id;
//        this.postId = postId;
//        this.user = user;
//        this.time = time;
//        this.content = content;
//    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
