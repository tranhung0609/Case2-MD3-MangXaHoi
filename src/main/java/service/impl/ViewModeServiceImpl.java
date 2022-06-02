package service.impl;

import model.ViewMode;
import service.ViewModeService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ViewModeServiceImpl implements ViewModeService {
    public ViewModeServiceImpl() {
    }
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/social_network_case_md3?useSSL=false", "root", "1234");
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
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
