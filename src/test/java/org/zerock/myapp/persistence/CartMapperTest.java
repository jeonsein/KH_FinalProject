package org.zerock.myapp.persistence;

import java.util.List;
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
import org.zerock.myapp.mapper.CartMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartMapperTest {
	
	@Setter(onMethod_=@Autowired)
	private CartMapper mapper; // CartMapper 타입이 빈이 등록
	 
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked");
	} // beforeAll
	
	
	@Test
	@Order(1)
	@DisplayName("contextloads")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void contextloads() {
		log.trace("contextloads() invoked");
		
		Objects.requireNonNull(mapper);
		log.info("\t+this.mapper:{}, type:{}", this.mapper, this.mapper.getClass().getName());
		
	} // contextloads
	
	@Test
	@Order(2)
	@DisplayName("테스트1: testaddCart")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void testaddCart() { //db에 memberid와 productno가 이미 존재해야함! 임시로 넣어줬음  
		log.trace("testaddCart() invoked");
		
		String member_id = "nicknamebyul"; // 회원 아이디
		Integer product_no = 1; // 상품번호
		Integer count = 1;  // 개수
		
		CartDTO cart = new CartDTO();
		cart.setMember_id(member_id);
		cart.setProduct_no(product_no);
		cart.setCount(count);
		
//		int result=0;
//		result = mapper.addCart(cart);

//		log.info("testaddCart: {}", result);
		
		int affectedLines = this.mapper.addCart(cart);
		
		log.info("\t+affectedLines:{}", affectedLines);
		
	} // testaddCart
	
	
	@Test
	@Order(3)
	@DisplayName("테스트2: testdeleteCart")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void testdeleteCart() { //
		log.trace("testdeleteCart() invoked");
		
		Integer no = 2;
		
		int affectedLines = this.mapper.deleteCart(no);
		
		log.info("\t+affectedLines:{}", affectedLines);
		
	} // testdeleteCart
	
	@Test
	@Order(4)
	@DisplayName("테스트3: testmodifyCount")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void testmodifyCount() { //
		log.trace("testmodifyCount() invoked");
		
		Integer no = 2; // 장바구니 안에서의 상품 번호(순서?)
		Integer count = 5; // 바꾸고 싶은 상품 수량 입력
		
		CartDTO cart = new CartDTO();
		cart.setNo(no);
		cart.setCount(count);
		
		int affectedLines = this.mapper.modifyCount(cart);
		
		log.info("\t+affectedLines:{}", affectedLines);
		
	} // testmodifyCount
	
	@Test
	@Order(5)
	@DisplayName("테스트4: testgetCart")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void testgetCart() { //
		log.trace("testgetCart() invoked");
		
		String member_id = "nicknamebyul";
		
		List<CartDTO> list = this.mapper.getCart(member_id);

		for(CartDTO cart: list) {
			log.trace(list);
			cart.getTotalPrice();
			log.info("getcart:{}", cart);
		} // for
		
	} // testgetCart
	
	@Test
	@Order(6)
	@DisplayName("테스트5: testcheckCart")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void testcheckCart() { //회원정보(memberid)와 상품정보(product_no) 넘겨서 해당하는 row있는지 확인해서 한번에 넘기
		log.trace("testcheckCart() invoked");
		
		String member_id = "nicknamebyul";
		Integer product_no = 1;
		
		CartDTO cart = new CartDTO();
		cart.setMember_id(member_id);
		cart.setProduct_no(product_no);
		
		CartDTO affectedlines = this.mapper.checkCart(cart);
		log.info("\t+affectedLines:{}", affectedlines);
		
	} // testcheckCart
	
	

}
