package com.itwill.post.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.itwill.post.model.Post;

import oracle.jdbc.OracleDriver;



// JUnit Test(자바 단위 테스트)를 하기 위한 클래스
// JDBC(Java Database Connectivity) 테스트 - ojdbc11 라이브러리 동작 여부 테스트.
// main 메서드를 만들지 않고, 테스트 메서드를 작성하면
// junit-jupiter-engine에서 테스트 메서드를 실행함. 
@TestMethodOrder(OrderAnnotation.class) //-> 테스트 메서드 실행 순서를 애너테이션으로 설정함.
public class jdbcTest {
    
    // Oracle 데이터베이스 접속 주소
    private static final String URL = "jdbc:oracle:thin:192.168.20.31:1521:xe";
    // 데이터베이스 접속 계정
    private static final String USER = "scott";
    // 데이터베이스 접속 비밀번호
    private static final String PASSWORD = "tiger";
    
    // 테스트 메서드 작성:
    // 준수사항 4가지
    // 1. 반드시 public이어야함(가시성)
    //      junit-engine이 실행하기 때문에 찾을 수 있게 public으로 설정한다
    // 2. 리턴타입은 void여야함
    //      메서드 안에서 테스트가 끝나야 한다. 
    // 3. 파라미터를 갖지 않음
    // 4. @Test 애너테이션 사용.
    // 테스트 성공/실패 여부는 테스트 메서드 작성자가 설정.
    
    public static final String SQL_SELECT_ALL = "select * from posts";
    
    @Test
    @Order(2)
    public void testSelect() throws SQLException {
        // 1. JDBC 라이브러리를 Drivermaneger에 등록
        DriverManager.registerDriver(new OracleDriver());
        System.out.println("OJDBC 드라이버 등록 성공");
        
        // 2. 등록된 JDBC 드라이버를 사용해서 데이터베이스 서버에 접속
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Assertions.assertNotNull(conn);
        // -> conn이 null이 아니면 테스트 성공, 그렇지 않으면 테스트 실패
        System.out.println("conn: " + conn);
      
        // TODO: POSTS 테이블의 전체 내용을 검색(select)하고 
        // ArrayList<Post>를 생성
        // 그 결과를 콘솔창에 출력
        // ArrayList<Post>의 원소 개수는 1개임을 주장
        PreparedStatement stmt = null;
        ResultSet rs = null;
        stmt = conn.prepareStatement(SQL_SELECT_ALL);
        rs = stmt.executeQuery();
        List<Post> posts = new ArrayList<>(); 
        while(rs.next()) {
            long id = rs.getInt("id");
            String title = rs.getString("title");
            String content = rs.getString("content");
            String author = rs.getString("author");
            LocalDateTime createdTime = rs.getTimestamp("created_time").toLocalDateTime();
            LocalDateTime modifiedTime = rs.getTimestamp("modified_time").toLocalDateTime();
            
            Post post = new Post(id, title, content, author, createdTime, modifiedTime);
            System.out.println(post);
            posts.add(post);
        }
        Assertions.assertEquals(3, posts.size());
        // 데이터베이스와 연결된 접속을 해제
        rs.close();
        stmt.close();
        conn.close();
        System.out.println("연결 해제 성공");
    }
    
    public static final String SQL_INSERT = "insert into posts (title, content, author, modified_time) values (?,?,?,?)";
    
    @Test // JUnit 엔진에서 호출할 테스트 메서드
    @Order(1)
    public void testInsert() throws SQLException {
        // Driver 등록 -> Connection -> PreparedStatement -> execute -> 결과처리 -> 리소스 해제
        DriverManager.registerDriver(new OracleDriver());
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        
        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
        stmt.setString(1, "제목");
        stmt.setString(2, "내용");
        stmt.setString(3, "다한");
        LocalDateTime now = LocalDateTime.now();
        Timestamp tnow = Timestamp.valueOf(now);
        stmt.setTimestamp(4, tnow);
        
        int result = stmt.executeUpdate();
        Assertions.assertEquals(1, result);
        
        stmt.close();
        conn.close();
        System.out.println("연결 해제 성공");
    }
    
}
