package org.zerock.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.domain.CartDTO;
import org.zerock.myapp.service.CartService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/cart/*")
@Controller
public class cartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/cartPage", method = RequestMethod.GET)
	public String cartPage() {
		log.trace("cartPage() invoked");
	
		return "cart";
	}; //pay
	
	@PostMapping("/cart/add")
	@ResponseBody
	public String addCartPOST(CartDTO cart, HttpServletRequest request) {
//		// 로그인 체크
//		HttpSession session = request.getSession();
//		MemberVO mvo = (MemberVO)session.getAttribute("member");
//		if(mvo == null) {
//			return "5";
//		}
		// 카트 등록
		int result = cartService.addProductsInCart(cart);
		
		return result + "";
		
	}

}
