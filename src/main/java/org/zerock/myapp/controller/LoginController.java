package org.zerock.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;



@Log4j2
@AllArgsConstructor

// 아래의 어노테이션은 "반드시" "Model 상자에 넣은 KEY"를 지정하면,
// 이 Key 이름으로 Session Scope에 공통 속성으로 넣어줍니다!
// session scope 조작하기!
//@SessionAttributes({"__AUTH__"})	// LoginInterceptor에서 처리
@RequestMapping("/user")
@Controller
public class LoginController {			// POJO
	
	private UserService service;

	
	@PostMapping("/loginPost")
	// command object으로 매개변수 설정하여 파라미터 수집
	public String loginPost(LoginDTO dto, RedirectAttributes rttrs, Model model) throws ControllerException {
		
		log.trace("loginPost({}, {}, {}) invoked.", dto, rttrs, model);
		
		// 로그인 성공시 약속된 인증 객체를 만들어서 Session Scope에 올려놓아야
		// auth-interceptor가 약속된 인증 객체를 찾을 수 있음
		try {
			// 영속성 계층 구현
			
			UserVO vo = this.service.login(dto);
			log.info("\t+ vo: {}", vo);
			
			if(vo != null) {	// if 인증 성공
				
				// 인증 성공 시 모델 상자에 담아서!
				model.addAttribute("__AUTH__", vo);
				
				return null;	// 메인화면
				
			} else {			// if 인증 실패
				
				// 인증 실패 시 임시 상자에 담아서!
				rttrs.addAttribute("result", "Login Failed");
				// redirect 방식으로 login 창으로 밀어줌
				return "redirect:/user/login";	// 인증 실패 결과와 함께 로그인 화면으로 돌아감
				
			} // if-else
			
		} catch (Exception e) {
			throw new ControllerException(e);
		} // try-catch
		
	} // loginPost()
	
//	@GetMapping("/logout")
//	public void logout(SessionStatus sessionStatus) {
//		
//		log.trace("logout() invoked.");
//		log.info("\t+ sessionStatus: {}", sessionStatus);
//		sessionStatus.setComplete();	// 현재의 웹브라우저에 대응되는 세션 객체 (금고상자) 파괴
//		
//	} // logout()
	
	// LogoutInterceptor가 로그아웃 요청(/user/logout)을 가로채서(preHandle),
	// 인터셉터에서 로그아웃 처리 완료(세션 객체를 파괴), 요청을 이 핸들러 메소드로 보내지 않음
	@GetMapping("/logout")
	public void dummyLogout() {
		log.trace("dummyLogout() invoked.");
	} // dummyLogout()
	
	// 부계정으로 되는지 연습!
	
} // end class
