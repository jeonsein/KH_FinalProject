package org.zerock.myapp.mapper;

import org.zerock.myapp.domain.OrderPageItemDTO;

public interface OrderMapper {
	
	// 상품정보를 얻기 위해 db에 요청
	public OrderPageItemDTO getProductsInfo(String productId);

}
