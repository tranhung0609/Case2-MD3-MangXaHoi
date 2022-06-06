package model;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    private int id;
    private User user;
    private String time;
    private int commentCount;
    private int likeCount;
    private ViewMode viewMode;
    private String image;
    private String content;
    List<Comment> comments;

    public Post() {
    }

    public Post(User user, String time, ViewMode viewMode, String image, String content) {
        this.user = user;
        this.time = time;
        this.viewMode = viewMode;
        this.image = image;
        this.content = content;
    }

    public Post(User user, String time, int commentCount, int likeCount, ViewMode viewMode, String image, String content) {
        this.user = user;
        this.time = time;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
        this.viewMode = viewMode;
        this.image = image;
        this.content = content;
    }

    public Post(int id, User user, String time, int commentCount, int likeCount, ViewMode viewMode, String image, String content) {
        this.id = id;
        this.user = user;
        this.time = time;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
        this.viewMode = viewMode;
        this.image = image;
        this.content = content;
    }

    public Post(User user, String time, ViewMode viewMode, String content) {
        this.user = user;
        this.time = time;
        this.viewMode = viewMode;
        this.content = content;
    }

    public Post(int id, User user, String time, int commentCount, int likeCount, ViewMode viewMode, String image, String content, List<Comment> comments) {
        this.id = id;
        this.user = user;
        this.time = time;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
        this.viewMode = viewMode;
        this.image = image;
        this.content = content;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public ViewMode getViewMode() {
        return viewMode;
    }

    public void setViewMode(ViewMode viewMode) {
        this.viewMode = viewMode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
