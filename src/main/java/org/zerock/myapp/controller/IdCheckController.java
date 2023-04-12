package org.zerock.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.service.IdCheckService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@RequestMapping("/signup")
@Controller
public class IdCheckController {

	@Autowired
	private IdCheckService idCheckService;
	
	
	@PostMapping("/infoa")
	public @ResponseBody int idCheck(@RequestParam("id") String id) {
		log.trace("idCheck {} invoked. (중복확인)",id);
		
		int cntId= idCheckService.idCheck(id);
		
		log.trace("cntId : {} (중복확인 성공)" , cntId);
		
		return cntId;
		
	} // id check

	
} // end class
