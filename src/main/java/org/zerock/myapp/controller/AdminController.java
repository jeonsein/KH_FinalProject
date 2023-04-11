package org.zerock.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.myapp.exception.AException;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	/* 1. 관리자 페이지 이동 */
	
	@GetMapping("/main")
	public String adminMain() throws AException{
		log.trace("adminMain() invoked. (관리자 페이지 이동)");
		
		return "admin/main";
		
		// 어드민 수정 테스트입니당~
		// 다시수정할게용
		// 졸리당
		
	} // adminMain
}