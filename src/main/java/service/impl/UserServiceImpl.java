package service.impl;

import model.FriendShip;
import model.Like;
import model.User;
import service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public static User currentUsers;

    static String jdbcURL = "jdbc:mysql://localhost:3306/social_network_case_md3?useSSL=false";
    static String jdbcUsername = "root";
    static String jdbcPassword = "123456";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(UserServiceImpl.jdbcURL, UserServiceImpl.jdbcUsername, UserServiceImpl.jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void add(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (full_name, email, avatar, date_of_birth, password) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAvatar());
            preparedStatement.setString(4,user.getDateOfBirth());
            preparedStatement.setString(5, user.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }

    }

    @Override
    public User findById(int id) {
        List<User> users = findAll();
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM user")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                String email = rs.getString("email");
                String avatar = rs.getString("avatar");
                String date_of_birth = rs.getString("date_of_birth");
                String password = rs.getString("password");
                users.add(new User(id,full_name,email,avatar,date_of_birth,password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<User> findAllOtherUser(int userId) {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM user WHERE id <> ? ")) {
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                String email = rs.getString("email");
                String avatar = rs.getString("avatar");
                String date_of_birth = rs.getString("date_of_birth");
                String password = rs.getString("password");
                users.add(new User(id,full_name,email,avatar,date_of_birth,password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    @Override
    public boolean update(User account) {
        return false;
    }

    public boolean checkRegister(User user) throws SQLException {
        boolean check = true;
        List<User> users = findAll();
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail())) {
                check = false;
                break;
            }
        }
        return check;
    }

    public boolean checkLogin(String email, String password) {
        boolean check = false;
        List<User> users = findAll();
        for (User a : users) {
            if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
                check = true;
                currentUsers = a;
                break;
            }
        }
        return check;
    }
}
