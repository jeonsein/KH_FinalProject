package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class Page_ProductDTO {
	private Integer no;			// 순번
	private String name;	 	// 상품명
	private String content;		// 상품 상세정보
	private String main_image;	// 메인이미지(썸네일)
	private Integer price;		// 일반가격
	private Integer discount;	// 할인률
	private String origin;		// 원산지
	private Integer hit;		// 조회수
	private Integer discount_price;	// 할인가격
	private Integer totalCount;	// 전체 개수
	private String code;		// 카테고리 번호
	private String categoryName;// 카테고리 이름
	
	private String sub_image1;	// 서브이미지1
	private String sub_image2;	// 서브이미지2
	private String sub_image3;	// 서브이미지3
	private String sub_image4;	// 서브이미지4
	private String title;		// 상품명()
} // end class
