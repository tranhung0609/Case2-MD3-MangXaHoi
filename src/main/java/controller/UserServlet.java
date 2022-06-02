package controller;

import model.User;
import service.Impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
            case "login":
                showFormLogin(request,response);
                break;
            case "register":
                showRegister(request,response);
                break;
            default:
                homePage(request,response);
                break;
        }
    }

    private void showRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/register.jsp");
        requestDispatcher.forward(request,response);
    }

    private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/home.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/login.jsp");
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
                Login(request, response);
                break;
            case "register":
                try {
                    Registers(request,response);
                } catch (ParseException | SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void Registers(HttpServletRequest request, HttpServletResponse response) throws ParseException, SQLException, ServletException, IOException {
        String full_name = request.getParameter("full_name");
        String email = request.getParameter("email");
        String avatar = "image/4wvuq0i4ozs1q.jpg" ;
        String date_of_birth = request.getParameter("date_of_birth");
        Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date_of_birth);
        String password = request.getParameter("password");
        User user = new User(full_name,email,avatar, date,password);
        if (userService.checkRegister(user)){
            userService.add(user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/login.jsp");
            requestDispatcher.forward(request,response);
        }else {
            response.sendRedirect("/users?action=register");
        }


    }


    private void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/home.jsp");
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
