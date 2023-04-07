package org.zerock.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor // 빈으로 등록되기 위해 매개변수 없는 기본 생성자

@RestController
public class PathVariableController {
	
	//핸들러 메소드에 매핑을 두개 이상하면 ?? 
	@PostMapping( // 중괄호 씌운 부분을 우리가 빼서 쓸 수 있음!!!
			path = "/product/{category}/{productionId}",
			produces = "application/json"
			)
	@GetMapping( // 중괄호 씌운 부분을 우리가 빼서 쓸 수 있음!!!
			path = "/product/{category}/{productionId}",
			produces = "application/json"
			)
	public String[] getPathVariables( // 핸들러 메소드
			@PathVariable("category") String category, 
			@PathVariable("productionId") Integer productionId
			) {
		log.trace("getPathVariables({}, {}) invoked", category, productionId );
	
		return new String[] {"Category: " + category, "Producton ID: "+productionId};
	} // getPathVariables

} // end class
