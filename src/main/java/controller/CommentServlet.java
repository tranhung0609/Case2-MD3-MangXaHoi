package controller;

import model.Comment;
import service.impl.CommentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CommentServlet", value = "/Comments")
public class CommentServlet extends HttpServlet {
    CommentServiceImpl commentService = new CommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comment> comments = commentService.findAll();
        request.setAttribute("comment",comments);
        request.getRequestDispatcher("jsp/comment/comment.jsp").forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
