package org.zerock.myapp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
import org.zerock.myapp.domain.ApiRecipesRowVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.domain.ProductVO;
import org.zerock.myapp.exception.ServiceException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.Cleanup;
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
	
//	@Disabled
	@Test
	@Order(5)
	@DisplayName("apiTest")
	@Timeout(value=30, unit=TimeUnit.SECONDS)
	void insertApiRicipes() throws ServiceException {
		log.trace("insertApiRicipes() invoked");
		
		try {
			String serviceKey = "4dd187395c074624be3e";
			String endPoint = "http://openapi.foodsafetykorea.go.kr/api";
		
			String queryString = String.format("/%s/%s/%s/%s/%s", 
					URLEncoder.encode(serviceKey, "UTF-8"),
					URLEncoder.encode("COOKRCP01","UTF-8"), 
					URLEncoder.encode("JSON","UTF-8"), 
					URLEncoder.encode("1", "UTF-8"), 
					URLEncoder.encode("2", "UTF-8")
					);
			log.info("\t 0. queryString : {}", queryString);
			
			URL url = new URL(endPoint + queryString);
			log.info("\t 1. url : {}", url);

			@Cleanup("disconnect")
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
			
			Objects.requireNonNull(conn);
			
			conn.setConnectTimeout(1000);  
			conn.setUseCaches(false);  
			conn.setDoInput(true);    
			conn.setDoOutput(false);  
			conn.setRequestMethod("GET");
			conn.setReadTimeout(60000);  
										
			conn.connect();			
			log.info("\t 2. conn : {} ", conn);
			log.info("\t 3. type : {}", conn.getClass().getName());
			
			int statusCode = conn.getResponseCode(); 
			String responseMessage = conn.getResponseMessage();
					
			log.info("\t 4. statusCode : {}",statusCode);
			log.info("\t 5. responseMessage : {}",responseMessage);
					
			String tempLine = null;
			if(statusCode == 200) { 
				@Cleanup
				InputStream is = conn.getInputStream(); 
						
				Charset charset = StandardCharsets.UTF_8; 
						
				@Cleanup
				BufferedReader br = new BufferedReader(new InputStreamReader(is, charset)); 
						
				String line = null;
				while((line = br.readLine()) != null ) {
//					log.info(">>>>line : {}", line);
					
					tempLine = line;
				} // while		
			} // if
			
			// =================== 여기까지 공공데이터를 (JSON 방식으로) 가져온다 ==========================


			// ========  JSON 가져온 데이터를 Gson을 사용하여 객체로 변환 =============
			Gson gson = new Gson();  
//			JsonToXml jtx= gson.fromJson(tempLine, JsonToXml.class); 
			
//			Objects.requireNonNull(jtx);
//			log.info("\t jTest : {}", jtx);
			
			// =========== xml 파일을 JSON 으로 변환 ===================================
//			String tempXml = jtx.getXml_data();  // getXml_data을 가져온다
			
//			JSONObject json = XML.toJSONObject(tempXml);
//	        String jsonStr = json.toString().toLowerCase();
	       
//	        Objects.requireNonNull(jsonStr);
//	        log.info("\t jsonStr : {}", jsonStr);
	        
	        
	        // =========== JSON 파일을 Jackson 을 사용하여 객체로 변환 =================
			ObjectMapper mapper = new ObjectMapper();
//			JsonDTO jDTO = mapper.readValue(jsonStr, JsonDTO.class);
			
//			Objects.requireNonNull(jDTO);
//			log.info("\t jDTO : {}", jDTO);
//
//			log.info("\t count : {}", jDTO.getCookrcp01().getTotal_count());
//				
//			for(int i=0; i<jDTO.getCookrcp01().getRow().length; i++) {
//				Row row = jDTO.getCookrcp01().getRow()[i];
//				row.setId(row.getId());
//				row.setRcp_seq(row.getRcp_seq());
//				row.setRcp_nm(row.getRcp_nm());
//				row.setRcp_way2(row.getRcp_way2());
//				row.setRcp_pat2(row.getRcp_pat2());
//				row.setInfo_wgt(row.getInfo_wgt());
//				row.setInfo_eng(row.getInfo_eng());
//				row.setInfo_car(row.getInfo_car());
//				row.setInfo_pro(row.getInfo_pro());
//				row.setInfo_fat(row.getInfo_fat());
//				row.setInfo_na(row.getInfo_na());
//				row.setHash_tag(row.getHash_tag());
//				row.setAtt_file_no_main(row.getAtt_file_no_main()); 
//				row.setAtt_file_no_mk(row.getAtt_file_no_mk());
//			 	row.setRcp_parts_dtls(row.getRcp_parts_dtls());
//				row.setManual01(row.getManual01());
//				row.setManual_img01(row.getManual_img01());
//				row.setManual02(row.getManual02());
//				row.setManual_img02(row.getManual_img02());
//				row.setManual03(row.getManual03());
//				row.setManual_img03(row.getManual_img03());
//				row.setManual04(row.getManual04());
//				row.setManual_img04(row.getManual_img04());
//				row.setManual05(row.getManual05());
//				row.setManual_img05(row.getManual_img05());
//				row.setManual06(row.getManual06());
//				row.setManual_img06(row.getManual_img06());
//				row.setManual07(row.getManual07());
//				row.setManual_img07(row.getManual_img07());
//				row.setManual08(row.getManual08());
//				row.setManual_img08(row.getManual_img08());
//				row.setManual09(row.getManual09());
//				row.setManual_img09(row.getManual_img09());
//				row.setManual10(row.getManual10());
//				row.setManual_img10(row.getManual_img10());
//				row.setManual11(row.getManual11());
//				row.setManual_img11(row.getManual_img11());
//				row.setManual12(row.getManual12());
//				row.setManual_img12(row.getManual_img12());
//				row.setManual13(row.getManual13());
//				row.setManual_img13(row.getManual_img13());
//				row.setManual14(row.getManual14());
//				row.setManual_img14(row.getManual_img14());
//				row.setManual15(row.getManual15());
//				row.setManual_img15(row.getManual_img15());
//				row.setManual16(row.getManual16());
//				row.setManual_img16(row.getManual_img16());
//				row.setManual17(row.getManual17());
//				row.setManual_img17(row.getManual_img17());
//				row.setManual18(row.getManual18());
//				row.setManual_img18(row.getManual_img18());
//				row.setManual19(row.getManual19());
//				row.setManual_img19(row.getManual_img19());
//				row.setManual20(row.getManual20());
//				row.setManual_img20(row.getManual_img20());
//				row.setRcp_na_tip(row.getRcp_na_tip());
//				
////				boolean t1 = this.service.insertApiRicipes(row);
//				
//			} // for
			
		} catch (Exception e) {
			throw new ServiceException(e);
		} // try-catch	
		
	} // insertApiRicipes
	
	
