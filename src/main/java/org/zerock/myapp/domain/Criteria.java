package org.zerock.myapp.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;
import lombok.extern.log4j.Log4j2;


// 이 DTO는 페이징 처리와 관련된 전송파라미터만 수집용도
@Log4j2
@Data

public class Criteria {
   private Integer currPage = 1;    //현재 페이지 번호
   private Integer amount =  10;   // 한 페이지당 보여줄 게시물 갯수(크기)
   
   // 페이징처리를 위한 공통 전송파라미터인데.. 이를 고정시킬지, 받을지는 구현에 다라 다름
   private Integer pagesPerPage = 10; // 한 Pagination(페이지번호목록)의 크기 -> 몇개의 페이지 번호를 보여줄까?
   
//   private String order;
   
   // 검색조건이 기준정보로 역시 추가
   private String type;
   private String keyword;
   
   // [별이]스킵 할 게시물 수((currPage-1)* amount)
   private Integer skip = 0;
   
   //[04/29 진호] 추가
    private String code; // 카테고리 코드
	private String code_info;
	
	private String orderby; //
	private String order;   // 상단(상품명순, 낮은가격순 등...)
	private String order1;  // asc / desc 
	private String tempOrder; //
	
	private String where; // where 절
	private String testAnd;
	private String testAnd1;
	private String testAnd2;
	
	private String origin; // 원산지 검색
	
	private String weight; // 중량(무게) 검색
	private String weight_info;
	
	private String price;
	private String price_info; // 가격 검색
   
   // [04/29 진호] queryString 수정
   // 위의 모든 기준정보를 기반으로, Query String을 만들어 주는 메소드 추가
	public String getPagingUri() {
		log.trace("\t getPagingUri() invoked");
		
		// Spring Framework이 제공하는 Utilities를 이용해서 Query String 생성
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("");   // 전송파라미터를 Uri로 만들어준다.
		builder.queryParam("code", this.code);
		builder.queryParam("currPage", this.currPage);
		builder.queryParam("amount", this.amount);
		builder.queryParam("pagesPerPage", this.pagesPerPage);
		if(order != null) {
			builder.queryParam("order", this.order);
		} // if
		if(origin != null) {
			builder.queryParam("origin",  this.origin.replaceAll("'", "").replace("(", "").replace(")", ""));
		} // if
		if(weight != null) {
			builder.queryParam("weight", this.weight);
		} // if
		if(price != null) {
			builder.queryParam("price", this.price);
		} // if

		String queryString = builder.toUriString();
		log.info("\t queryString : {}", queryString);
		
		return queryString;
	} // getPagingUri
   
   
   // [별이]원하는 currPage, 원하는 amount
	public Criteria() {
		this.currPage = currPage;
		this.amount = amount;
		this.skip = (currPage-1)*amount;
	
	} // criteria
	
	//[별이]원하는 currPage, 원하는 amount
	public Criteria(int currPage, int amount) {
		this.currPage = currPage;
		this.amount = amount;
		this.skip = (currPage-1)*amount;
	
	} 
	

} // end class