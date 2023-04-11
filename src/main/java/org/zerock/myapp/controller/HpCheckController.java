package org.zerock.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.service.HpCheckService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/signup")

@Log4j2
@NoArgsConstructor
public class HpCheckController {

	@Setter(onMethod_ = {@Autowired})
	HpCheckService hpCheckService;
	
	@PostMapping("/infoc")
	@ResponseBody
	public int hpCheck(@RequestParam("tel") String tel) {
			log.trace("tel invoked 핸드폰 중복확인", tel);
		
		int cntTel = hpCheckService.hpCheck(tel);
			
		log.trace("tel invoked 핸드폰 중복확인ㅇㅇㅇ", tel);
		
		return cntTel;
	}
	
} // end class