//	@Disabled
	@Test
	@Order(6)
	@DisplayName("getApi")
	@Timeout(value=30, unit=TimeUnit.SECONDS)
	void getApi() throws ServiceException {
		log.trace("\t apiTest() invoekd");
		
		String title = "파인애플";
		
		List<ApiRecipesRowVO> vo = this.service.getRecipes(title);
		
		assertNotNull(vo);
		log.info("\t vo : {}", vo);
	} // apiTest
	
	
//	@Disabled
	@Test
	@Order(7)
	@DisplayName("getSearchBrand")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void getSearchBrand() throws ServiceException {
		log.info("\t getSearchBrand() invoked");
		
		List<ProductVO> vo = this.service.getSearchBrandName();
		assert vo != null;
		
		log.info("\t vo : {}", vo);
	} // getSearchBrand
	
	
	
//	@Disabled
	@Test
	@Order(8)
	@DisplayName("getSelectSearchBrand")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void getSelectSearchBrand() throws ServiceException {
		log.info("\t getSelectSearchBrand() invoked");
		
		Criteria cri = new Criteria();
		cri.setBrand("A1");
		cri.setCurrPage(1);
		cri.setAmount(12);
		
		List<ProductVO> vo = this.service.getSelectSearchBrandName(cri);
		assert vo != null;
		
		log.info("\t vo : {}", vo);
	} // getSelectSearchBrand
	
	
	
} // end class
