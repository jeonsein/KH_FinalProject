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
import org.zerock.myapp.domain.MemberVO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= { "file:src/main/webapp/WEB-INF/spring/**/root-*.xml" })

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberMapperTests {

	@Inject
	private MemberMapper memberMapper;
	
	@BeforeAll
	void beforeAll() {	// 1회성 전처리
		
		log.trace("beforeAll() invoked.");
		
		assert this.memberMapper != null;
//		assertNotNull(this.userService);
		log.info("\t+ this.userService: {}", this.memberMapper);
		
	} // beforeAll()
	
	@Test
	void contextLoads() {
		log.trace("contextLoads() invoked.");
	
	} // contextLoads()
	
////	@Disabled
//	@Test
//	@Order(1)
//	@DisplayName("memberJoin Test")
//	@Timeout(value=1, unit=TimeUnit.SECONDS)
//	void memberJoin() throws Exception {
//		MemberVO memberVO = new MemberVO();
//		
//		memberVO.setMEMBER_ID("TEST_SENGNA");
//		memberVO.setMEMBER_PW("TEST_SENGNA");
//		memberVO.setMEMBER_NAME("TEST_SENGNA");
//		memberVO.setMEMBER_MAIL("TEST_SENGNA");
//		memberVO.setMEMBER_HP(1055555555);
//		memberVO.setMEMBER_ADDR1("TEST_SENGNA");
//		memberVO.setMEMBER_ADDR2("TEST_SENGNA");
//		memberVO.setMEMBER_ZIPCODE(123456);
//		memberVO.set
//		memberVO.setGENDER("TEST_SENGNA");
//		
//		memberMapper.memberJoin(memberVO);
//		
//	} // memberJoin()
	
//@Disabled
@Test
@Order(1)
@DisplayName("memberJoin Test")
@Timeout(value=1, unit=TimeUnit.SECONDS)
void memberJoin() throws Exception {
	MemberVO memberVO = new MemberVO();
	
	memberVO.setMEMBER_ID("TEST_SENGNA3");
	memberVO.setMEMBER_PW("TEST_SENGNA3");
	memberVO.setMEMBER_NAME("TEST_SENGNA3");
	memberVO.setMEMBER_MAIL("TEST_SENGN3");
	memberVO.setMEMBER_HP("01055555555");
	memberVO.setMEMBER_ADDR1("TEST_SENGNA3");
	memberVO.setMEMBER_ADDR2("TEST_SENGNA3");
	memberVO.setMEMBER_ZIPCODE(1234567);
	
	memberMapper.memberJoin(memberVO);
	
	log.info("memberVO: {}", memberVO);
	
} // memberJoin()
	
	
} // end class
