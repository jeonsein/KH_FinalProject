package org.zerock.myapp.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
public class Criteria {
	private Integer currPage;	 // 현재 페이지 번호
	private Integer amount;		 // 한 페이지 당 보여줄 갯수
	private Integer pagesPerPage = 10;  // 한 Pagination(페이지번호목록)의 크기(길이)
	
	private String orderby; //
	private String order;   // 상단(상품명순, 낮은가격순 등...)
	private String order1;  // asc / desc 
	private String tempOrder; //
	
	
	private String where; //
	private String brand; // 브랜드 검색
	
	private Integer weight; // 중량(무게) 검색
	private String weight_info;
	


	
	// 위의 모든 기준정보를 기반으로, Query String을 만들어 주는 메소드 추가
	public String getPagingUri() {
		log.trace("\t getPagingUri() invoked");
		
		// Spring Framework이 제공하는 Utilities를 이용해서 Query String 생성
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("");   // 전송파라미터를 Uri로 만들어준다.
		builder.queryParam("currPage", this.currPage);
		builder.queryParam("amount", this.amount);
		builder.queryParam("pagesPerPage", this.pagesPerPage);
		if(order != null) {
			builder.queryParam("order", this.order);
		} // if
				
		if(brand != null) {
			builder.queryParam("brand",  this.brand.replaceAll("'", "").replace("(", "").replace(")", ""));
		} // if
		if(weight != null) {
			builder.queryParam("weight", this.weight);
		} // if
		if(weight_info != null) {
			builder.queryParam("weight_info", this.weight_info);
		} // if
		
		
		

		
		String queryString = builder.toUriString();
		log.info("\t queryString : {}", queryString);
		
		return queryString;
	} // getPagingUri
		
} // end class
