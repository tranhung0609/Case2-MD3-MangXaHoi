package service.impl;

import model.Comment;
import model.Post;
import service.PostService;
import service.ViewModeService;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PostServiceImpl implements PostService {
    UserServiceImpl userService = new UserServiceImpl();
    ViewModeService viewModeService = new ViewModeServiceImpl();
    public PostServiceImpl() {
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
        List<Post> posts = new ArrayList<>();
        CommentServiceImpl commentService = new CommentServiceImpl();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM posts")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                int commentId = rs.getInt("comment_id");
                String time = rs.getString("time");
                int likeCount = rs.getInt("like_Count");
                int viewModeId= rs.getInt("view_mode_id");
                String image = rs.getString("image");
                String content = rs.getString("content");
                posts.add(new Post(id,userService.findById(userId),
                        commentService.findById(commentId),time,likeCount,viewModeService.findById(viewModeId),image,content));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public void add(Post post) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into posts(user_id,comment_id,time,like_count,view_mode_id,image,content) values (?,?,?,?,?,?,?)")) {
            preparedStatement.setInt(1, post.getUser().getId());
            preparedStatement.setInt(2,post.getComment().getId());
            preparedStatement.setString(3, post.getTime());
            preparedStatement.setInt(4,post.getLikeCount());
            preparedStatement.setInt(5,post.getViewMode().getId());
            preparedStatement.setString(6,post.getImage());
            preparedStatement.setString(7,post.getContent());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
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
