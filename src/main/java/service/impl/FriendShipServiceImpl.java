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

    public List<User> findFriendRequests(int userId) {
        List<User> friendRequests = new ArrayList<>();
        List<FriendShip> friendShips = findAll();
        for (FriendShip f : friendShips) {
            if (f.getStatus().getId() == 2 && f.getUser2().getId() == userId) {
                friendRequests.add(f.getUser1());
            }
        }
        return friendRequests;
    }

//    public int getRelationship(int userId1, int userId2) {
//        int count = 0;
//        List<FriendShip> friendShips = findAll();
//        for (FriendShip f : friendShips) {
//            if (f.getUser1().getId() == userId1){
//
//            }
//        }
//    }

//    public int sendInvitation(int userId) {
//        int count = 0;
//        List<User> users = findFriendsByUserId(UserServiceImpl.currentUsers.getId());
//        for (User u : users) {
//            if (u.getId() == userId){
//
//            }
//        }
//    }

    public List<User> findFriendsByUserId(int userId) {
        List<User> users = new ArrayList<>();
        List<FriendShip> friendShips = findAll();
        for (FriendShip f : friendShips) {
            if (f.getStatus().getId() == 1) {
                if (f.getUser1().getId() == userId) {
                    users.add(f.getUser2());
                } else if (f.getUser2().getId() == userId) {
                    users.add(f.getUser1());
                }
            }
        }
        return users;
    }

    public List<User> findMutualByUserId(int userId1, int userId2) {
        List<User> mutualFriends = new ArrayList<>();
        List<User> users1 = findFriendsByUserId(userId1);
        List<User> users2 = findFriendsByUserId(userId2);
        for (User u1 : users1) {
            for (User u2 : users2) {
                if (u1.getId() == u2.getId()) {
                    mutualFriends.add(u1);
                }
            }
        }
        return mutualFriends;
    }

    public List<User> findAllOtherFriends(int userId) {
        List<User> otherFriends = new ArrayList<>();
        List<User> allUsers = userService.findAllOtherUser(UserServiceImpl.currentUsers.getId());
        List<User> friends = findFriendsByUserId(userId);
        for (User a : allUsers) {
            int count = 0;
            for (User f : friends) {
                if (a.getId() == f.getId()) {
                    count = 1;
                    break;
                }
            }
            if (count == 0){
                otherFriends.add(a);
            }
        }
        return otherFriends;
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
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE friend_ship SET status_id = ? WHERE user_id_1 = ? AND user_id_2 = ?)")) {
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
