package service.impl;

import model.Status;
import model.ViewMode;
import service.ViewModeService;

import java.sql.*;
import java.util.ArrayList;
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
        List<ViewMode> viewModes = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM view_mode")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                viewModes.add(new ViewMode(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewModes;
    }

    @Override
    public void add(ViewMode viewMode) throws SQLException {

    }

    @Override
    public ViewMode findById(int id) {
        List<ViewMode> viewModes = findAll();
        for (ViewMode v : viewModes) {
            if (v.getId() == id) {
                return v;
            }
        }
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
