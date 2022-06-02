package service.impl;

import model.Post;
import model.User;
import service.PostService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostSeviceImpl implements PostService {
    public PostSeviceImpl() {
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
    public List<Post> findAll() {
    return null;
    }

    @Override
    public void add(Post post) throws SQLException {

    }

    @Override
    public Post findById(int id) {
        return null;
    }

    @Override
    public boolean update(Post post) {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<Post> findByName(String name) {
        return null;
    }
}
