package controller;

import model.Comment;
import model.Like;
import model.Post;
import service.impl.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "PostsServlet", value = "/posts")
public class PostsServlet extends HttpServlet {
    PostServiceImpl postService = new PostServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();
    ViewModeServiceImpl viewModeService = new ViewModeServiceImpl();
    LikeServiceImpl likeService = new LikeServiceImpl();
    CommentServiceImpl commentService = new CommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "add-post":
                try {
                    addPost(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "like":
                try {
                    like(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "comment":
                try {
                    comment(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }



    private void comment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int postId = Integer.parseInt(request.getParameter("postId"));
        Post post = postService.findById(postId);
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter
                .ofPattern("yyyy/MM/dd HH:mm:ss");
        String time = localDateTime.format(dateFormatter);
        String content = request.getParameter("commentContent");
        Comment comment = new Comment(postId, UserServiceImpl.currentUsers, time, content);
//        Comment comment = new Comment(postService.findById(postId), UserServiceImpl.currentUsers, time, content);
        commentService.add(comment);
        post.getComments().add(comment);
        post.setCommentCount(post.getComments().size());
        postService.update(post);
        response.sendRedirect("/users?action=homepage");
    }

    private void like(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int postId = Integer.parseInt(request.getParameter("postId"));
        Post post = postService.findById(postId);
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter
                .ofPattern("yyyy/MM/dd HH:mm:ss");
        String time = localDateTime.format(dateFormatter);
        Like like = new Like(postService.findById(postId), UserServiceImpl.currentUsers, time);
        if (likeService.checkLike(postId, UserServiceImpl.currentUsers.getId())){
            likeService.add(like);
            post.setLikeCount(post.getLikeCount() + 1);
            postService.update(post);
        } else {
            likeService.unlike(postId, UserServiceImpl.currentUsers.getId());
            post.setLikeCount(post.getLikeCount() - 1);
            postService.update(post);
        }
        response.sendRedirect("/users?action=homepage");
    }

    private void addPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String content = request.getParameter("content");
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter
                .ofPattern("yyyy/MM/dd HH:mm:ss");
        String time = localDateTime.format(dateFormatter);
        int viewModeId = Integer.parseInt(request.getParameter("viewModeId"));
        String image = request.getParameter("image");
        Post post = new Post(userService.findById(userId), time, viewModeService.findById(viewModeId), image, content);
        postService.add(post);
        response.sendRedirect("/users?action=homepage");
    }
}
