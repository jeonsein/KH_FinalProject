package org.zerock.myapp.domain;

import java.util.List;

import lombok.Data;

@Data
public class OrderPageDTO {
	
	private List<OrderPageItemDTO> orders;	//주문 페이지에서 보여지는 각 주문 아이템들의 정보를 가져옴

	@Override
	public String toString() {
		return "OrderPageDTO [orders=" + orders + "]"; // toString() 메소드를 오버라이드
	}												   // 객체를 문자열로 출력하기 위한 것으로, orders 필드를 출력
		
} // end class
