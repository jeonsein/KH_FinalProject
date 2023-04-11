package org.zerock.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.service.EmailCheckService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@Controller
@RequestMapping("/signup")
public class EmailCheckController {
	
	@Setter(onMethod_={@Autowired})
	private EmailCheckService emailCheckService;
	
	@PostMapping("/infob")
	@ResponseBody
	public int emailCheck(@RequestParam("email") String email) {
		log.trace("emailCheck ({}) invoked 이메일 중복확인", email);
		
		int cntEmail = emailCheckService.emailCheck(email);	
		
		log.trace("cnt : {} 이메일 중복확인 성공", cntEmail);
		
		return cntEmail;
	} // emailCheck
	
} // end class
