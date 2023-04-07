package org.zerock.myapp.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor
// interceptor도 자바 beans로 등록되어야 하기 때문에, 자바빈즈 규약을 지키기 위해서
// @NoArgsConstructor!!


@Component
// HandlerInterceptor에 기본 메소드가 구현되어 있어서
// 필요 메소드만 Override 하면 됨!
public class SampleInterceptor implements HandlerInterceptor {

	// HTTP request가 해당 Controller의 Handler method에게 위임(전달)되기 직전에,
	// 자동으로 Call-back
	@Override
	public boolean preHandle(		// 전처리(Pre-processing)
		HttpServletRequest req, HttpServletResponse res, Object handler
	) throws Exception {
		
		log.trace("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡");
		log.trace("1. preHandle(req, res, {}) invoked.", handler);
		log.trace("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡");
	
		// ================ 핸들러 메소드의 타입 자세히 보기!! ================
		
//		HandlerMethod controllerHandler = (HandlerMethod) handler;
//		
//		Object controller = controllerHandler.getBean();
//		Method method = controllerHandler.getMethod();
//		
//		log.trace("\t+ 1. controller: {}, type: {}", controller, controller.getClass().getName());
//		log.trace("\t+ 2. method: {}", method);
		
		
		// ======================= 인증 체크(Authentication) ======================= 
		
//		HttpSession session = req.getSession(false);
//		if(session == null) { // 세션 자체가 없으니, 인증 정보도 없음 => 로그인 창으로 밀어버림
//			
//			res.sendRedirect("/login"); // 로그인 창으로 밀어버림
//			return false;
//		
//		} else {			// 세션은 있는데, Session Scope 공우영역에 미리 약속된 인증 데이터가 없을 때
//			
//			String authKey = "__AUTH__";
//			Object auth = session.getAttribute(authKey);
//			
//			if(auth == null) {	// 미인증 상태임 => 로그인 창으로 밀어버림
//				res.sendRedirect("/login");
//		
//				return false;
//		
//			} // inner-if
//		
//		} // if-else
		
		// ======================= 접근 제한(Authorization) =======================
		
//		String requestURL = req.getRequestURL().toString();
//		
//		HttpSession session = req.getSession(false);
//		String sessionId = (session != null)? session.getId() : "No Session";
//		
//		String clientAddress = req.getRemoteAddr();
//		
//		if("192.168.10.168".equals(clientAddress)) {	// 블랙리스트 IP 주소에 해당한다면..
//			res.setCharacterEncoding("utf8");
//			res.setContentType("text/html; charset=utf8");
//			
//			@Cleanup
//			PrintWriter out = res.getWriter();
//			
//			out.println("<h2>Access Denied &#128581;&#128581; </h2><hr> ");
//			out.println("<p>1. requestURL: " + requestURL + "</p>");
//			out.println("<p>2. sessonId: " + sessionId + "</p>");
//			out.println("<p>3. clientAddress: " + clientAddress + "</p>");
//			
//			out.flush();
//			
//			return false;
//			
//		} // if
		
		// return 값에 의해서, interceptor chain 또는 컨트롤러의 핸들러에게
		// 가로챈 요청을 넘기게 됨!
//		return true;		// 그 다음으로 넘김
//		return false;		// 그 다음으로 넘기지 않고, 여기서 응답으로 보내서 끝냄
		
		return true; // 기본값은 true로 그 다음으로 요청을 넘김(위임)
		
	} // preHandle()

	
	// Controller의 Handler method가 위임받은 HTTP request를 처리 완료하여
	// Model과 View 이름을 반환한 직후에(그리고 아직까지 View는 호출되기 전에)
	// 자동으로 Call-back (*주의: View가 호출되기 전!)
	// 주의 : 컨트롤러의 핸들러 메소드에서 예외가 발생하면, Call-back되지 않음!
	@Override
	public void postHandle(
		HttpServletRequest req, HttpServletResponse res, 
		Object handler, ModelAndView modelAndView
	) throws Exception {
		
		log.trace("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡");
		log.trace("2. postHandle(req, res, {}, {}) invoked.", handler, modelAndView);
		log.trace("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡");
		
		log.info("\t+ handler type:{}", handler.getClass().getName());
		
	} // postHandle()

	
	// View(JSP)까지 호출 완료되어, HTTP response가 전송완료된 직후에 Call-back
	// (주의): 컨트롤러의 핸들러 메소드에서 예외가 발생하든/안하든 무조건 Call-back
	@Override
	public void afterCompletion(
		HttpServletRequest req, HttpServletResponse res, 
		Object handler, Exception e	
	) throws Exception {
		
		log.trace("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡");
		log.trace("3. afterCompletion(req, res, {}, e) invoked.", handler, e);
		// exception 객체를 log.trace의 {} 내부에 찍을 수 없고, 
		// 넣는 것 만으로도 print-stack-trace 됨!!
		log.trace("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡");
		
	} // afterCompletion()

	
} // end class
