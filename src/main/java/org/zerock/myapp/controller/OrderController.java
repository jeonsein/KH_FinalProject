package org.zerock.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.myapp.domain.OrderPageDTO;
import org.zerock.myapp.service.MemberService;
import org.zerock.myapp.service.OrderService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/order")
@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/orderpage")			// 주문페이지 이동 mapping 임시
	public String orderPage() {
		log.trace("payPage() invoked");
	
		return "order";
	}; // orderPage
	
	// 이전에 작업해둔 메서드에서 반환 타입을 String으로 수정해주고 반환 값을 order.jsp 페이지로 갈 수 있도록 부여
	@GetMapping("/{memberId}") // 주문페이지로 이동 mapping
	public String orderPageGet(@PathVariable("memberId") String memberId, OrderPageDTO opd, Model model) {
		
		log.trace("memberId : " + memberId);
		log.trace("orders : " + opd.getOrders());
		
		//  Model 객체의 addAttribute 메서드를 사용하여 상품정보, 회원정보를 만들어내는
		//	Service 메서들를 호출해서 반환받은 값들을 뷰로 전송
		
		model.addAttribute("orderList", orderService.getGoodsInfo(opd.getOrders()));
		model.addAttribute("memberInfo", memberService.getMemberInfo(memberId));
		
		return "/order";	
		
	} // orderPageGet


	

}
