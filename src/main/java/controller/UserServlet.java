package controller;

import model.User;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet(name = "UserServlet", urlPatterns= "/users")
public class UserServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "register":
                showRegister(request,response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            default:
                showFormLogin(request,response);
                break;
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("user", user);
        requestDispatcher.forward(request, response);
    }

    private void showRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login-register/login.jsp");
        requestDispatcher.forward(request,response);
    }

//    private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login-register/login.jsp");
//        requestDispatcher.forward(request,response);
//    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login-register/login.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                login(request, response);
                break;
            case "register":
                try {
                    Registers(request,response);
                } catch (ParseException | SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    edit(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String full_name = request.getParameter("full_name");
        String email = request.getParameter("email");
        String avatar = "image/4wvuq0i4ozs1q.jpg" ;
        String date_of_birth = request.getParameter("date_of_birth");
        String password = request.getParameter("password");
        User user = new User(full_name,email,avatar,date_of_birth,password);
        userService.update(user);
        response.sendRedirect("jsp/homepage/homepage.jsp");
    }

    private void Registers(HttpServletRequest request, HttpServletResponse response) throws ParseException, SQLException, ServletException, IOException {
        String full_name = request.getParameter("full_name");
        String email = request.getParameter("email");
        String avatar = "image/4wvuq0i4ozs1q.jpg" ;
        String date_of_birth = request.getParameter("date_of_birth");
        String password = request.getParameter("password");
        User user = new User(full_name,email,avatar, date_of_birth,password);
        if (userService.checkRegister(user)){
            userService.add(user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login-register/login.jsp");
            requestDispatcher.forward(request,response);
        }else {
            response.sendRedirect("/users?action=register");
        }


    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/homepage/homepage.jsp");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (userService.checkLogin(email,password)){
            request.setAttribute("user", UserServiceImpl.currentUsers);
            requestDispatcher.forward(request,response);
        }else {

            response.sendRedirect("users?action=login");
        }

    }
}
