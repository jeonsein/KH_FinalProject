package org.zerock.myapp.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.myapp.domain.CartDTO;
import org.zerock.myapp.domain.MemberDTO;
import org.zerock.myapp.domain.OrderDTO;
import org.zerock.myapp.domain.OrderItemDTO;
import org.zerock.myapp.domain.OrderPageItemDTO;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.CartMapper;
import org.zerock.myapp.mapper.MemberMapper;
import org.zerock.myapp.mapper.OrderMapper;
import org.zerock.myapp.mapper.ProductMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service
public class OrderServiceImpl implements OrderService {

	@Setter(onMethod_=@Autowired)
	private OrderMapper orderMapper;	//orderMapper 주입
	
	@Setter(onMethod_=@Autowired)
	private MemberMapper memberMapper;
	
	@Setter(onMethod_=@Autowired)
	private CartMapper cartMapper;
	
	@Setter(onMethod_=@Autowired)
	private ProductMapper productMapper;
	

		@Override
		public List<OrderPageItemDTO> getProductsInfo(List<OrderPageItemDTO> orders) throws ServiceException {
	
			List<OrderPageItemDTO> result = new ArrayList<OrderPageItemDTO>();	// 반환해야될 타입이 List니 List로 객체 생성
			
			for(OrderPageItemDTO ord : orders) {	// 장바구니 페이지(Veiw)에서 전달 받은 정보 List객체의 수 만큼 반복해주는 for문 작성
				//  상품 정보를 만들어내는 OrderMapper의 getProductsInfo() 메서드를 호출 , productsInfo 변수에 저장
				OrderPageItemDTO productsInfo = orderMapper.getProductsInfo(ord.getProductId());
				
		        // productsInfo 객체의 productId 값을 ord 객체의 productId 값으로 설정
		        productsInfo.setProductId(ord.getProductId());
				
				//현재의 productsInfo 변수에 있는 상품 정보 객체는 productCount에 대한 정보는 없기 때문에 뷰로부터 전달받은 productCount 값을 대입
				productsInfo.setProductCount(ord.getProductCount());
				
				//OrderPageItemDTO객체에 만들어 둔 initSaleTotal() 메서드를 호출하여 그 값들을 세팅
				productsInfo.initSaleTotal();
				
				//List객체인 reuslt에	 요소로 추가
				result.add(productsInfo);
			
			} // for
			
			return result;
			
		} // getProductsInfo()
	
	@Override
	@Transactional // Service는 여러 쿼리를 처리하게 되므로 하나의 단위로 처리하도록 단위처리 어노테이션 추가
	public void order(OrderDTO odt) {
		
	// 사용할 데이터를 가져오자
		
		/* 회원 정보 */
		MemberDTO member = memberMapper.getMemberInfo(odt.getMember_id());
		
		/* 주문 정보 */
		List<OrderItemDTO> orders = new ArrayList<>();
		for(OrderItemDTO oit : odt.getOrders()) {
			OrderItemDTO orderItem = orderMapper.getOrderInfo(oit.getProduct_no()); //product_no?
			
//		    if (orderItem == null) {
//		        // 해당 상품번호에 대한 주문 정보가 존재하지 않음
//		        continue;
//		    }
		    
			orderItem.setOrder_no(odt.getNo());
			orderItem.setProduct_no(oit.getProduct_no()); // 상품 번호 저장
			
			orderItem.setCount(oit.getCount()); // 수량 저장
			
			orderItem.initSaleTotal(); // 기본정보
			
			orders.add(orderItem); // List 객체 추가
		}
		/* orderDTO 세팅 */
		odt.setOrders(orders);
		odt.getOrderPriceInfo(); // 음..? 비용,배송비,최종비용
		
//		Date date = new Date();
//		SimpleDateFormat format = new SimpleDateFormat("_yyyyMMddmm");
//		String orderId = member.getId() + format.format(date);
//		odt.setNo(orderId);    나는 주문번호를 번호가 자동으로 생성되도록 했는데..(identity)
		

		/* DB넣기 */
	    /* MYMG_ORDER 등록 */
	    orderMapper.enrollOrder(odt); // MYMG_ORDER 등록 후, no 값이 생성됨
	    
	    /* 생성된 no 값을 가져와서 orderItemDTO에 설정 */
	    Integer orderNo = odt.getNo();
	    log.info("\t+ >>>>>>>>>>>>>>> orderNo: {}", orderNo);
	    
	    for(OrderItemDTO oit : odt.getOrders()) {
	    	oit.setOrder_no(orderNo);
		    log.info("\t+ >>>>>>>>>>>>>>> oit: {}", oit);
		    
	        orderMapper.enrollOrderItem(oit);
	    }
		
//		/* 장바구니 제거 */
//		for(OrderItemDTO oit : odt.getOrders()) {
//			log.info("\t+ ********************장바구니 제거 테스트********************");
//			CartDTO dto = new CartDTO();
//			dto.setMember_id(odt.getMember_id());
//			dto.setProduct_No(oit.getProduct_no());
//			
//			cartMapper.deleteOrderCart(dto);
//			log.info("\t+ ********************장바구니 제거 테스트********************");
//		}
		
		/* 재고 차감 */
//		for(OrderItemDTO oit : odt.getOrders()) {
////			productDTO product = productMapper.get
//			ProductDTO product = productMapper.select(oit.getNo());
//			product.setStock(product.getStock() - oit.getCount());
//		}
		
		
	} // order

}// end class
