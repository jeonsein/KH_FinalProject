package org.zerock.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.myapp.domain.UserVO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	// 전처리

		log.trace("=======================================");
		log.trace("preHandle(req, res, handler) invoked.");
		log.trace("=======================================");
		
		// Step.1 현재 요청을 보낸 웹브라우저에 대한 세션 획득
		HttpSession session = request.getSession();
		
		// Step.2 획득한 세션영역(Session Scope, 금고상자)에 "__AUTH__"이름으로,
		// UserVO 객체가 있으면 삭제!!
		Object auth = session.getAttribute("__AUTH__");
		log.info("\t+ auth: {}", auth);
		
		if(auth != null) {
			// 금고상자에서, 미리 약속된 인증 객체를 삭제
			session.removeAttribute("__AUTH__");	
			log.info("세션영역에서, 인증객체(__AUTH__) 삭제 완료.");
			
		} // if
		
		return true;
		
	} // preHandle()

	
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, 
			Object handler, ModelAndView modelAndView) throws Exception {
		log.trace("=======================================");
		log.trace("postHandle(request, response, handler, modelAndView) invoked.");
		log.trace("=======================================");
		
		log.info("\t+ 1. modelAndView: {}", modelAndView);
		
		// Step.1 모델에서 얻은 새로운 __AUTH__란 이름으로 저장된 UserVO객체 획득
		ModelMap modelMap = modelAndView.getModelMap();
		UserVO userVO = (UserVO)modelMap.get("__AUTH__");
		
		log.info("\t+ 2. userVO: {}", userVO);
		
		// Step.2 새로 획득한 __AUTH__(UserVO) 인증 객체를, 현재 웹 브라우저의 세션 영역
		//		  (금고상자)에 넣음!
		if(userVO != null) {
			
			// 세션이 없으면 새로 만들고, 있으면 재사용하기!
			HttpSession session = request.getSession();
			
			// Step.2-1 
			// 인증에 성공한 현재의 웹 브라우저의 새로운 인증객체를 세션 영역에 저장
			session.setAttribute("__AUTH__", userVO); // 인증 객체 저장 성공
			log.info("\t+ 3. 세션 영역에 새로운 인증 객체 저장 성공");
			
		} // if
		
		
	} // postHandle()

	
	
} // end class
