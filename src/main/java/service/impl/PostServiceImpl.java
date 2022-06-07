package service.impl;

import model.Comment;
import model.Post;
import model.User;
import service.PostService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostServiceImpl implements PostService {
    UserServiceImpl userService = new UserServiceImpl();
    ViewModeServiceImpl viewModeService = new ViewModeServiceImpl();
    FriendShipServiceImpl friendShipService = new FriendShipServiceImpl();

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
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM posts ORDER BY time DESC")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                String time = rs.getString("time");
                int commentCount = rs.getInt("comment_count");
                int likeCount = rs.getInt("like_count");
                int viewModeId = rs.getInt("view_mode_id");
                String image = rs.getString("image");
                String content = rs.getString("content");
                List<Comment> comments = findByPostId(id);
                posts.add(new Post(id, userService.findById(userId), time, commentCount, likeCount, viewModeService.findById(viewModeId), image, content, comments));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public List<Comment> findByPostId(int postId) {
        List<Comment> comments = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM comment WHERE post_id = ?")) {
            preparedStatement.setInt(1, postId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                String content = rs.getString("content");
                String time = rs.getString("time");
                comments.add(new Comment(id, postId , userService.findById(userId), time, content));
//                comments.add(new Comment(id, findById(postId) , userService.findById(userId), time, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    public List<Post> findAllPublic() {
        List<Post> publicPosts = new ArrayList<>();
        List<Post> posts = findAll();
        for (Post p : posts) {
            if (p.getViewMode().getId() == 1) {
                publicPosts.add(p);
            }
        }
        return publicPosts;
    }

    public List<Post> findAllPublicByUserId(int userId) {
        List<Post> publicPosts = new ArrayList<>();
        List<Post> posts = findAllPublic();
        for (Post p : posts) {
            if (p.getUser().getId() == userId) {
                publicPosts.add(p);
            }
        }
        return publicPosts;
    }

    public List<Post> findAllOfFriends(int userId) {
        List<Post> postsOfFriends = new ArrayList<>();
        List<Post> posts = findAllPublic();
        List<User> friends = friendShipService.findFriendsByUserId(userId);
        for (Post p : posts) {
            for (User u : friends) {
                if ((p.getUser().getId() == u.getId())
                        || (p.getUser().getId() == userId)) {
                    postsOfFriends.add(p);
                    break;
                }
            }
        }
        return postsOfFriends;
    }

    public List<Post> findAllMyPosts(int userId) {
        List<Post> posts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM posts WHERE user_id = ? ORDER BY time DESC")) {
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String time = rs.getString("time");
                int commentCount = rs.getInt("comment_count");
                int likeCount = rs.getInt("like_count");
                int viewModeId = rs.getInt("view_mode_id");
                String image = rs.getString("image");
                String content = rs.getString("content");
                List<Comment> comments = findByPostId(id);
                posts.add(new Post(id, userService.findById(userId), time, commentCount, likeCount, viewModeService.findById(viewModeId), image, content, comments));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public void add(Post post) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO posts (user_id, time, comment_count, like_count, view_mode_id, image, content) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setInt(1, post.getUser().getId());
            preparedStatement.setString(2, post.getTime());
            preparedStatement.setInt(3, post.getCommentCount());
            preparedStatement.setInt(4, post.getLikeCount());
            preparedStatement.setInt(5, post.getViewMode().getId());
            preparedStatement.setString(6, post.getImage());
            preparedStatement.setString(7, post.getContent());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Post findById(int id) {
        List<Post> posts = findAll();
        for (Post p : posts) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean update(Post post) {
        boolean rowUpdate = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("UPDATE posts SET time = ?, comment_count = ?, like_count = ?, view_mode_id = ?, image = ?, content = ? WHERE id = ?;")) {
            preparedStatement.setString(1, post.getTime());
            preparedStatement.setInt(2, post.getCommentCount ());
            preparedStatement.setInt(3, post.getLikeCount());
            preparedStatement.setInt(4, post.getViewMode().getId());
            preparedStatement.setString(5, post.getImage());
            preparedStatement.setString(6, post.getContent());
            preparedStatement.setInt(7, post.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
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
