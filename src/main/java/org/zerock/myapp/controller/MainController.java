package org.zerock.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/main") // base uri
@Controller // 이 클래스는 컨트롤러임
public class MainController { // 홈페이지 기본기능 요청 관리
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String mainPageGET() { // 단순히 메인 페이지 입장
		log.trace("mainPage() invoked");
		
		return "main";
	} // mainPageGET

}
