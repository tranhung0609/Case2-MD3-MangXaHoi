package service.impl;

import model.LikeStatus;
import service.LikeStatusService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class LikeStatusServiceImpl implements LikeStatusService {
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
    public List<LikeStatus> findAll() {
        return null;
    }

    @Override
    public void add(LikeStatus likeStatus) throws SQLException {

    }

    @Override
    public LikeStatus findById(int id) {
        return null;
    }

    @Override
    public boolean update(LikeStatus likeStatus) {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<LikeStatus> findByName(String name) {
        return null;
    }
}
