package org.zerock.myapp.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.domain.CartDTO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.CartService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("") // base uri
@Controller
public class CartController {
	
	@Setter(onMethod_=@Autowired) // 서비스 주입
	private CartService service;
	
	
//	@RequestMapping(value = "/cart", method = RequestMethod.GET)
//	public String cartPageGET() {
//		log.trace("cartPageGET() invoked(장바구니 페이지로 이동)");
//		
//		return "cart";
//	} // cartPageGET
	
	// 1. 장바구니 조회는 회원만 할 수 있으니까 member_id데이터를 얻기 위해 파라미터 추가
	// 장바구니 데이터를 뷰에 넘길 때 model상자에 담아서 넘기기
	@GetMapping("/cart") //@PathVariable("codud") 
	public String cartMainPage(String member_id, Model model) {
		log.trace("cartPageGET() invoked(장바구니 메인 페이지로 이동)");
		
		Objects.requireNonNull(this.service);
		log.info("\t+this.service:{}", this.service);
		
		model.addAttribute("cartinfo", service.getCart("codud")); // cartinfo에 장바구니 정보 리스트 담기

		return "cart";
	} // cartMainPage
	
	
	@PostMapping("/cart/add")
	@ResponseBody // 화면을 반환하는 것이 아니라 데이터를 반환하는 것이기 떄문
	public String addProductsInCart(CartDTO cart, HttpServletRequest request) throws ControllerException {
										// 등록할 데이터 전달받아야 해서 DTO, 로그인 여부 확인하기 위해 SESSION 객체가 필요
		
		// 1. 로그인 체크
//		HttpSession session = request.getSession();
//		MemberVO vo = (MemberVO)session.getAttribute("member");
//		if(vo == null) {
//			return "5"; // 멤버 아니면 5반환 -> 로그인 필요함!
//		}
		
		
		// 2. 카트 등록
		try {
		int result = service.addProductsInCart(cart);
		
		return result + ""; // int -> string 하기 위해 빈문자열""을 더함
		}catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
		
	} // addProductsInCartPOST

}
