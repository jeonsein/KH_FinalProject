package org.zerock.myapp.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

//Spring Framework도 함께 구동!
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/**/root-context.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HikariDataSourceBeanTests {

	@Setter(onMethod_= {@Autowired})
	private DataSource dataSource; // 의존성 주입 대상필드
	
   @BeforeAll
   void beforeAll() {
      log.trace("beforeAll() invoked.");
      
      assertNotNull(this.dataSource);
      log.info("\t+this.datasource:{}", this.dataSource);
      
   } // beforeAll()
   
//   @Test
//   @Order(1)
//   @DisplayName("테스트1: HikariCP 연결 테스트")
//   @Timeout(value=1, unit=TimeUnit.SECONDS)
//   void contextLoads() {
//      
//      log.trace("\t+**************************** invoked.");
//      
//   } // contextLoads()

   
//   @Disable
   @Test
   @Order(1)
   @DisplayName("test1: to get a JDBC connection from the data source")
   @Timeout(value=1, unit=TimeUnit.SECONDS)
   void testgetconnection() throws SQLException {
      
      log.trace("testgetconnection invoked.");
      
      @Cleanup
      Connection conn = this.dataSource.getConnection();
      
      Objects.requireNonNull(conn);
      log.info("\t+conn:{}", conn);
      
   } // contextLoads()
   
// @Disable
   @Test
   @Order(2)
   @DisplayName("test2: to test a SQL using the connection")
   @Timeout(value=1, unit=TimeUnit.SECONDS)
   void testsql() throws SQLException {
	   log.trace("testsql invoked.");
    
	   @Cleanup Connection conn = this.dataSource.getConnection();
	   @Cleanup Statement stmt = conn.createStatement();
	   @Cleanup ResultSet rs = stmt.executeQuery("SELECT * FROM DEPT");
	   
	   while(rs.next()) {
		   Integer deptno = rs.getInt("DEPTNO");
		   String dname = rs.getString("DNAME");
		   String loc = rs.getString("LOC");
		   
		   log.info("({}, {}, {})", deptno, dname, loc);
	
	   } // while
   } // testsql()
   
} // end class