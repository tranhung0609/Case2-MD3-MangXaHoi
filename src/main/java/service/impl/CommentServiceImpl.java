package service.impl;

import model.Comment;
import model.FriendShip;
import model.User;
import service.CommentService;
import service.UserService;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CommentServiceImpl implements CommentService {
    UserServiceImpl userService = new  UserServiceImpl();
    PostServiceImpl postService = new PostServiceImpl();

    public CommentServiceImpl() {
    }
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/social_network_case_md3?useSSL=false", "root", "1234");
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Comment> findAll() {
        List<Comment>comments = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM comment")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int postId = rs.getInt("post_id");
                int userId = rs.getInt("user_id");
                String time = rs.getString("time");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
                String content = rs.getString("content");
                comments.add(new Comment(id,postId, userService.findById(userId),dateTime,content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public void add(Comment comment) throws SQLException {

    }

    @Override
    public Comment findById(int id) {
        List<Comment> comments = findAll();
        for (Comment c : comments) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean update(Comment comment) {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<Comment> findByName(String name) {
        return null;
    }

}
