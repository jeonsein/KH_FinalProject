package org.zerock.myapp.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
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
import org.zerock.myapp.domain.OrderDTO;
import org.zerock.myapp.domain.OrderItemDTO;
import org.zerock.myapp.domain.OrderPageItemDTO;
import org.zerock.myapp.domain.ProductDTO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderMapperTests {
	
	@Setter(onMethod_= {@Autowired})
	private OrderMapper orderMapper;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked");
		
		assertNotNull(this.orderMapper);
		log.info("\t+this.mapper:{}, type:{}", this.orderMapper);
	} // beforeAll
	
	
	//@Disabled
	@Test
	@Order(1)
	@DisplayName("테스트1: TestGetProductsInfo")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void TestGetProductsInfo() {
	    Integer no = 10; // 테스트용 상품 ID
	    OrderPageItemDTO product = orderMapper.getProductsInfo(no);
	    assertNotNull(product);
	    assertEquals(no, product.getNo());
	    // 예를 들어, product.getName(), product.getPrice() 등을 확인하는 코드를 작성.

	} // TestGetProductsInfo
	
	//@Disabled
	@Test
	@Order(2)
	@DisplayName(" test: TestGetOrderInfoTest()")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void TestGetOrderInfo() {
		OrderItemDTO orderInfo = orderMapper.getOrderInfo(10);  	// 주문 상품 정보 담는 mapper(주문처리) 
																	// 타입을 하나의 주문상품을 담는 OrderItemDTO로 줌
		log.trace(" orderInfo : {} " + orderInfo);
	} // TestGetOrderInfoTest()
	
	//@Disabled
	@Test
	@Order(3)
	@DisplayName(" test: TestEnrollOrder()")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void TestEnrollOrder() {										// MYMG_ORDER 테이블에 주문 등록 테이블
		
		OrderDTO ord = new OrderDTO();								// 여러개의 주문을 받을 수 있으니 OrderDTO로 선언
		List<OrderItemDTO> orders = new ArrayList();
		
		OrderItemDTO order1 = new OrderItemDTO();					// 하나의 상품을 담음
		
		order1.setProduct_no(81);
		order1.setCount(4);
		order1.setPrice(100);
		order1.setDiscount(10);
		order1.initSaleTotal();
		
		ord.setOrders(orders);										// 상품을 OrderDTO(상품 여러개)에 넣음
		
//		ord.setNo(1);				// 주문번호			
		ord.setReceiver_name("대림동불주먹");	// 주문받는사람				// MYMG_ORDER 테이블에 넣어야하니까 필드명을 테이블의 컬럼명과 맞춰야 에러가 안남
		ord.setMember_id("chandoll");// 주문자
		ord.setReceiver_address1(2023);
		ord.setReceiver_address2("서울 특별시 영등포구 대림동");
		ord.setReceiver_address3("지하철 10번출구");
		ord.setReceiver_tel(12345678);
		ord.setOrderState("배송준비");
		ord.getOrderPriceInfo();
		
		orderMapper.enrollOrder(ord);
	} // TestGetOrderInfoTest()
	
	//@Disabled
	@Test
	@Order(4)
	@DisplayName(" test: TestEnrollOrderItemTest()")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void TestEnrollOrderItemTest() {			// ORDER_LIST 테이블에 주문 상품 등록 테이블
		
		OrderItemDTO oid = new OrderItemDTO();
		
//		oid.setNo(1);
		oid.setOrder_no(1);
		oid.setProduct_no(21);
		oid.setCount(1);
		oid.setPrice(100);
		oid.setDiscount(10);
		
		oid.initSaleTotal();
		
		orderMapper.enrollOrderItem(oid);
		
	} // TestGetOrderInfoTest()
	
	//@Disabled
	@Test
	@Order(5)
	@DisplayName(" test: TestdeductStock()")
	@Timeout(value = 1, unit=TimeUnit.MINUTES)
	void TestdeductStock() {				// 상품 재고 변경
		
		ProductDTO product = new ProductDTO();
		
		product.setNo(10);
		product.setStock(10);
		
		orderMapper.deductStock(product);
		
	} // TestdeductStock() 
	
} // end class
