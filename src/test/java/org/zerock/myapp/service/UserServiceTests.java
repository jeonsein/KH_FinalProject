package org.zerock.myapp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.ServiceException;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2

// JUnit test class는 무조건 반드시 매개변수 없는 기본 생성자가 있어야 한다! (대전제) (**)
//@AllArgsConstructor // XX : Junit에서는 용납되지 않음!
@NoArgsConstructor

// For run spring framework for JUnit v4
//@RunWith(SpringRunner.class)					opt.1
//@RunWith(SpringJUnit4ClassRunner.class)		opt.2

// For run spring framework for JUnit v5
@ExtendWith(SpringExtension.class)

// 공용 Spring 설정 파일 지정
@ContextConfiguration(locations= { "file:src/main/webapp/WEB-INF/spring/**/root-*.xml" })

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTests {

	// 주입!
	@Inject
	private UserService userService;

	@BeforeAll
	void beforeAll() {	// 1회성 전처리
		
		log.trace("beforeAll() invoked.");
		
		assert this.userService != null;
//		assertNotNull(this.userService);
		log.info("\t+ this.userService: {}", this.userService);
		
	} // beforeAll()
	
	@Test
	void contextLoads() {
		log.trace("contextLoads() invoked.");
	
	} // contextLoads()
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("selectUser")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void login() throws ServiceException {
		log.trace("login() invoked.");
		
		LoginDTO dto = new LoginDTO();
		dto.setUserid("USER_1");
		dto.setUserpw("PASS_1");
		dto.setRememberMe(false);
		
		UserVO vo = this.userService.login(dto);
		
		assertNotNull(vo);
		log.info("\t+ vo: {}", vo);
		
	} // login()

	
	
} // end class
