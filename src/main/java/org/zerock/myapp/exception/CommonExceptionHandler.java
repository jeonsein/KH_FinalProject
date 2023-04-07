package org.zerock.myapp.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ControllerAdvice
public class CommonExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		log.trace("handleException({}) invoked.", e.getClass().getName());
		
		model.addAttribute("__EXCEPTION__", e);
		
		// 하위 예외 객체가 모두 드러날 때까지 예외 타입과 메시지를 출력
		Throwable t = e;
		
		do {
			log.error("===============================================");
			log.error("Exception Type: {}", t.getClass().getName());
			log.error("Exception Message: {}", t.getMessage());
			
		} while ((t = t.getCause()) != null);	// 하위 예외를 모두 순회할 때까지! 
		
		return "errorPage";	// 예외응답화면생성 View 이름
	} // handleException
	
} // end class