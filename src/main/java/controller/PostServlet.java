package controller;

import model.Comment;
import model.Post;
import model.User;
import model.ViewMode;
import service.impl.CommentServiceImpl;
import service.impl.PostServiceImpl;
import service.impl.UserServiceImpl;
import service.impl.ViewModeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "PostServlet", urlPatterns= "/posts")
public class PostServlet extends HttpServlet {
    PostServiceImpl postService = new PostServiceImpl();
    UserServiceImpl userService=  new UserServiceImpl();
    CommentServiceImpl commentService = new CommentServiceImpl();
    ViewModeServiceImpl viewModeService = new ViewModeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "post":{
                showPost(request,response);
                break;
            }
            default:{
                showListPost(request,response);
            }
        }

    }

    private void showPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> posts = postService.findAll();
        request.setAttribute("pos",posts);
        request.getRequestDispatcher("jsp/post/create.jsp").forward(request,response);

    }

    private void showListPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> posts = postService.findAll();
        request.setAttribute("post",posts);
        request.getRequestDispatcher("jsp/post/post.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "post":{
                try {
                    post(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

    private void post(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userService.findById(userId);
        int commentId = Integer.parseInt(request.getParameter("commentId"));
        Comment comment = commentService.findById(commentId);
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter
                .ofPattern("dd/MM/yyyy HH:mm");
        String time = localDateTime.format(dateFormatter);
        int viewModeId = Integer.parseInt(request.getParameter("viewModeId"));
        ViewMode viewMode = viewModeService.findById(viewModeId);
        String image = request.getParameter("image");
        String content = request.getParameter("content");
        postService.add(new Post(user,comment,time,viewMode,image,content));
        response.sendRedirect("/posts");
    }
}
