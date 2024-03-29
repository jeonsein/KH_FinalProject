package org.zerock.myapp.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import org.zerock.myapp.domain.CartVO;
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
public class CartMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private CartMapper mapper; // CartMapper 타입이 빈이 등록
	 
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked");
		
		Objects.requireNonNull(this.mapper);
		log.info("\t+this.mapper:{}, type:{}", this.mapper, this.mapper.getClass().getName());
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
	@DisplayName("테스트1: testaddCart")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void testaddCart() { //db에 memberid와 productno가 이미 존재해야함! 임시로 넣어줬음  
		log.trace("testaddCart() invoked");
		
		String member_id = "codud123"; // 회원 아이디
		Integer product_No = 147; // 상품번호
		Integer count = 2;  // 개수
		
		CartDTO cart = new CartDTO();
		cart.setMember_id(member_id);
		cart.setProduct_No(product_No);
		cart.setCount(count);
		
//		int result=0;
//		result = mapper.addCart(cart);

//		log.info("testaddCart: {}", result);
		
		int affectedLines = 0;
		
		try {
			affectedLines = this.mapper.addCart(cart);
			log.info("\t+affectedLines:{}", affectedLines);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 추가에 성공하면 1을 반환, 실패하면 0을 반환

	} // testaddCart
	
	
	@Test
	@Order(3)
	@DisplayName("테스트2: testdeleteCart")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void testdeleteCart() { //
		log.trace("testdeleteCart() invoked");
		
		Integer no = 46;
		
		int affectedLines = this.mapper.deleteCart(no);
		
		log.info("\t+affectedLines:{}", affectedLines);
		
	} // testdeleteCart
	
	@Test
	@Order(4)
	@DisplayName("테스트3: testmodifyCount")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void testmodifyCount() { //
		log.trace("testmodifyCount() invoked");
		
		Integer no = 2; // 장바구니 안에서의 상품 번호(순서)
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

		String member_id = "codud";
		
		List<CartDTO> list = this.mapper.getCart(member_id);
//		List<CartVO> list = this.mapper.getCart(member_id);
		assertNotNull(list);
		
		list.forEach(log::info);
		
		
//		List<CartDTO> list = this.mapper.getCart(member_id);
//
//		for(CartDTO cart: list) {
//			log.trace(list);
//			cart.getTotalPrice();
//			log.info("getcart:{}", cart);
//		} // for
		
	} // testgetCart
	
	@Test
	@Order(6)
	@DisplayName("테스트5: testcheckCart")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void testcheckCart() { //회원정보(memberid)와 상품정보(product_no) 넘겨서 해당하는 row있는지 확인해서 한번에 넘기
		log.trace("testcheckCart() invoked");
		
		String member_id = "nicknamebyul";
		Integer product_No = 1;
		
		CartDTO cart = new CartDTO();
		cart.setMember_id(member_id);
		cart.setProduct_No(product_No);
		
		CartDTO affectedlines = this.mapper.checkCart(cart);
		log.info("\t+affectedLines:{}", affectedlines);
		
	} // testcheckCart

	/* 장바구니 제거(주문 처리) */ //찬돌
 	//Disabled
	@Test
	@Order(7)
	@DisplayName("테스트5: deleteOrderCart")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	public void deleteOrderCart() {
		String member_id = "chandoll";
		Integer product_No = 81;
		
		CartDTO dto = new CartDTO();
		dto.setMember_id(member_id);
		dto.setProduct_No(product_No);
		
		mapper.deleteOrderCart(dto);
		
	}
}
