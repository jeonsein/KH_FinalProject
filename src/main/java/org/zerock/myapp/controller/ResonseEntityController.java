//package org.zerock.myapp.controller;
//
//
//import java.util.Objects;
//
//import javax.inject.Inject;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity.BodyBuilder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.zerock.myapp.domain.SampleDTO;
//
//import lombok.NoArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//
//@Log4j2
//@NoArgsConstructor
//
//@RequestMapping("/reqentity")
//@RestController
//public class ResonseEntityController implements InitializingBean  {
//
//	//핵심: 스프링이 제공하는 제네릭 클래스인 ResponseEntity<T>의 용법에 대해 배우자
//	
//	@Inject
//	private DataSource dataSource;
//	
//	
//	@Override // 빈이 제대로 주입되었는지 확인하기 위해서 InitializingBean implements하고 오버라이딩 했음
//	public void afterPropertiesSet() throws Exception{ // 사전처리로 사용
//		log.trace("afterPropertiesSet invoked");
//		
//		Objects.requireNonNull(this.dataSource);
//		log.info("\t+this.datasource:{}", this.dataSource);
//	} // afterPropertiesSet
//	
//	
//	@GetMapping(
//			path = "/check", 
//			//아래 2개의 이름의 전송파라미터는 반드시 들어와야 한다는 제약 조건표시
//			params = {"height", "weight"},
//			produces = {MediaType.APPLICATION_JSON_VALUE}
//			) // 두개의 전송파라미터를 달라
//	public ResponseEntity<SampleDTO> check(Double height, Double weight) {
//		log.trace("check({}, {}) invoked", height, weight);
//		
//		SampleDTO dto = new SampleDTO();
//		dto.setMno(100);
////		dto.setFirstName("kim");
//		dto.setFirstName("대한");
////		dto.setLastName("cy");
//		dto.setLastName("민국");
//		
//		ResponseEntity<SampleDTO> response = null;
//		BodyBuilder bodyBuilder = null;
//		
//		//step1. HTTP response의 응답코드(HTTP status code) 설정
//		if(height < 100) { //키가 요청을 처리하는데에 적합하지 않다면..
//			bodyBuilder = ResponseEntity.status(HttpStatus.BAD_REQUEST); // **응답코드
//		}else { // 키가 요청을 처리하는데에 적합하다면
//			bodyBuilder = ResponseEntity.status(HttpStatus.OK);
//		} // if else
//		
//		log.info("\t+bodybuilder:{}", bodyBuilder);
//		
//		
//		//step2. HTTP response 의 헤더 설정
//		HttpHeaders headers = new HttpHeaders();
////		headers.add(newHeaderName, newHeaderValue); -> 사용방법!
//		headers.add("Content-Type", "applicaton/json; charset=utf8"); // json이 기본
////		headers.add("Content-Type", "applicaton/xml; charset=utf8");
//		
//		log.info("\t+headers:{}", headers);
//		
//		bodyBuilder.headers(headers); // 바디에 헤더 넣기 
//		
//		
//		//step3. HTTP response의 body 설정
//		response = bodyBuilder.<SampleDTO>body(dto); // **바디
//		log.info("\t+responseentity<SampleDTO>:{}", response);
//		
//		return response;
//		
//	} // check
//	
//	
//} // end class
