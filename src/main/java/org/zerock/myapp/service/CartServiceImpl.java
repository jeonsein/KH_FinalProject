package org.zerock.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.CartDTO;
import org.zerock.myapp.mapper.CartMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service
public class CartServiceImpl implements CartService {
	
	@Setter(onMethod_= {@Autowired})
	private CartMapper cartMapper;

//	@Override
//	public boolean findCartProducts(CartDTO cartDTO) {
//		
//		return false;
//	}

	@Override
	public Integer addProductsInCart(CartDTO cartDTO) {
		// 장바구니 등록 & 에러 시 0반환
		try {
			return cartMapper.addCart();
		} catch (Exception e) {
			return 0;
		}

	}

}