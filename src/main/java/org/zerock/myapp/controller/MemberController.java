package org.zerock.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.myapp.domain.MemberVO;
import org.zerock.myapp.service.MemberService;

import lombok.extern.log4j.Log4j2;

@Log4j2

@Controller
@RequestMapping("/signup")
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 회원가입페이지 이동
	@GetMapping("/form")
	public void joinGET() {
		log.info("회원가입 페이지로 이동했습니다.");
	} // joinGET()
	
	// 회원가입
	@PostMapping("/join")
	public String joinPOST(MemberVO memberVO) throws Exception {
		
		log.info("회원가입 /signup/join으로 이동했습니다.");
		
		// 회원가입 서비스 실행
		memberService.memberJoin(memberVO);
		
		log.info("join Service 성공!");
		
		return "redirect:/home";
		
	} // joinPOST()
	
} // end class
