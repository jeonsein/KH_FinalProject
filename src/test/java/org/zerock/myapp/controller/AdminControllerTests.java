package org.zerock.myapp.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.service.ProductService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/**/spring/root-*.xml",
		"file:src/main/webapp/**/spring/**/servlet-*.xml"})
@WebAppConfiguration

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminControllerTests {
	
	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;
	private ProductService service;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll invoked. (전처리)");
	}
	
//	@Disable
	@Test
	@Order(1)
	@DisplayName("테스트 1 : contextLoads")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void contextLoads() {
		log.trace("contextLoads invoked. (테스트 실행 테스트)");
	}
	
	
	/* 상품 등록 */
//	@Disable
	@Test
	@Order(2)
	@DisplayName("테스트 2 : register")
	@Timeout(value=2, unit=TimeUnit.SECONDS)
	void testRegister() throws Exception {		
		log.trace("testRegister() invoked.");

		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/product/register");
			requestBuilder.param("category", "10300");
			requestBuilder.param("name", "혁구네 농장 스테비아 방울토마토");
			requestBuilder.param("price", "10000");
			requestBuilder.param("discount", "20");
			requestBuilder.param("discount_price", "8000");
			requestBuilder.param("weight","2kg");
			requestBuilder.param("origin", "국산");
			requestBuilder.param("stock", "10");
			requestBuilder.param("title", "토마토");
			requestBuilder.param("Product_no", "1");
			requestBuilder.param("main_image", "main_1");
			requestBuilder.param("sub_image1", "sub_1");
			requestBuilder.param("sub_image2", "sub_2");		
			requestBuilder.param("sub_image3", "sub_3");
			requestBuilder.param("sub_image4", "sub_4");
			requestBuilder.param("content", "신선한 망고향이 듬-뿍 스테비아 토마토! 헤어나올 수 없는 검증된 맛! 토마토에 설탕을 뿌린걸까? 착각할 정도의 달달함!");
			requestBuilder.param("content_image","content_image1");
		
		ModelAndView modelAndView 
		= mockMvc.perform(requestBuilder).andReturn().getModelAndView();

		log.info("\t+ viewName: {}, type: {}", 
				modelAndView.getViewName(), modelAndView.getClass().getName());
		
		
	} // testRegister
	
	
//	목업 건설사
//	@Disable
	@Test
	@Order(3)
	@DisplayName("테스트 3 : getList")
	@Timeout(value=60, unit=TimeUnit.SECONDS)
	void getList() throws Exception{
		log.trace("getList() invoked.");
	
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx); 
		//일단 ctx를 목업 어쩌꾸에 넣어주면 됨. 건설사 획득
		// MockMvc를 지어줄 "건설사Builder" 부터 획득
		MockMvc mockMvc = mockMvcBuilder.build();
		// 이게 브라우저 역할 하는거임
//		욫청을 만드는 핸들클래스가 따로 있음 이건 정적요청방식을 쓰고
		
		//BoardController의 /board/list, GET 핸들러 테스트
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/product/list");
		requestBuilder.param("currPage", "2");
		requestBuilder.param("amount", "10");
		
		// 상위타입에 넣음
		
		// 이제 가상의 MVC 환경에서, BoardController에 요청생성 및 전송
//		@Cleanup("clear")
		ModelAndView modelAndView = mockMvc.perform(requestBuilder).andReturn().getModelAndView();
		log.info("\t+ modelAndView : {}, type : {}", modelAndView.getViewName(), modelAndView.getClass().getName());
		
		
		
	} // getList
	
	
	/* 상품 상세 조회 */
//	@Disable
	@Test
	@Order(4)
	@DisplayName("테스트 4 : get")
	@Timeout(value=2, unit=TimeUnit.SECONDS)
	void get() throws Exception {		
		log.trace("testGet() invoked.");

		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		MockMvc mockMvc = mockMvcBuilder.build();
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/product/get");
		requestBuilder.param("no", "116");
		
		ModelAndView modelAndView 
		= mockMvc.perform(requestBuilder).andReturn().getModelAndView();

		log.info("\t+ viewName: {}, type: {}", 
				modelAndView.getViewName(), modelAndView.getClass().getName());
		
		
	} // get
	
	
