package org.zerock.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/sample")
@Controller
public class SampleController {

	@GetMapping("doA")
	public String doA(Model model) {
		log.trace("doA() invoked.");
		
		// 예외 유발하여 postHandle 작동하는지 안하는지 보기!
//		Integer.parseInt("백");	// throw NumberFormatException
		
		model.addAttribute("serverTime", "/sample/doA");
		
		return "home";
	} // doA()
	
	
	@GetMapping("doB")
	public String doB(Model model) {
		log.trace("doB() invoked.");

		model.addAttribute("serverTime", "/sample/doA");
			
		return "home";
	
	} // doB()
	
		
	@GetMapping("doC")
	public String doC(Model model) {
		log.trace("doC() invoked.");

		model.addAttribute("serverTime", "/sample/doA");
				
		return "home";
	} // doC()
	
} // end class
