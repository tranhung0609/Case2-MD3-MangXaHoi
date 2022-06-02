package service.impl;

import model.FriendShip;
import model.Like;
import service.LikeService;
import service.LikeStatusService;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
                     connection.prepareStatement("SELECT * FROM like")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int postId = rs.getInt("post_id");
                int userId = rs.getInt("user_id");
                String time = rs.getString("time");
                int likeStatusId = rs.getInt("statusId");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(time, formatter); //chuyển String thành DateTime
                likes.add(new Like(id, postService.findById(postId), userService.findById(userId), dateTime, likeStatusService.findById(likeStatusId)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likes;
    }

    @Override
    public void add(Like like) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO like (post_id, user_id, time, status_id) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setInt(1, like.getPost().getId());
            preparedStatement.setInt(2, like.getUser().getId());
            DateTimeFormatter dateFormatter = DateTimeFormatter
                    .ofPattern("yyyy/MM/dd HH:mm:ss");
            String time = like.getTime().format(dateFormatter); // chuyển DateTime thành string
            preparedStatement.setString(3,time);
            preparedStatement.setInt(4, like.getLikeStatus().getId());
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

    @Override
    public boolean update(Like like) {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<Like> findByName(String name) {
        return null;
    }
}