//	@Disable
	@Test
	@Order(6)
	@DisplayName("테스트 6 :remove")
	@Timeout(value=60, unit=TimeUnit.SECONDS)
	void testRemove() throws Exception{
		log.trace("testRemove() invoked.");
	
		// MockMvc를 지어줄 "건설사Builder" 부터 획득
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx); 
		MockMvc mockMvc = mockMvcBuilder.build();
		
		//BoardController의 /board/list, GET 핸들러 테스트
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/product/remove");
		requestBuilder.param("no", "121"); // ... <- 가변인자
		
		// 컬렉션 아니어서 cleanup 안해도됨.
		// 이제 가상의 MVC 환경에서, BoardController에 요청생성 및 전송
		ModelAndView modelAndView = 
				mockMvc.
				 perform(requestBuilder).
				 andReturn().
				 getModelAndView();		
		log.info("\t+ modelAndView : {}, type : {}", modelAndView.getViewName(), modelAndView.getClass().getName());

	} // testRemove
	
	
	
	/* 상품 수정 */
//	@Disable
	@Test
	@Order(5)
	@DisplayName("테스트 5 : modify")
	@Timeout(value=60, unit=TimeUnit.SECONDS)
	void modify() throws Exception{
		log.trace("modify() invoked.");
		
		// MockMvc를 지어줄 "건설사Builder" 부터 획득
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx); 
		MockMvc mockMvc = mockMvcBuilder.build();
		
		//========================== STEP 1. 게시글을 상세 조회 ======================
		//BoardController의 /board/list, GET 핸들러 테스트
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/product/get");
		requestBuilder.param("no", "116"); // ... <- 가변인자
		
		// 컬렉션 아니어서 cleanup 안해도됨.
		// 이제 가상의 MVC 환경에서, BoardController에 요청생성 및 전송
		ModelAndView modelAndView = 
				mockMvc.
				 perform(requestBuilder).
				 andReturn().
				 getModelAndView();	
		
		log.info("\t+ viewName : {}, type : {}", modelAndView.getViewName(), modelAndView.getClass().getName());

		ModelMap model = modelAndView.getModelMap();
		log.info("\t+ model: {}, type : {}", model, model.getClass().getName());
		
		ProductDTO vo = (ProductDTO) model.getAttribute("product");
		assertNotNull(vo);
		
		log.info("\t+ vo: {}", vo);
		
		
		//========================== STEP2. 20 bno 게시글을 수정 ======================
		
		Integer no = vo.getNo();
		String name = vo.getName();
//		String location = vo.getLocation();
//		String tel = vo.getTel();
		
		requestBuilder = MockMvcRequestBuilders.post("/admin/product/modify");
		requestBuilder.param("no", no.toString());
		requestBuilder.param("category", "10300");
		requestBuilder.param("name", "셍뉘네 스테비아 방울토마토");
		requestBuilder.param("price", "10000");
		requestBuilder.param("discount", "20");
		requestBuilder.param("discount_price", "8000");
		requestBuilder.param("weight","2kg");
		requestBuilder.param("origin", "국산");
		requestBuilder.param("stock", "10");
		requestBuilder.param("Product_no", "1");
		requestBuilder.param("title", "토마토");
		requestBuilder.param("main_image", "main_1");
		requestBuilder.param("sub_image1", "sub_1");
		requestBuilder.param("sub_image2", "sub_2");		
		requestBuilder.param("sub_image3", "sub_3");
		requestBuilder.param("sub_image4", "sub_4");
		requestBuilder.param("content", "신선한 망고향이 듬-뿍 스테비아 토마토! 헤어나올 수 없는 검증된 맛! 토마토에 설탕을 뿌린걸까? 착각할 정도의 달달함!");
		requestBuilder.param("content_image","content_image1");
		
		modelAndView = 
				mockMvc.
				 perform(requestBuilder).
				 andReturn().
				 getModelAndView();	
		
		// 가상의 MVC 환경에서, BoardController 에 요청생성 및 전송
		log.info("\t+ viewName : {}, type : {}", modelAndView.getViewName(), modelAndView.getClass().getName());
		
	} // testList
	
	
} // end class
