package service;

import model.Post;

import java.sql.SQLException;
import java.util.List;

public class PostSeviceImpl implements PostService {

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
