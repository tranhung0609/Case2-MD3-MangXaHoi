package controller;

import model.Post;
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

@WebServlet(name = "PostsServlet", value = "/posts")
public class PostsServlet extends HttpServlet {
    PostServiceImpl postService = new PostServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();
    ViewModeServiceImpl viewModeService = new ViewModeServiceImpl();

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
//            case "profile":
//                showFormProfile(request, response);
//                break;
//            case "homepage":
//                showFormHomePage(request, response);
//                break;
//            default:
//                showFormLogin(request, response);
        }
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
