package org.zerock.myapp.service;

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
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.domain.ProductVO;
import org.zerock.myapp.exception.ServiceException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductServiceTests {

	@Setter(onMethod_= { @Autowired })
	private ProductService service;	 // ProductService(interface) 주입
	
	@BeforeAll
	void beforeAll() {
		log.trace("\t beforeAll() invoked");
		
		assertNotNull(this.service);
		log.info("\t this.service : {}",this.service);
	} // beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("getListTest")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void getListTest() throws ServiceException{
		log.trace("\t getListTest() invoked");
		
		Criteria cri = new Criteria();
		cri.setCurrPage(1);
		cri.setAmount(12);
		
		List<ProductVO> list = this.service.getList(cri);
		
		assertNotNull(list);
		list.forEach(log::info);
		
	} // getListTest
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("getRecodeCount")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void getRecodeCount() throws ServiceException {
		log.trace("\t getRecodeCount() invoked");
		
		Integer tempNum = this.service.getRecodeCount();
		
		Objects.requireNonNull(tempNum);
		log.info("\t tempNum : {}", tempNum);
	} // getRecodeCount
	
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("getMenuOrder")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void getMenuOrder() throws ServiceException {
		log.trace("\t getMenuOrder() invoked");
		
		Criteria cri = new Criteria();
		cri.setCurrPage(1);
		cri.setAmount(12);
		List<ProductVO> list = this.service.getOrder(cri);
		
		assert list != null;
		list.forEach(log::info);
	} // getMenuOrder
	
	
//	@Disabled
	@Test
	@Order(4)
	@DisplayName("getProductDetail")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void getProductDetail() throws ServiceException {
		log.trace("\t getProductDetail() invoked");
		
		Integer pno = 10;
		ProductDTO dto = this.service.getProductDetail(pno);
		
		Objects.requireNonNull(dto);
		log.info("\t dto : {}", dto);
		
	} // getProductDetail
	
} // end class
