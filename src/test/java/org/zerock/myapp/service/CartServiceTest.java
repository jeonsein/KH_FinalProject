package org.zerock.myapp.service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
import org.zerock.myapp.domain.CartDTO;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.CartMapper;
import org.zerock.myapp.service.CartService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartServiceTest {
	
	@Setter(onMethod_=@Autowired)
	private CartService service;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked");
		
		Objects.requireNonNull(this.service);
		log.info("\t+this.mapper:{}, type:{}", this.service, this.service.getClass().getName());
	} // beforeAll
	
	@Test
	@Order(1)
	@DisplayName("contextloads")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void contextloads() {
		log.trace("contextloads() invoked");
		
	} // contextloads
	
	@Test
	@Order(2)
	@DisplayName("테스트1: testaddProductsInCart")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	public void testaddProductsInCart() throws ServiceException{
		log.trace("testaddProductsInCart() invoked");
		// 0 = 등록실패(CartServiceImpl) / 1 = 등록 성공 / 2 = 등록된 데이터 존재(CartServiceImpl) /5 = 로그인 필요 (cartcontroller)
		
		//1. db에 있는 값으로 테스트 --> "2"가 나와야 함
//		String member_id = "codud"; // 회원 아이디
//		Integer product_no = 1; // 상품번호
//		Integer count = 1;  // 개수
//		
//		CartDTO dto = new CartDTO();
//		dto.setMember_id(member_id);
//		dto.setProduct_no(product_no);
//		dto.setCount(count);
//		
//		Integer result = service.addProductsInCart(dto);
//		log.info("*****testaddProductsInCart:({})", result);
		
		//2. db에 없는 값을 넣어보기 -> 0이 나와야함
//		String member_id = "notyet"; //존재하지 않는 member_id
//		Integer product_no = 3;
//		Integer count = 3;
//		
//		CartDTO dto = new CartDTO();
//		dto.setMember_id(member_id);
//		dto.setProduct_no(product_no);
//		dto.setCount(count);
//		
//		Integer result = service.addProductsInCart(dto);
//		log.info("*****testaddProductsInCart:({})", result);
		
		//3. 존재하는 id이나 카트에는 아직 없는 -> 1
		String member_id = "a"; //존재하는 id
		Integer product_no = 1;
		Integer count = 1;
		
		CartDTO dto = new CartDTO();
		dto.setMember_id(member_id);
		dto.setProduct_no(product_no);
		dto.setCount(count);
		
		Integer result = service.addProductsInCart(dto);
		log.info("*****testaddProductsInCart:({})", result);
	} // testaddProductsInCart

}
