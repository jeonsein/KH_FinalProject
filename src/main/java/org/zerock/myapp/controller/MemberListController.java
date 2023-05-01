package org.zerock.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.MemberDTO;
import org.zerock.myapp.domain.PageDTO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor

@Component

@Controller
@RequestMapping("/admin/*")
public class MemberListController {

	private MemberService service;
	
	
	// [별이] 메소드 추가

    /* 회원 목록 GET */
	@GetMapping("/member/list")
	public void list(Criteria cri, Model model) throws ControllerException {	// 게시판 전체 목록 조회 요청 처리 핸들러
		
		log.trace("list({}, {}) invoked.", cri, model);
		
		try {
			List<MemberDTO> list = this.service.getListPaging(cri);
			model.addAttribute("list", list);

			int totalAmount = this.service.getTotal();
			PageDTO pageDTO = new PageDTO(cri, totalAmount);
			model.addAttribute("pageMaker", pageDTO);
			
		} catch (Exception e) {
			throw new ControllerException(e);
		} // try-catch
		
	} // list()
	
	
	/* 회원 상세 조회 */
	@GetMapping("/member/get")
	public void get(@RequestParam("id") String id, Model model) throws ControllerException {
		// 매개변수 이름이 전송 파라미터와 어쩔수없이 달라야 한다면
		// 이 RequestParam으로 값을 달라고 할 전송 파라미터를 지정
		
		log.trace("get({}, {}) invoked.", id, model);
		
		try {
	         MemberDTO dto = this.service.get(id);
	         model.addAttribute("member", dto);
		} catch (Exception e) {
			throw new ControllerException(e);
		} // try-catch
		
		
	} // get()

	
} // end class
