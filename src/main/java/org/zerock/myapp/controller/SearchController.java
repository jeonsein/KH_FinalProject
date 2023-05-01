package org.zerock.myapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.PageDTO;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.service.SearchService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("") // base uri
@Controller
public class SearchController { // 메인페이지에 있는 검색창 -> product 테이블에 존재하는 keyword만 결과로 출력!
	
	@Setter(onMethod_=@Autowired) // 서비스 주입
	private SearchService service;
	
	@GetMapping("/mainsearch") // 1. 상품 리스트
	public String searchproductList(Criteria cri, Model model) {
		log.info("searchproductList({},{})invoked", cri, model);
		
		List<ProductDTO> list = this.service.productList(cri);
		log.info("list:" + list);
		
		if(!list.isEmpty()) { // 검색한 상품리스트
			model.addAttribute("mainsearchlist", list);
			log.info("mainsearchlist: " + list);
		} else {
			model.addAttribute("emptylist", "empty");
			return "mainsearch"; 
		} // if-else
		
		//페이징
		model.addAttribute("__PAGE_MAKER__", new PageDTO(cri, service.totalProduct(cri)));
		
		return "mainsearch";
	} // searchproductList

} // end class
