package org.zerock.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@Component
// 인증(Authentication)을 전반적으로 수행하는 역할
public class AuthInterceptor implements HandlerInterceptor {

	// 가로챈 모든 Request URI에 대해서, 요청을 보낸 웹 브라우저가 현재 시점에 인증된
	// 상태인지 아닌지를 체크해서, 인증된 회원만이 접근할 수 있는 화면과
	// 그렇지 않은 비회원도 접근 가능한 화면 요청에 대한 접근제어(Access Control) 수행
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler
	) throws Exception {
		
		log.trace("preHandle(req, res, {}) invoked.", handler);
		
//		-----------------------------------------------------
				
		HttpSession session = request.getSession(false);
		
		if (session == null) {
			
			response.sendRedirect("/user/login"); // 세션 없으면 로그인창으로 밀기
			return false; // 요청을 뒤로 넘기지 않음!
			
		}	// if
		
//		-----------------------------------------------------
		
		// 세션(Session Scope 공유영역)에 미리 약속된 인증 공통 속성이 있는지 확인합니다.
		Object auth = session.getAttribute("__AUTH__");
		
		if(auth == null) {	// 인증 공통 속성이 없다면 => 로그인하지 않았으면!
			
			response.sendRedirect("/user/login");
			return false; // 요청을 뒤로 넘기지 않음!
			
		}	// if
		
		// 인증된 웹브라우저인 경우(= 로그인 하고 왔다! 이미 로그인 되어있는 상태)
		return true;
	
	} // preHandle()
	
} // end class

