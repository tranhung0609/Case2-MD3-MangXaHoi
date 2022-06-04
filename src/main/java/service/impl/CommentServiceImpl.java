package service.impl;

import model.Comment;
import model.User;
import service.CommentService;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    PostServiceImpl postService = new PostServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(FriendShipServiceImpl.jdbcURL, FriendShipServiceImpl.jdbcUsername, FriendShipServiceImpl.jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Comment> findAll() {

        return null;
    }

    @Override
    public void add(Comment comment) throws SQLException {

    }

    @Override
    public Comment findById(int id) {
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

    public List<Comment> findByPostId(int postId) {
        List<Comment> comments = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM comment WHERE post_id = ?")) {
            preparedStatement.setInt(1, postId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                String content = rs.getString("content");
                String time = rs.getString("time");
                comments.add(new Comment(id, postId , userService.findById(userId), time, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public List<Comment> findByName(String name) {
        return null;
    }
}
