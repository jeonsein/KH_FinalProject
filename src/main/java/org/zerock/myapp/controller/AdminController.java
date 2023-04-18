package org.zerock.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.NoticeDTO;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.exception.AException;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	private ProductService service;
	
	//채영 테스트
	
	
	/* 1. 관리자 페이지 이동 */
	
	@GetMapping("/main")
	public String adminMain() throws AException{
		log.trace("adminMain() invoked. (관리자 페이지 이동)");
		
		return "admin/main";
		
		// 어드민 수정 테스트입니당~
		// 다시수정할게용
		// 졸리당
		// 테스트입니당당당
		// 테스트예요 TT
		// TEST
		
	} // adminMain
	
	
	
	
//	=========================== 상품 ===========================
	
//	[별이] 메소드 추가
	@GetMapping("/product/register")
	public void register() {
		log.trace("register invoked. (관리자 페이지 상품 등록-GET)");
	}
	@PostMapping("/product/register")
	public String register(ProductDTO dto, RedirectAttributes rttrs) 
			throws ControllerException {
		
			log.trace("register({}, {}) invoked. (관리자 페이지 상품 등록-POST)", dto, rttrs);
		
			try {
				boolean success = this.service.register(dto);
				log.info("\t: success: {}", success);

				// 비지니스 요청 처리용 전송파라미터 전송처리
				rttrs.addAttribute("result", (success)? "success" : "failure"); 
				// KEY = 등록처리결과
				
				return "redirect:/admin/main"; // 실패했든 성공했든 여기로 이동
			} catch (Exception e) {
				throw new ControllerException(e);
			} // try-catch
		
	} // register()
	
	
}