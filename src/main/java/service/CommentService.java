package service;

import model.Comment;

import java.util.List;

public interface CommentService extends GeneralService<Comment> {
    List<Comment> findByPostId(int id);
}
