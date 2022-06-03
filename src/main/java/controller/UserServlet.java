package controller;

import model.FriendShip;
import model.User;
import service.impl.FriendShipServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;


@WebServlet(name = "UserServlet", urlPatterns= "/users")
public class UserServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();
    FriendShipServiceImpl friendShipService = new FriendShipServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "profile":
                showFormMyProfile(request,response);
                break;
            case "my-profile":
                showFormProfile(request,response);
                break;
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

    private void showFormMyProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentUsersId = UserServiceImpl.currentUsers.getId();
        User currentUser = userService.findById(currentUsersId);
        request.setAttribute("currentUser", currentUser);
        List<FriendShip> friendShips = friendShipService.findByUserId(currentUsersId);
        request.setAttribute("friendShips", friendShips);
        request.getRequestDispatcher("jsp/my-profile.jsp").forward(request,response);
    }

    private void showFormProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("user", user);
        List<FriendShip> friendShips = friendShipService.findByUserId(id);
        request.setAttribute("friendShips", friendShips);
        List<FriendShip> mutualFriends = friendShipService.findMutualByUserId(user.getId(), UserServiceImpl.currentUsers.getId());
        request.setAttribute("mutualFriends", mutualFriends);
        request.getRequestDispatcher("jsp/profile.jsp").forward(request,response);
    }

    private void showRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/register.jsp");
        requestDispatcher.forward(request,response);
    }

    private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login-register/login.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/login.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                login(request, response, session);
                break;
            case "register":
                try {
                    register(request,response);
                } catch (ParseException | SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ParseException, SQLException, ServletException, IOException {
        String name = request.getParameter("full_name");
        String email = request.getParameter("email");
        String avatar = "zyro-image.jpg";
        String date_of_birth = request.getParameter("date_of_birth");
        String password = request.getParameter("password");
        User user = new User(name, email, avatar, date_of_birth, password);
        if (userService.checkRegister(user)){
            userService.add(user);
            request.getRequestDispatcher("jsp/login-register/login.jsp").forward(request,response);
        } else {
            response.sendRedirect("/users?action=register");
        }

    }


    private void login(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/homepage/homepage.jsp");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (userService.checkLogin(email,password)){
            session.setAttribute("user", UserServiceImpl.currentUsers);
            List<User> otherUsers = userService.findAllOtherUser(UserServiceImpl.currentUsers.getId());
            session.setAttribute("otherUsers", otherUsers);
            requestDispatcher.forward(request,response);
        }else {
            response.sendRedirect("/users?action=login");
        }

    }
}
