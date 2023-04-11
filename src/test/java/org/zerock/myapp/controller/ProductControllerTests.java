package org.zerock.myapp.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import org.springframework.test.context.web.WebAppConfiguration;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.domain.ProductVO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.ProductService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/**/root-*.xml",
		"file:src/main/webapp/WEB-INF/**/servlet-*.xml"
})

@WebAppConfiguration

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTests {
	
	@Setter(onMethod_= { @Autowired})
	private ProductService service;
	
	@BeforeAll
	void beforeAll() {
		log.trace("\t beforeAll() invoked");
		
		assertNotNull(this.service);
		log.info("\t this.service : {}", this.service);
	} // beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("testGetList")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testGetList() throws ControllerException {
		log.info("\t testGetList() invoked");
		
		try {
			Criteria cri = new Criteria();
			cri.setAmount(12);
			cri.setCurrPage(1);
			
			List<ProductVO> list = this.service.getList(cri);
			list.forEach(log::info);
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
		
	} // testGetList
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("testGetRecodeCount")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testGetRecodeCount() throws  ControllerException{
		log.trace("\t testPage() invoked");
		
		try {
			Integer tempCount = this.service.getRecodeCount();
			log.info("\t tempCount : {}", tempCount);
		} catch (Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // testPage
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("testGetMenuOrder")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testGetMenuOrder(Criteria cri) throws  ControllerException{
		log.trace("\t testPage() invoked");
		
		try {
			List<ProductVO> list = this.service.getOrder(cri);
			list.forEach(log::info);
		} catch (Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // testGetMenuOrder
	
	

//	@Disabled
	@Test
	@Order(4)
	@DisplayName("testGetProductDetail")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testGetProductDetail() throws  ControllerException{
		log.trace("\t testGetProductDetail() invoked");
		
		try {
			Integer pno = 1;
			
			ProductDTO dto = this.service.getProductDetail(pno);
	
			log.info("\t dto : {}", dto);
		} catch (Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // testGetProductDetail
} // end class
