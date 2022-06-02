package controller;

import model.User;
import service.Impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
                Registers(request,response);
                break;
        }
    }

    private void Registers(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("full_name");
        String email = request.getParameter("email");
        String avatar = request.getParameter("avatar");
        String date_of_birth = request.getParameter("date_of_birth");
        String password = request.getParameter("password");
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
