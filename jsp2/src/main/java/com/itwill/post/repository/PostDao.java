package com.itwill.post.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.datasource.HikariDataSourceUtil;
import com.itwill.post.model.Post;
import com.zaxxer.hikari.HikariDataSource;

// Repository(persistence) Layer(저장소/영속성 계층)
// DB CRUD(Create, Read, Update, Delete) 작업을 수행하는 계층
public class PostDao {
    // Slf4j 로깅 기능 사용:
    private static final Logger log = LoggerFactory.getLogger(PostDao.class);
    
    // singleton
    private static PostDao instance = null;
    
    private HikariDataSource ds;
    
    private PostDao() {
        ds = HikariDataSourceUtil.getinstance().getDataSource();
    }
    
    public static PostDao getinstance() {
        if (instance == null) {
            instance = new PostDao();
        }
        return instance;
    }
    
    // POSTS 테이블에서 전체 레코드를 id 내림차순으로 정렬(최근 작성 포스트 먼저)해서 검색.
    private static final String SQL_SELECT_ALL = "select * from POSTS order by ID desc";
    
    public List<Post> select() {
        List<Post> list = new ArrayList<>();
        
        log.info(SQL_SELECT_ALL);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Post post = recordToPost(rs);
                list.add(post);
            }
            log.info("# of rows = {}", list.size());
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private Post recordToPost(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String title = rs.getString("title");
        String content = rs.getString("content");
        String author = rs.getString("author");
        LocalDateTime createdTime = rs.getTimestamp("created_time").toLocalDateTime();
        LocalDateTime modifiedTime = rs.getTimestamp("modified_time").toLocalDateTime();
        
        Post post = new Post(id, title, content, author, createdTime, modifiedTime);
        return post;
    }

    private static final String SQL_INSERT = "insert into posts (title, content, author) values (?, ?, ?)";
    
    public int insert(Post post) {
        log.info("insert({})", post);
        
        
        int result = 0; // executeUpdate() 결과(insert 결과)를 저장할 변수
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setString(3, post.getAuthor());            
            
            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static final String SQL_SELECT_BY_ID = "select * from posts where id=?";
    
    public Post selectById(long id) {
        Post post = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                post = recordToPost(rs);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return post;
    }
}
