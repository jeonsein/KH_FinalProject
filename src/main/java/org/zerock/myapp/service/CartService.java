package org.zerock.myapp.service;

import java.util.List;

import org.zerock.myapp.domain.CartDTO;
import org.zerock.myapp.exception.ServiceException;

public interface CartService { // 인터페이스
	
	// 1. 장바구니에 상품추가 (영속성에서 ADDCART)
	public Integer addProductsInCart(CartDTO cart) throws ServiceException;

	// 2. 장바구니 정보 리스트 (영속성에서  List<CartVO> getCart(String member_id);)
	public List<CartDTO> getCart(String member_id);
//	public List<CartVO> getCart(String member_id);
	
} // end interface
