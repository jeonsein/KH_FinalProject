package org.zerock.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.AttachImageVO;
import org.zerock.myapp.domain.OrderPageItemDTO;
import org.zerock.myapp.mapper.AttachMapper;
import org.zerock.myapp.mapper.OrderMapper;

import lombok.Setter;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Setter(onMethod_=@Autowired)
	private OrderService orderService;
	
	@Setter(onMethod_=@Autowired)
	private OrderMapper orderMapper;
	
	@Setter(onMethod_=@Autowired)
	private AttachMapper attachMapper;

	@Override
	public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders) {
		
		// 반환해야 할 타입이 List 이기 때문에 반환 객체가 될 List 객체를 생성해주고 초기화
		List<OrderPageItemDTO> result = new ArrayList<OrderPageItemDTO>();
		
		for(OrderPageItemDTO ord : orders) {	// 장바구니 페이지(Veiw)에서 전달 받은 정보 List객체의 수 만큼 반복해주는 for문 작성
			//  상품 정보를 만들어내는 OrderMapper의 getGoodsInfo() 메서드를 호출 , goodsInfo 변수에 저장
			OrderPageItemDTO productsInfo = orderMapper.getProductsInfo(ord.getProductId());
			
			//현재의 goodsInfo 변수에 있는 상품 정보 객체는 bookCount에 대한 정보는 없기 때문에 뷰로부터 전달받은 bookCount 값을 대입
			productsInfo.setProductCount(ord.getProductCount());
			
			//OrderPageItemDTO객체에 만들어 둔 initSaleTotal() 메서드를 호출하여 그 값들을 세팅
			productsInfo.initSaleTotal();
			
			// 이미지 정보 주입
			List<AttachImageVO> imageList = attachMapper.getAttachList(productsInfo.getProductId());
			
			productsInfo.setImageList(imageList);
			
			//List객체인 reuslt에 요소로 추가
			result.add(productsInfo);
			
		} // for 	
		
		return result;
	}

	
	
}
