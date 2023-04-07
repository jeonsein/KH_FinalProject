package org.zerock.myapp.service;

import org.zerock.myapp.domain.CartDTO;

public interface CartService {
	
//	boolean findCartProducts (CartDTO cartDTO);		// 상품이 들어와있는지
	
	Integer addProductsInCart(CartDTO cartDTO);		// 카트에 상품추가

} // end class
