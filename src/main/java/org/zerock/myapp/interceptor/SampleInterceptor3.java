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

@Component

public class SampleInterceptor3 implements HandlerInterceptor {

	@Override
	public boolean preHandle(
		HttpServletRequest req, HttpServletResponse res, Object handler
	) throws Exception {
		
		log.trace("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡");
		log.trace("1. preHandle(req, res, {}) invoked.", handler);
		log.trace("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡");
	
		
		return true;
		
	} // preHandle()


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


	@Override
	public void afterCompletion(
		HttpServletRequest req, HttpServletResponse res, 
		Object handler, Exception e	
	) throws Exception {
		
		log.trace("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡");
		log.trace("3. afterCompletion(req, res, {}, e) invoked.", handler, e);
		log.trace("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡");
		
	} // afterCompletion()
	
} // end class
