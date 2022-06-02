package service.impl;

import model.FriendShip;
import service.FriendShipService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendShipServiceImpl implements FriendShipService {
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
//        List<FriendShip> friendShips = new ArrayList<>();
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement =
//                     connection.prepareStatement("SELECT * FROM friend_ship")) {
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                int userId1 = rs.getInt("user_id_1");
//                int userId2 = rs.getInt("user_id_2");
//                int status = rs.getInt("status_id");
//                friendShips.add(new FriendShip(id, , accountService.findById(accountId), status));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return orders;
        return null;
    }

    @Override
    public void add(FriendShip friendShip) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO friend_ship(user_id_1, user_id_2, status_id) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, friendShip.getUser1().getId());
            preparedStatement.setInt(1, friendShip.getUser2().getId());
            preparedStatement.setInt(3, friendShip.getStatus().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public FriendShip findById(int id) {

        return null;
    }

    @Override //chỉnh sửa trạng thái bạn bè
    public boolean update(FriendShip friendShip) {

        return false;
    }

    public void updateStatus() {
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE friend_ship SET status_id = ?)")) {
//            preparedStatement.setInt(1, friendShip.getUser1().getId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//        }
    }

    @Override //hủy kết bạn >>> xóa trong db
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override  //lấy list bạn bè theo tên
    public List<FriendShip> findByName(String name) {
        return null;
    }
}
