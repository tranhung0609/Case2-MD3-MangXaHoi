package service.impl;

import model.Comment;
import model.User;
import service.CommentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl implements CommentService {
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
        List<Comment> comments = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM comment ORDER BY time DESC")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int postId = rs.getInt("post_id");
                int userId = rs.getInt("user_id");
                String time = rs.getString("time");
                String content = rs.getString("content");
                comments.add(new Comment(id,postId, userService.findById(userId), time, content));
//                comments.add(new Comment(id,postService.findById(postId), userService.findById(userId), time, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public void add(Comment comment) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO comment (post_id, user_id, time, content) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setInt(1, comment.getPostId());
            preparedStatement.setInt(2, comment.getUser().getId());
            preparedStatement.setString(3, comment.getTime());
            preparedStatement.setString(4,comment.getContent());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
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

    public List<Comment> findByPostId(int postId) {
        List<Comment> comments = new ArrayList<>();
        List<Comment> list = findAll();
        for (Comment c: list) {
            if (c.getPostId() == postId) {
                comments.add(c);
            }
        }
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement =
//                     connection.prepareStatement("SELECT * FROM comment WHERE post_id = ?")) {
//            preparedStatement.setInt(1, postId);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                int userId = rs.getInt("user_id");
//                String content = rs.getString("content");
//                String time = rs.getString("time");
//                comments.add(new Comment(id, postService.findById(postId) , userService.findById(userId), time, content));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return comments;
    }

    @Override
    public List<Comment> findByName(String name) {
        return null;
    }
}
