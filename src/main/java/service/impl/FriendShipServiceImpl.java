package service.impl;

import model.FriendShip;
import service.FriendShipService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    @Override //hủy kết bạn >>> xóa trong db
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override  //lấy list bạn bè theo tên
    public List<FriendShip> findByName(String name) {
        return null;
    }
}
