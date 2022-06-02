package service.Impl;

import model.User;
import service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public static User currentUsers;

    static String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce_case_md3?useSSL=false";
    static String jdbcUsername = "root";
    static String jdbcPassword = "12111992";

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

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM user ")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                String email = rs.getString("email");
                String avatar = rs.getString("avatar");
                Date date_of_birth = rs.getDate("date_of_birth");
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
    public boolean update(User account) throws SQLException {
        return false;
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
