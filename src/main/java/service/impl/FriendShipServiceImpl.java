package service.impl;

import model.FriendShip;
import model.User;
import service.FriendShipService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendShipServiceImpl implements FriendShipService {
    StatusServiceImpl statusService = new StatusServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    static String jdbcURL = "jdbc:mysql://localhost:3306/social_network_case_md3?useSSL=false";
    static String jdbcUsername = "root";
    static String jdbcPassword = "1234";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<FriendShip> findAll() {
        List<FriendShip> friendShips = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM friend_ship")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId1 = rs.getInt("user_id_1");
                int userId2 = rs.getInt("user_id_2");
                int statusId = rs.getInt("status_id");
                friendShips.add(new FriendShip(id, userService.findById(userId1), userService.findById(userId2), statusService.findById(statusId)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return friendShips;
    }

    @Override
    public void add(FriendShip friendShip) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO friend_ship(user_id_1, user_id_2, status_id) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, friendShip.getUser1().getId());
            preparedStatement.setInt(2, friendShip.getUser2().getId());
            preparedStatement.setInt(3, friendShip.getStatus().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<FriendShip> findByUserId(int userId) {
        List<FriendShip> friendShips = findAll();
        for (FriendShip f : friendShips) {
            if (f.getUser1().getId() == userId || f.getUser2().getId() == userId) {
                friendShips.add(f);
            }
        }
        return friendShips;
    }

    public List<FriendShip> findMutualByUserId(int userId1, int userId2) {
        List<FriendShip> mutualFriends = new ArrayList<>();
        List<FriendShip> friendShips1 = findByUserId(userId1);
        List<FriendShip> friendShips2 = findByUserId(userId2);
        for (FriendShip f1 : friendShips1) {
            for (FriendShip f2 : friendShips2) {
                if (f1.getId() == f2.getId()) {
                    mutualFriends.add(f1);
                }
            }
        }
        return mutualFriends;
    }

    @Override
    public FriendShip findById(int id) {
        List<FriendShip> friendShips = findAll();
        for (FriendShip f : friendShips) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    @Override //chỉnh sửa trạng thái bạn bè
    public boolean update(FriendShip friendShip) {

        return false;
    }

    public void updateStatus(int statusId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE friend_ship SET status_id = ?)")) {
            preparedStatement.setInt(1, statusId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override //hủy kết bạn >>> xóa trong db
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM friend_ship WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override  //lấy list bạn bè theo tên
    public List<FriendShip> findByName(String name) {
        return null;
    }
}
