package controller;

import model.Comment;
import service.impl.CommentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CommentServlet", urlPatterns = "/comments")
public class CommentServlet extends HttpServlet {
    CommentServiceImpl commentService = new CommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "comment":{
                showComment(request,response);
                break;
            }
            default:{
               showListComment(request,response);
            }

        }

    }

    private void showComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comment> comments = commentService.findAll();
        request.setAttribute("posts",comments);
        request.getRequestDispatcher("jsp/comment/postComment.jsp").forward(request, response);
    }

    private void showListComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comment> comments = commentService.findAll();
        request.setAttribute("comment",comments);
        request.getRequestDispatcher("jsp/comment/comment.jsp").forward(request, response);
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
            case "comment":{
                try {
                    comment(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
    }
}

    private void comment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String content = request.getParameter("content");
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter
                .ofPattern("dd/MM/yyyy HH:mm");
        String time = localDateTime.format(dateFormatter);
        commentService.add(new Comment(time,content));
        response.sendRedirect("posts");

    }
}
