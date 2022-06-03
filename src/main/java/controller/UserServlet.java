package controller;

import model.FriendShip;
import model.User;
import service.impl.FriendShipServiceImpl;
import service.impl.StatusServiceImpl;
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
    StatusServiceImpl statusService = new StatusServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "my-profile":
                showFormMyProfile(request,response);
                break;
            case "profile":
                showFormProfile(request,response);
                break;
            default:
                showFormLogin(request, response);
        }
    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/login-register/login.jsp").forward(request,response);
    }

    private void showFormMyProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentUsersId = UserServiceImpl.currentUsers.getId();
        User currentUser = userService.findById(currentUsersId);
        request.setAttribute("currentUser", currentUser);
        List<User> myFriends = friendShipService.findFriendsByUserId(currentUsersId);
        request.setAttribute("myFriends", myFriends);
        request.getRequestDispatcher("jsp/my-profile.jsp").forward(request,response);
    }

    private void showFormProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("user", user);
        List<User> friends = friendShipService.findFriendsByUserId(id);
        request.setAttribute("friends", friends);
        List<User> mutualFriends = friendShipService.findMutualByUserId(user.getId(), UserServiceImpl.currentUsers.getId());
        request.setAttribute("mutualFriends", mutualFriends);
        request.getRequestDispatcher("jsp/profile.jsp").forward(request,response);
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
            case "send-invitation":
                try {
                    sendInvitation(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
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
            case "make-friend":
                makeFriend(request, response);
                break;
            case "delete-request":
                deleteRequest(request, response);
                break;
        }
    }

    private void makeFriend(HttpServletRequest request, HttpServletResponse response) {
        int userId = Integer.parseInt(request.getParameter("id"));

    }

    private void deleteRequest(HttpServletRequest request, HttpServletResponse response) {
        int userId = Integer.parseInt(request.getParameter("id"));
    }

    private void sendInvitation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        FriendShip friendShip = new FriendShip(UserServiceImpl.currentUsers, userService.findById(userId), statusService.findById(2));
        friendShipService.add(friendShip);
        response.sendRedirect("/users?action=profile");
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
            session.setAttribute("currentUser", UserServiceImpl.currentUsers);
            List<User> otherUsers = friendShipService.findAllOtherFriends(UserServiceImpl.currentUsers.getId());
            session.setAttribute("otherUsers", otherUsers);
            List<User> friendRequests = friendShipService.findFriendRequests(UserServiceImpl.currentUsers.getId());
            session.setAttribute("friendRequests", friendRequests);
            requestDispatcher.forward(request,response);
        }else {
            response.sendRedirect("/users?action=login");
        }

    }
}
