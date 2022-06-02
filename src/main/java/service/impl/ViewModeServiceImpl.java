package service.impl;

import model.ViewMode;
import service.ViewModeService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ViewModeServiceImpl implements ViewModeService {
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
    public List<ViewMode> findAll() {
        return null;
    }

    @Override
    public void add(ViewMode viewMode) throws SQLException {

    }

    @Override
    public ViewMode findById(int id) {
        return null;
    }

    @Override
    public boolean update(ViewMode viewMode) {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<ViewMode> findByName(String name) {
        return null;
    }
}
