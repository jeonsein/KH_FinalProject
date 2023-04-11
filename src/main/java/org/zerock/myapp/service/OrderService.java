package org.zerock.myapp.service;

import java.util.List;

import org.zerock.myapp.domain.OrderPageItemDTO;

public interface OrderService {
	
	public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders);

}
