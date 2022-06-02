package service.impl;

import model.Comment;
import service.CommentService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    public CommentServiceImpl() {
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
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public void add(Comment comment) throws SQLException {

    }

    @Override
    public Comment findById(int id) {
        return null;
    }

    @Override
    public boolean update(Comment comment) {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<Comment> findByName(String name) {
        return null;
    }
}
