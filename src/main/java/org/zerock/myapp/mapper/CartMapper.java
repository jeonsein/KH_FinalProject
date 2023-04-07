package org.zerock.myapp.mapper;

import java.util.List;

import org.zerock.myapp.domain.CartDTO;

public interface CartMapper { // 인터페이스!!
	//**메소드 선언
	//-> cartMapper.xml 에 쿼리 작성함
	
//	카트 추가
	public abstract Integer addCart(CartDTO cart); // cartdto가 매개변수로! -> 테이블의 row를 추가해주는 메소드! 한번에 값을 다 가져오기 위해 cartdto 사용
	
//	카트 삭제
	public abstract Integer deleteCart(Integer no); // 장바구니 번호!로 어떤 ROW 삭제할지 지정하기
	
//	카트 수량 수정 
	public abstract Integer modifyCount(CartDTO cart); // 지정한 ROW의 수량 변경! 
	//어떤 ROW인지 지정하기 위한 NO와 몇개로 변경할지에 대한 COUNT가 필요-> 두값을 한번에 가져오기 위해 CARTDTO 선언
	
//	카트 목록 확인
	public abstract List<CartDTO> getCart(String member_id);	// 회원의 모든 ROW를 가져오기! 어떤 회원인지 알아야 해서 member테이블의 id가 필요
	//한개 이상의 장바구니 데이터를 반환받아야 해서 list<cartdto>
	
//	카트 확인
	public abstract CartDTO checkCart(CartDTO cart); //회원정보(memberid)와 상품정보(product_no) 넘겨서 해당하는 row있는지 확인해서 한번에 넘기려고 cartdto 선언 
	
} //end class
