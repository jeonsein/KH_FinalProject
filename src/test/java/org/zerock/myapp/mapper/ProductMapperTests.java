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
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.domain.ProductVO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductMapperTests {

	@Setter(onMethod_= { @Autowired })
	private ProductMapper mapper;
	
	@BeforeAll
	void beforeAll() {
		log.trace("\t beforeAll() invoked");
		
		assertNotNull(this.mapper);
		log.info("\t this.mapper {}", this.mapper);
	} // beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("testGetList")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testGetList() {
		log.trace("\t testGetList() invoked");
		
		Criteria cri = new Criteria();
		cri.setAmount(12);
		cri.setCurrPage(1);
	
		List<ProductVO> list = this.mapper.SelectAllList(cri);
		
		assert list != null;
		list.forEach(log::info);
		
	} // testGetMapper
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("testGetMenuOrder")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testGetMenuOrder(Criteria cri) {
		log.trace("\t testGetMenuOrder() invoked");
		
		cri.setCurrPage(1);
		cri.setAmount(12);
		List<ProductVO> list = this.mapper.SelectOrder(cri);
		
		Objects.requireNonNull(list);
		list.forEach(log::info);
	} // testGEtMenuOrder
	
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("testSelectDetail")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testSelectDetail() {
		log.trace("\t testSelectDetail() invoked");
	
		Integer pno = 1;
		ProductDTO dto = this.mapper.SelectDetail(pno);
		
		assertNotNull(dto);
		log.info("\t dto : {}", dto);
		
	} // testSelectDetail
}
