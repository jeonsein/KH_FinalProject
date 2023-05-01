package org.zerock.myapp.mapper;

import org.zerock.myapp.domain.CartDTO;
import org.zerock.myapp.domain.OrderDTO;
import org.zerock.myapp.domain.OrderItemDTO;
import org.zerock.myapp.domain.OrderPageItemDTO;
import org.zerock.myapp.domain.ProductDTO;

public interface OrderMapper {
	
	// 상품정보를 얻기 위해 db에 요청
	public OrderPageItemDTO getProductsInfo(Integer product_no);
	
	// 주문 상품 정보 담는 mapper(주문처리) // 주문상품DTO에서 가져옴
	public OrderItemDTO getOrderInfo(Integer product_no);
	
	// MYMG_ORDER 테이블에 주문 등록 테이블
	public Integer enrollOrder(OrderDTO ord);
	
	// ORDER_LIST 테이블에 주문 상품 등록 테이블
	public Integer enrollOrderItem(OrderItemDTO oit);
	
	// 회원이 주문한 상품의 개수만큼 '상품 재고'를 차감
	public Integer deductStock(ProductDTO product);
	
	// 주문완료시 장바구니 상품 정보 삭제
	public Integer deleteOrderCart(CartDTO dto);

}
