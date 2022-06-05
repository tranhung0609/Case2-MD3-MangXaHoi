package service.impl;

import model.User;
import service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public static User currentUsers;

    static String jdbcURL = "jdbc:mysql://localhost:3306/social_network_case_md3?useSSL=false";
    static String jdbcUsername = "root";
    static String jdbcPassword = "12111992";

    public static final String UPDATE_USER_SQL = "UPDATE user SET full_name = ?, email = ?, avatar = ?, date_of_birth= ?, password = ?  WHERE id = ?;";

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
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO User(full_name,email,avatar, date_of_birth,password) VALUES (?, ?, ?, ?,?)")) {
            preparedStatement.setString(1, user.getFull_name());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAvatar());
            preparedStatement.setString(4, user.getDate_of_birth());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public User findById(int id) {
        User user = new User();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE id = ?")){
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String full_name = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String avatar = resultSet.getString("avatar");
                String date_of_birth = resultSet.getString("date_of_birth");
                String password = resultSet.getString("password");
                user = new User(id,full_name,email,avatar,date_of_birth,password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public List<User> findByName(String name) {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE name LIKE ? AND accountId <> ?")
        ) {
            preparedStatement.setString(1,"%" + name + "%");
            preparedStatement.setInt(2,UserServiceImpl.currentUsers.getId());
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
    public boolean update(User user) throws SQLException {
        boolean rowUpdate = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(UPDATE_USER_SQL)) {
            preparedStatement.setString(1, user.getFull_name());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAvatar());
            preparedStatement.setString(4, user.getDate_of_birth());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setInt(6, user.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
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
    public boolean checkRegister(User user) throws SQLException {
        boolean check = true;
        List<User> users = findAll();
        for (User a : users) {
            if (a.getEmail().equals(user.getEmail())) {
                check = false;
                break;
            }
        }
        return check;
    }
}
