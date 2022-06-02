package model;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    private int id;
    private User user;
    private int commentId;
    private LocalDateTime time;
    private int likeCount;
    private ViewMode viewMode;
    private int image;
    private String content;
    List<Comment> comments;

    public Post() {
    }

    public Post(int id, User user, int commentId, LocalDateTime time, int likeCount, ViewMode viewMode, int image, String content, List<Comment> comments) {
        this.id = id;
        this.user = user;
        this.commentId = commentId;
        this.time = time;
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

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
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
