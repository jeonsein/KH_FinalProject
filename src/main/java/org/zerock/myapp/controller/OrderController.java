package org.zerock.myapp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.myapp.domain.OrderDTO;
import org.zerock.myapp.domain.OrderPageDTO;
import org.zerock.myapp.exception.ServiceException;
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
	
	@GetMapping("/orderSuccess")			
	public String orderPage1() {
		log.trace("payPage() invoked");
	
		return "order/orderSuccess";
	}; // orderPage
	
	
	// 테스트123
	@RequestMapping("/{id}") // 주문페이지로 이동 mapping
	public String orderPageGet(@PathVariable("id") String memberId, OrderPageDTO opd, Model model) throws ServiceException {
		
		log.trace("\t+ >>>>>>>>>>>>>>>>>>>>>>>>>>>> OrderController의 orderPageGet메서드 호출 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		
		log.trace("memberId : " + memberId);
		log.trace("orders : " + opd.getOrders());
		
		if(opd == null) {
			opd = new OrderPageDTO();
		} 	// opd가 null일 때는 새로운 객체를 생성하고, 그렇지 않을 때는 이미 생성된 객체를 그대로 사용
			// null인 경우에도 객체를 사용할 수 있도록 보장하며, 객체를 여러 번 생성하지 않아도 되어

		// opd.getOrders()가 null인 경우, 새로운 ArrayList를 생성하여 opd에 저장
		if(opd.getOrders() == null) {
			opd.setOrders(new ArrayList<>());
		}
		// Model객체의 addAttribute 메서드를 사용하여 상품정보, 회원정보를 만들어 내는\
		// Service 메서드를 호출하여 반환받은 값들을 View단으로 전송
		
		model.addAttribute("orderList", orderService.getProductsInfo(opd.getOrders()));
		model.addAttribute("memberInfo", memberService.getMemberInfo(memberId));
		
		return "order/order";
		
	} // orderPageGet

	@PostMapping("")
	public String orderPagePost(OrderDTO dto, HttpServletRequest request) {
		//@RequestBody
		log.trace("\t+ dto : {}", dto);
		
		orderService.order(dto);
	
		return "redirect:order/orderSuccess";
	
	} // orderPagePost
	
} // endclass
