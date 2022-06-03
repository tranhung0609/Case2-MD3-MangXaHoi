package service.impl;

import model.Post;
import service.CommentService;
import service.PostService;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PostServiceImpl implements PostService {
    UserServiceImpl userService = new UserServiceImpl();
    CommentServiceImpl commentService = new CommentServiceImpl();
    ViewModeServiceImpl viewModeService = new ViewModeServiceImpl();


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
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM posts")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                int commentId = rs.getInt("comment_id");
                String time = rs.getString("time");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //
                LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
                int likeCount = rs.getInt("like_count");
                int viewModeId = rs.getInt("view_mode_id");
                String image = rs.getString("image");
                String content = rs.getString("content");

                posts.add(new Post(id, userService.findById(userId), commentId, dateTime, likeCount, viewModeService.findById(viewModeId), image, content));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public void add(Post post) throws SQLException {

    }

    @Override
    public Post findById(int id) {
        return null;
    }

    @Override
    public boolean update(Post post) {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<Post> findByName(String name) {
        return null;
    }
}
