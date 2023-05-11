package com.itwill.post.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// DBCP(Database Connection pool) HikariCP 라이브러리 단위 테스트
public class DbcpTest {
    // Log4j2(인터페이스) 기능을 구현한 Slf4j(구현 클래스) 라이브러리의 로깅 기능을 사용해서 로그 출력:
    private final Logger log = LoggerFactory.getLogger(DbcpTest.class);
    
    @Test // JUnit 단위 테스트 엔진이 실행할 메서드.
    public void testHikariCP() throws SQLException {
        // HikariCP 환경 설정을 위한 객체 생성:
        HikariConfig config = new HikariConfig();
        
        // HikariCP 환경 설정:
        config.setDriverClassName("oracle.jdbc.OracleDriver"); // JDBC 드라이버(라이브러리) 이름
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe"); // DB 접속 URL
        config.setUsername("scott"); // DB 접속 계정
        config.setPassword("tiger"); // DB 접속 비밀번호
        
        // 환경 설정을 갖는 Connection Pool(Data Source) 객체 생성:
        HikariDataSource ds = new HikariDataSource(config);
        
        // ds가 null이 아니면 단위 테스트 성공, 그렇지 않으면 실패. ds에 환경설정 값(config)이 들어가있나?
        Assertions.assertNotNull(ds);
        
        log.info("ds={}", ds);
        
        // Connection Pool(Data Source)에서 Connection 객체를 빌려옴
        Connection conn = ds.getConnection();
        
        // conn이 null이 아니면 단위테스트 성공, 그렇지 않으면 실패.
        Assertions.assertNotNull(conn);
        log.info("conn = {}", conn);
        
        // 사용했던 Connection 객체를 Pool에 반환:
        conn.close(); // 데이터베이스 서버와의 물리적으로 끊는 게 아님. Pool이 연결을 가지고 있음.
        log.info("conn 반환 성공");
        
    }
}
