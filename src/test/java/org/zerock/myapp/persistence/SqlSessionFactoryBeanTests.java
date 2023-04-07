package org.zerock.myapp.persistence;

import java.sql.Connection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
//@AllArgsConstructor junit에서 의존성주입이 안된다

//spring framework를 함께 구동시킴
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/**/root-context.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SqlSessionFactoryBeanTests {
	
	@Setter(onMethod_=@Autowired)
	private SqlSessionFactory sqlSessionFactory;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeall invoked");
		
		assert this.sqlSessionFactory != null;
		log.info("\t+this.sqlsessionfactory:{}", this.sqlSessionFactory);
	}
	
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("test1: sqlsessionfactorybean")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testsqlsessionfactorybean() {
		log.trace("testsqlsessionfactorybean() invoked");
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		log.trace("\t+sqlsession:{}", sqlSession);
		
		Connection conn = sqlSession.getConnection();
		Objects.requireNonNull(conn);
		log.trace("\t+conn:{}", conn);
		
	} // contextLoads
	
	
} // end class
