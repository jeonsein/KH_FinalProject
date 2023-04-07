//package org.zerock.myapp.controller;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Hashtable;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.sql.DataSource;
//
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.zerock.myapp.domain.SampleDTO;
//import org.zerock.myapp.domain.Ticket;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//
//@Log4j2
////@NoArgsConstructor
//@AllArgsConstructor // 필드인 dataSource를 주입하기 위해, 생성자를 이용한 자동주입
//
//@RequestMapping("/sample")
////@Controller // 그냥 컨트롤러가 아니라
//@RestController("sampleController") // 순수한 데이터를 반환하는 레스트 컨트롤러임을 알려주는 어노테이션
//public class StringXMLJSONController {
//
////	@Setter(onMethod_=@Autowired) // 스프링 자동주입 
//	private DataSource dataSource; // 주입받을 필드 
//	
//	@GetMapping(
//			path = "/getString", 
//			//이 핸들러 메소드가 반환하는 데이터의 content type지정하는 속성 
//			produces = {
////			MediaType.TEXT_PLAIN_VALUE // 한글깨짐
//			MediaType.TEXT_PLAIN_VALUE+ "; charset=UTF-8"   // 우리가 주는 문자열이 어떤 컨텐츠인지, 어떠한 문서인지 타입을 적는 것
//			//우리가 주는 문자열은 평문이기 때문에 TEXT_PLAIN_VALUE
////			"text/plain; charset=utf8" -> 이렇게 써주기만 해도 되긴 함
//	})
//	public String getString() { // 한개 이상의 다양한 컨텐츠를 생산하면 produces 에 알려줘야함
//		log.trace("getString() invoked");
//		
//		return "안녕하세요"; // 순수한 데이터로 문자열 반환해보기!!
//		
//	} // getstring
//	
////	@GetMapping("/getSample") // produces 속성으로, content type을 기재 안하면 => xml로 변환
////	@GetMapping(path = "/getSample",
////			produces = MediaType.APPLICATION_JSON_VALUE // JSON으로 변환, utf8없어도 안 깨짐
////			produces = MediaType.APPLICATION_JSON_UTF8_VALUE // JSON
////			produces = MediaType.APPLICATION_XML_VALUE // XML로 변환해달라, 한글 안깨짐! 
////			produces = {
//					//** xml, json 타입을 모두 지정하면 순서와 상관없이 무조건 xml로 변환!!
////					MediaType.APPLICATION_JSON_VALUE,
////					MediaType.APPLICATION_XML_VALUE, // 두 개가 동시에 있으면 xml 이 우선!!
////			}
////			)
//	public SampleDTO getSample() {
//		log.trace("sampledto invoked");
//		
//		SampleDTO dto = new SampleDTO();
//		dto.setMno(100);
//		dto.setFirstName("채영");
//		dto.setLastName("KIM");
//		
//		log.info("\t+ dto:{}", dto);
//		
//		return dto;
//	}
//	
//	@GetMapping(path = "/getSampleByJSON", produces = "application/json")
//	public SampleDTO getSampleByJSON() {
//		log.trace("getSampleByJSON invoked");
//		
//		SampleDTO dto = new SampleDTO();
//		dto.setMno(100);
//		dto.setFirstName("채영");
//		dto.setLastName("KIM");
//		
//		log.info("\t+ dto:{}", dto);
//		
//		return dto;
//	} // getSampleByJSON
//	
//	@GetMapping(path = "/getSampleByXML", produces = "application/xml")
//	public SampleDTO getSampleByXML() {
//		log.trace("sampledto invoked");
//		
//		SampleDTO dto = new SampleDTO();
//		dto.setMno(100);
//		dto.setFirstName("채영");
//		dto.setLastName("KIM");
//		
//		log.info("\t+ dto:{}", dto);
//		
//		return dto;
//	} // getSampleByXML
//	
//	@GetMapping(
//			path = "/getSampleList", 
//			produces = "application/json"
//			)
//	public List<SampleDTO> getSampleList() {
//		log.trace("getSampleList invoked");
//		
//		List<SampleDTO> list = new ArrayList<>();
//
//		for(int i=0; i<10; i++) {
//			SampleDTO dto = new SampleDTO();
//			dto.setMno(i);
//			dto.setFirstName("FIRST_NAME_" + i);
//			dto.setLastName("LAST_NAME_" + i);
//			
//			list.add(dto);
//			
//		} // for
//		
//		log.info("\t+ dto:{}", list);
//		
//		return list;
//	} // getSampleList
//	
//	@GetMapping(
//			path = "/getSampleMap", 
//			produces = "application/json"
//			)
//	public Map<String, SampleDTO> getSampleMap() { // map -> key 는 string, value는 sampledto
//		log.trace("getSampleMap invoked");
//		
//		Map<String, SampleDTO> map = new Hashtable<>();
//
//		for(int i=0; i<10; i++) {
//			SampleDTO dto = new SampleDTO();
//			dto.setMno(i);
//			dto.setFirstName("FIRST_NAME_" + i);
//			dto.setLastName("LAST_NAME_" + i);
//			
//			map.put("SAMPLE_"+i, dto);
//			
//		} // for
//		
//		log.info("\t+ dto:{}", map);
//		
//		return map;
//	} // getSampleMap
//	
//	
//	@GetMapping(
//			path = "/getSampleSet", 
//			produces = "application/json"
//			)
//	public Set<SampleDTO> getSampleSet() { 
//		log.trace("getSampleSet invoked");
//		
//		Set<SampleDTO> set = new HashSet<>();
//
//		for(int i=0; i<10; i++) {
//			SampleDTO dto = new SampleDTO();
//			dto.setMno(i);
//			dto.setFirstName("FIRST_NAME_" + i);
//			dto.setLastName("LAST_NAME_" + i);
//			
//			set.add(dto);
//			
//		} // for
//		
//		log.info("\t+ dto:{}", set);
//		
//		return set;
//	} // getSampleSet
//	
//	
//	@GetMapping(
//			path = "/getSampleArray", 
//			produces = "application/json"
//			)
//	public SampleDTO[] getSampleArray() { 
//		log.trace("getSampleArray invoked");
//		
//		SampleDTO[] arr = { null, null, null, null, null};
//
//		for(int i=0; i<5; i++) {
//			SampleDTO dto = new SampleDTO();
//			dto.setMno(i);
//			dto.setFirstName("FIRST_NAME_" + i);
//			dto.setLastName("LAST_NAME_" + i);
//			
//			arr[i]= dto;
//			
//		} // for
//		
//		log.info("\t+ arr:{}", Arrays.toString(arr));
//		
//		return arr;
//	} // getSampleArray
//	
//
//	@GetMapping(
//			path = "/getSampleTicket", 
//			produces = "application/json"
//			)
//	public Ticket getSampleTicket() { 
//		log.trace("getSampleTicket invoked");
//		
//		Ticket ticket = new Ticket();
//		ticket.setTno(1000);
//		ticket.setGrade("A");
//		
//		SampleDTO dto = new SampleDTO();
//		dto.setMno(3);
//		dto.setFirstName("cy");
//		dto.setLastName("kim");
//		
////		ticket.setOwner(dto);
//		log.info("\t+ ticket:{}", ticket);
//		
//		return ticket;
//	} // getSampleTicket
//	
//	
//} // end class
