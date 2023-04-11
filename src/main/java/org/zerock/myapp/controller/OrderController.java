package org.zerock.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.myapp.domain.OrderPageDTO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/order")
@Controller
public class OrderController {
	
//	@Autowired
//	private OrderService orderService;
//	
//	@Autowired
//	private MemberService memberService;
	
	@GetMapping("/orderpage")			// 주문페이지 이동 mapping 임시
	public String orderPage() {
		log.trace("payPage() invoked");
	
		return "order";
	}; // orderPage
	
	
	@GetMapping("/{memberId}") // 주문페이지로 이동 mapping
	public void orderPageGet(@PathVariable("memberId") String memberId, OrderPageDTO opd, Model model) {
		
		log.trace("memberId : " + memberId);
		log.trace("orders : " + opd.getOrders());
		
	} // orderPageGet

	
	// 찬석이 수정합니당
	
}
