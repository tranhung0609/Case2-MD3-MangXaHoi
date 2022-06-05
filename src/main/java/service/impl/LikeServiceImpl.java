package service.impl;

import model.Like;
import service.LikeService;
import service.LikeStatusService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LikeServiceImpl implements LikeService {
    UserServiceImpl userService = new UserServiceImpl();
    PostServiceImpl postService = new PostServiceImpl();
    LikeStatusService likeStatusService = new LikeStatusServiceImpl();


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
    public List<Like> findAll() {
        List<Like> likes = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM likes")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int postId = rs.getInt("post_id");
                int userId = rs.getInt("user_id");
                String time = rs.getString("time");
                int likeStatusId = rs.getInt("status_id");
                likes.add(new Like(id, postService.findById(postId), userService.findById(userId), time, likeStatusService.findById(likeStatusId)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likes;
    }

    @Override
    public void add(Like like) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO likes (post_id, user_id, time) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, like.getPost().getId());
            preparedStatement.setInt(2, like.getUser().getId());
            preparedStatement.setString(3,like.getTime());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Like findById(int id) {
        List<Like> likes = findAll();
        for (Like l : likes) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    public List<Like> findMyLikes(int userId) {
        List<Like> likes = findAll();
        List<Like> myLikes = new ArrayList<>();
        for (Like l : likes) {
            if (l.getUser().getId() == userId) {
                myLikes.add(l);
            }
        }
        return myLikes;
    }

    public boolean checkLike(int postId, int userId) {
        List<Like> myLikes = findMyLikes(userId);
        for (Like l : myLikes) {
            if (l.getPost().getId() == postId) {
                return false; // unlike
            }
        }
        return true; // like
    }

    @Override
    public boolean update(Like like) {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted = false;
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement =
//                     connection.prepareStatement("DELETE FROM accounts WHERE id = ?;")) {
//            preparedStatement.setInt(1, id);
//            rowDeleted = preparedStatement.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return rowDeleted;
        return false;
    }

    public boolean unlike(int postId, int userId) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM likes WHERE (post_id = ? AND user_id = ?);")) {
            preparedStatement.setInt(1, postId);
            preparedStatement.setInt(2, userId);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public List<Like> findByName(String name) {
        return null;
    }
}
