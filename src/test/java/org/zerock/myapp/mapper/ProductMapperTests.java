package org.zerock.myapp.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.StringTokenizer;
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
import org.zerock.myapp.domain.ApiRecipesRowVO;
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
	@DisplayName("testSelectDetail")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testSelectDetail() {
		log.trace("\t testSelectDetail() invoked");
	
		Integer pno = 1;
		ProductDTO dto = this.mapper.SelectDetail(pno);
		
		assertNotNull(dto);
		log.info("\t dto : {}", dto);
		
	} // testSelectDetail
	
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("getApi")
	@Timeout(value=20, unit=TimeUnit.SECONDS)
	void getApi() {
		log.trace("\t getApi() invoked");
	
		String title = "파인애플";
		List<ApiRecipesRowVO> apiVO = this.mapper.SelectApiRecipes(title);
		
		assertNotNull(apiVO);
		log.info("\t apiVO : {}", apiVO);
		
	} // getApi
	
	
//	@Disabled
	@Test
	@Order(4)
	@DisplayName("brandnameTest")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testBrandName() {
		log.trace("\t testBrandName() invoked");
		
		List<ProductVO> vo = this.mapper.SelectSearchBrand();
		assertNotNull(vo);
		
		log.info("\t >>>>>.. vo : {}", vo);
	} // testBrandName
	
	
//	@Disabled
	@Test
	@Order(5)
	@DisplayName("brandnameTestGet")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void brandnameTestGet() {
		log.trace("\t brandnameTestGet() invoked");
		
		Criteria cri = new Criteria();
		
		cri.setBrand("A1");
		
		int idx = cri.getBrand().indexOf(",");
		StringTokenizer stk = new StringTokenizer(cri.getBrand(),",");
		StringBuilder sb = new StringBuilder();
		while(stk.hasMoreTokens()) {
			sb.append("\'" + stk.nextToken()  + "\'" + ",");
		}
		String str = sb.substring(0, sb.length()-1);
		log.info(">>>>>>>>>>>>> fdfs : {}",str);
		
		cri.setBrand("brandname in ("+str+")");
//		cri.setWeight_info("weight between 0 and 50");
		cri.setCurrPage(1);
		cri.setAmount(12);
		
		List<ProductVO> vo = this.mapper.SelectSearchBrandGet(cri);
		
	} // brandnameTestGet
} // end class
