package org.zerock.myapp.mapper;

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
import org.zerock.myapp.domain.MemberDTO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= { "file:src/main/webapp/WEB-INF/spring/**/root-*.xml" })

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberMapperTests {

	// 의존성 주입
	@Inject
	private MemberMapper memberMapper;
	
	@BeforeAll
	void beforeAll() {	// 1회성 전처리
		
		log.trace("beforeAll() invoked.");
		
		assert this.memberMapper != null;
//		assertNotNull(this.userService);
		log.info("\t+ this.userService: {}", this.memberMapper);
		
	} // beforeAll()
		
	
////	로그인 테스트
////	@Disabled
//	@Test
//	@Order(1)
//	@DisplayName("memberLogin Test")
//	@Timeout(value=1, unit=TimeUnit.SECONDS)
//	void memberLogin() throws Exception {
//		MemberVO memberVO = new MemberVO();
//		
//		memberVO.setMEMBER_ID("TEST_SENGNA");
//		memberVO.setMEMBER_PW("TEST_SENGNA");
//				
//		memberMapper.memberLogin(memberVO);
//	
//		log.info("Login 테스트 결과: {}", memberMapper.memberLogin(memberVO));
//		
//		
//	} // memberLogin()

//	@Disabled
	@Test
	@Order(1)
	@DisplayName("memberSignup")
	@Timeout(value = 1, unit = TimeUnit.MINUTES)
	public void memberSignup(MemberDTO memberDTO) throws Exception{
		log.info("memberSignup() invoked.");
		
		
		
		memberDTO.setId("ho0song");
		memberDTO.setPassword("1234567890z");
		memberDTO.setName("차은우");
		memberDTO.setEmail("eunwoochachacha@gmail.com");
		memberDTO.setTel("01035552020");
		memberDTO.setAddress1(12345);
		memberDTO.setAddress2("강남역 10번 출구");
		memberDTO.setAddress3("dd");
		memberDTO.setGender("남자");
		memberDTO.setAdminCk(1);
		memberDTO.setBirth_date("1999-01-01");
//		memberDTO.setSignup_date(1991-01-01 21:09:10);
		
		
		memberMapper.memberSignupTest(memberDTO);
		
	} // memberSignup
	
} // end class
