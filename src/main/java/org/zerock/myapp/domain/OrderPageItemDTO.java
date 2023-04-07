package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class OrderPageItemDTO {
	
	/* view로부터 전달받을 값 */
	private String productId;
	
	private Integer productCount;

	/* productId를 통해 DB에서 꺼내올 데이터 */
	private String productName;			// 상품이름
	
	private Integer productPrice;
	
	private double productDiscount;
	
	/* 만들어 낼 값 */
	private Integer salePrice; 			// 할인 가격
	
	private Integer totalPrice;			// 총 가격
	
	public void initSaleTotal( ) {
		this.salePrice = (int) (this.productPrice * (1-this.productDiscount));
		this.totalPrice = this.salePrice*this.productPrice;
	} //initSaleTotal
	
	@Override
	public String toString() {
		return "OrderPageItemDTO [productId=" + productId + ", productCount=" + productCount + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productDiscount=" + productDiscount + ", salePrice=" + salePrice
				+ ", totalPrice=" + totalPrice ;
	}
	
} // endclass
