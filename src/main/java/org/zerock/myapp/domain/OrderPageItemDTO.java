package org.zerock.myapp.domain;

import lombok.Data;


@Data
public class OrderPageItemDTO { // view에서 전달한 상품데이터를 담을 클래스 
	
	/* view로부터 전달받을 값 */
//	private String productId; // 이거 productId로 해야할지.. No로 해야할지..? -> View에서 오는값이니 productId해도될듯
	private Integer product_no; // 상품테이블에 Pk가 Number라서 Integer로 함
	
	private Integer productCount;

	/* productId를 통해 DB에서 꺼내올 데이터 */
	private String name;			// 상품이름 productName
	
	private Integer price;			// 상품가격 productPrice
	
	//private double discount;		// 할인 productDiscount
	private Integer discount;        // 할인 금액 productDiscount
	
	/* 만들어 낼 값 */
	private Integer salePrice; 			// 할인될 가격

	private Integer discountedPrice;	// 할인된 가격
	
	private Integer totalPrice;			// 총 가격

	
	
	public void initSaleTotal() {
	    this.totalPrice = this.productCount * this.price;
	    double discountRate = this.discount / 100.0; // 할인율을 백분율로 변환
	    this.discountedPrice = (int) (totalPrice * (1 - discountRate));
	    this.salePrice = totalPrice - discountedPrice;
	} //initSaleTotal()
	
	@Override
	public String toString() {
		return "OrderPageItemDTO [product_no=" + product_no + ", productCount=" + productCount + ", productName=" + name
				+ ", productPrice=" + price + ", productDiscount=" + discount + ", salePrice=" + salePrice
				+ ", totalPrice=" + totalPrice;
	}
	
} // endclass
