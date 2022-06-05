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
            case "profile":
                showProfile(request,response);
                break;
            case "search":
                showFormSearch(request,response);
                break;
            default:
                showFormLogin(request,response);
                break;
        }
    }

    private void showFormSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<User>userList = userService.findByName(name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/search.jsp");
        request.setAttribute("list",userList);
        requestDispatcher.forward(request,response);
    }

    private void showProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/profile.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("user",user);
        requestDispatcher.forward(request,response);
    }


    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/edit.jsp");
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

    private void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String full_name = request.getParameter("full_name");
        String email = request.getParameter("email");
        String avatar = "image/4wvuq0i4ozs1q.jpg" ;
        String date_of_birth = request.getParameter("date_of_birth");
        String password = request.getParameter("password");
        User user = new User(id,full_name,email,avatar,date_of_birth,password);
        userService.update(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/homepage/homepage.jsp");
        request.setAttribute("user",UserServiceImpl.currentUsers);
        requestDispatcher.forward(request,response);
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
