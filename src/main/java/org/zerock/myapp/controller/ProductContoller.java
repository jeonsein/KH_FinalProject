package org.zerock.myapp.controller;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.myapp.domain.ApiRecipesRowVO;
import org.zerock.myapp.domain.AttachImageVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.PageDTO;
import org.zerock.myapp.domain.Page_ProductDTO;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.domain.ProductVO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.AttachService;
import org.zerock.myapp.service.ProductService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/product")
@Controller
public class ProductContoller {
	
	@Setter(onMethod_= { @Autowired})
	private ProductService service;
	
	@Setter(onMethod_= { @Autowired})
	private AttachService aservice;
	
	
//	[04/29 진호]
//	=================================================================================
	@GetMapping("/list")
	public void list(Criteria cri, Model model) throws ControllerException {
		log.trace("\t list(cri, model) invoked");
		
		try {
			List<Page_ProductDTO> list = null;
			Integer totalCount = null;
			
			if(cri.getCurrPage() == null) {
				cri.setCurrPage(1);
			} // if
			
			if(cri.getAmount() == null) {
				cri.setAmount(12);
			} // if
					
			if(cri.getOrder() == null && cri.getOrigin() == null && cri.getWeight() == null && cri.getPrice() == null){
				if(cri.getCode().equals("10100")) {
				
				} else if(cri.getCode().equals("10800")) {
					cri.setCode_info("WHERE discount >= 30");
				} else {
				 	cri.setCode_info("WHERE category = "+cri.getCode());
				} // if
				
				list = this.service.getList(cri);
				if(list.isEmpty() == true) {
					totalCount = 0;
				} else {
					totalCount = list.get(0).getTotalCount();
					log.info(">>>>>>>>>>>>>>>>.. : {}",totalCount);
				} // if-else
			} else {
				Criteria criTemp = new Criteria();
				if(cri.getOrder() != null) {
					criTemp = this.getOrderMathod(cri);
				} // if
				
				if(cri.getOrigin() != null) {  // 원산지 검색
					criTemp = this.getOriginMethod(cri);
				} // if
				
				if(cri.getWeight() != null) { // 중량 검색
					criTemp = this.getWeightMethod(cri);
				} // if
				
				if(cri.getPrice() != null) { // 가격 검색
					criTemp = this.getPriceMethod(cri);
				} // if
				
				if(cri.getCode() != null ) { // 카테고리코드 정보
					criTemp = this.getCodeMethod(cri);
				} // if
								
				list = this.service.getOrder(criTemp);
				if(list.isEmpty() == true) {
					totalCount = 0;
				} else {
					totalCount = list.get(0).getTotalCount();
				} // if-else
			} // if-else
			
			model.addAttribute("__List__", list);
		
			PageDTO pageDTO = new PageDTO(cri, totalCount);
		
			if(cri.getOrder() != null) {
				String orderStr1 = cri.getOrder();
				switch(orderStr1) {
					case "discount_price": cri.setOrder("lowPrice"); break;
					case "name": cri.setOrder("productName"); break;
					case "no": cri.setOrder("newProduct"); break;
					case "discount": cri.setOrder("best"); break;
				} // switch-case
			} // if

			model.addAttribute("__PAGE_MAKER__",pageDTO);
			
			// 현재 페이지
			Integer cp = cri.getCurrPage();
			model.addAttribute("cp", cp);
			
			// 원산지 이름 가져오기
			List<Page_ProductDTO> originVO = this.service.getSearchOriginName();
			model.addAttribute("__OriginName__", originVO);
			
			// 카테고리 정보 가져오기
			List<Page_ProductDTO> categoryAllVO = this.service.getCategoryAll();
			model.addAttribute("__CategoryAll__", categoryAllVO);
			
			// 카테고리 정보 가져오기
			List<Page_ProductDTO> categoryVO = this.service.getCategory(cri);
			model.addAttribute("__Category__", categoryVO);
				
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // list
	
	
	// 상단 정렬 메소드
	public Criteria getOrderMathod(Criteria cri) throws ControllerException {
		log.info("\t getOrderMathod(cri) invoked");
		
		try {
			cri.setOrderby("ORDER BY");

			String orderStr = cri.getOrder();
			switch(orderStr) {
				case "lowPrice": cri.setOrder("discount_price"); break;
				case "productName": cri.setOrder("name"); break;
				case "newProduct": cri.setOrder("no"); break;
				case "best": cri.setOrder("discount"); break;
			} // switch-case
			
			if(cri.getOrder().equalsIgnoreCase("no") || cri.getOrder().equalsIgnoreCase("discount") ){
				cri.setOrder1("desc");
			} else {
				cri.setOrder1("asc");
			} // if-else

			return cri;
		} catch(Exception e) { 
			throw new ControllerException(e);
		} // try-catch
	} // getOrderMathod()
	 
	
	// 원산지 검색 메소드 
	public Criteria getOriginMethod(Criteria cri) throws ControllerException {
		log.info("\t getBrandMethod(cri) invoked");
		
		try {
			cri.setOrigin(cri.getOrigin().replace("(", ""));
			cri.setOrigin(cri.getOrigin().replace(")", "")); 
			
			if(cri.getWhere() == null ) {
				cri.setWhere("WHERE origin in");
			} // if
			
			int idx = cri.getOrigin().indexOf(",");
			log.info(">>> idx : {}", idx);
			if(idx > 0) {
				StringTokenizer stk = new StringTokenizer(cri.getOrigin(),",");
				StringBuilder sb = new StringBuilder();
				
				sb.append("(");
				while(stk.hasMoreTokens()) {
					sb.append("\'"+ stk.nextToken()+ "\',");
				} // while
				String str = sb.substring(0, sb.length()-1)+")";
				cri.setOrigin(str);
			} else {
				cri.setOrigin("(\'"+cri.getOrigin()+"\')");
			} // if-else
			
			if(cri.getWeight() != null || cri.getPrice() != null || cri.getCode() != null) {
				cri.setTestAnd("AND");
			} // if
			
			return cri;
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // getOriginMethod()
	
	
	// 중량(무게) 검색 메소드 
	public Criteria getWeightMethod(Criteria cri) throws ControllerException {
		log.info("\t getWeightMethod(cri) invoked");
		
		try {
			if(cri.getWhere() == null ) {
				cri.setWhere("WHERE ");
			} // if
			
			String weight_info = "";
		
			int idx = cri.getWeight().indexOf(",");  
			if(idx > 0) { 
				StringTokenizer stk = new StringTokenizer(cri.getWeight(), ",");
				StringBuilder sb = new StringBuilder();
				
				while(stk.hasMoreTokens()) {
					switch(stk.nextToken()) {
					case "w1": weight_info = "(case when weight like '%kg' then to_number(replace(weight,'kg','')) * 1000\r\n"
							+ "          when weight like '%g' then to_number(replace(weight,'g',''))\r\n"
							+ "          end) between 0 and 50 "; break;
					case "w2": weight_info = "(case when weight like '%kg' then to_number(replace(weight,'kg','')) * 1000\r\n"
							+ "          when weight like '%g' then to_number(replace(weight,'g',''))\r\n"
							+ "          end) between 50 and 100 "; break;
					case "w3": weight_info = "(case when weight like '%kg' then to_number(replace(weight,'kg','')) * 1000\r\n"
							+ "          when weight like '%g' then to_number(replace(weight,'g',''))\r\n"
							+ "          end) between 100 and 500 "; break;
					case "w4": weight_info = "(case when weight like '%kg' then to_number(replace(weight,'kg','')) * 1000\r\n"
							+ "          when weight like '%g' then to_number(replace(weight,'g',''))\r\n"
							+ "          end) between 500 and 1000 "; break;
					case "w5": weight_info = "(case when weight like '%kg' then to_number(replace(weight,'kg','')) * 1000\r\n"
							+ "          when weight like '%g' then to_number(replace(weight,'g',''))\r\n"
							+ "          end) between 1000 and 2000 "; break;
					case "w6": weight_info = "(case when weight like '%kg' then to_number(replace(weight,'kg','')) * 1000\r\n"
							+ "          when weight like '%g' then to_number(replace(weight,'g',''))\r\n"
							+ "          end) >= 2000 "; break;
					} // switch-case
					
					sb.append(weight_info + "OR ");
				} // while
				
				String str = sb.substring(0, sb.length()-3);
				cri.setWeight_info(str);

			} else {
				switch(cri.getWeight()) {
				case "w1": weight_info = "(case when weight like '%kg' then to_number(replace(weight,'kg','')) * 1000\r\n"
						+ "          when weight like '%g' then to_number(replace(weight,'g',''))\r\n"
						+ "          end) between 0 and 50 "; break;
				case "w2": weight_info = "(case when weight like '%kg' then to_number(replace(weight,'kg','')) * 1000\r\n"
						+ "          when weight like '%g' then to_number(replace(weight,'g',''))\r\n"
						+ "          end) between 50 and 100 "; break;
				case "w3": weight_info = "(case when weight like '%kg' then to_number(replace(weight,'kg','')) * 1000\r\n"
						+ "          when weight like '%g' then to_number(replace(weight,'g',''))\r\n"
						+ "          end) between 100 and 500 "; break;
				case "w4": weight_info = "(case when weight like '%kg' then to_number(replace(weight,'kg','')) * 1000\r\n"
						+ "          when weight like '%g' then to_number(replace(weight,'g',''))\r\n"
						+ "          end) between 500 and 1000 "; break;
				case "w5": weight_info = "(case when weight like '%kg' then to_number(replace(weight,'kg','')) * 1000\r\n"
						+ "          when weight like '%g' then to_number(replace(weight,'g',''))\r\n"
						+ "          end) between 1000 and 2000 "; break;
				case "w6": weight_info = "(case when weight like '%kg' then to_number(replace(weight,'kg','')) * 1000\r\n"
						+ "          when weight like '%g' then to_number(replace(weight,'g',''))\r\n"
						+ "          end) >= 2000 "; break;
				} // switch-case
								
				cri.setWeight_info(weight_info);
			} // if-else
			
			if(cri.getPrice() != null || cri.getCode() != null) {
				cri.setTestAnd1("AND");
			} // if
			
			return cri;
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // getWeightMethod()
	
	// 가격 검색
	public Criteria getPriceMethod(Criteria cri) throws ControllerException {
		log.info("\t getPriceMethod(cri) invoked");
		
		try {
			if(cri.getWhere() == null ) {
				cri.setWhere("WHERE ");
			} // if
			
			String price_info = "";
			
			switch(cri.getPrice()) {
			case "p1": price_info = "discount_price BETWEEN 0 AND 5000 "; break;
			case "p2": price_info = "discount_price BETWEEN 5000 AND 10000 "; break;
			case "p3": price_info = "discount_price BETWEEN 10000 AND 20000 "; break;
			case "p4": price_info = "discount_price >= 20000 "; break;
			} // switch
			
			cri.setPrice_info(price_info);
			
			if(cri.getCode() != null) {
				cri.setTestAnd2("AND");
			} // if
			
			return cri;
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch		
	} // getPriceMethod
	
	public Criteria getCodeMethod(Criteria cri) throws ControllerException{
		log.info("\t getCodeMethod(cri) invoked");
		
		try {
			if(cri.getWhere() == null ) {
				cri.setWhere("WHERE ");
			} // if
			
			if(cri.getCode().equals("10100")) { // 전체보기
				
			} else if(cri.getCode().equals("10800")){ // 오늘의 특가 
				cri.setCode_info(" discount >= 30");
			} else {
				cri.setCode_info(" category="+cri.getCode());
			} // if-else
			
			return cri;
		} catch(Exception e) { 
			throw new ControllerException(e);
		} // try-catch
	} //getCodeMethod
	
	
	// 상세정보 페이지
	@GetMapping("/info")
	public void info(@Param("no") Integer no, Model model) throws ControllerException{
		log.trace("info() invoked");
		
		try {
			Page_ProductDTO dto = this.service.getProductDetail(no);
			
			model.addAttribute("__INFO__", dto);
			
			String title = dto.getTitle();
			
			if(title != null) {
				List<ApiRecipesRowVO> apiVO = this.service.getRecipes(title);
				
				model.addAttribute("__API__", apiVO);
				
				Integer recipesCount = this.service.getRecipesCount(title);
				
				model.addAttribute("__APICOUNT__", recipesCount);
			} // if 
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // info
//	============================================================================================
	
	
	
} // end class
