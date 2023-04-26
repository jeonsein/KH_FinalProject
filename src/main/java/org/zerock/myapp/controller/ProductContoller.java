package org.zerock.myapp.controller;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.myapp.domain.ApiRecipesRowVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.PageDTO;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.domain.ProductVO;
import org.zerock.myapp.exception.ControllerException;
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
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) throws ControllerException {
		log.trace("\t list(cri, model) invoked");
		
		try {
			List<ProductVO> list = null;
			Integer totalCount = null;
			
			if(cri.getCurrPage() == null) {
				cri.setCurrPage(1);
			} // if
			
			if(cri.getAmount() == null) {
				cri.setAmount(12);
			} // if
			
			
			if(cri.getOrder() != null && cri.getBrand() != null) {	//상단정렬과 브랜드검색 모두 있을 때
				Criteria criBrand = this.getBrandMethod(cri);
				cri.setBrand("(" + criBrand.getBrand() + ")");
				
				if(cri.getWhere() == null ) {
					cri.setWhere("WHERE brandname in");
				} // if
				
				list = this.getOrderMathod(cri);
				totalCount = list.get(0).getTotalCount();
				
			} else if(cri.getOrder() != null) {   // 상단 정렬만 있을 때
				list = this.getOrderMathod(cri);
				totalCount = list.get(0).getTotalCount();
			} else  if(cri.getBrand() != null) {  // 브랜드 검색만 있을 때
		    	list = this.service.getSelectSearchBrandName(this.getBrandMethod(cri));
				totalCount = list.get(0).getTotalCount();
			} else {
				list = this.service.getList(cri);
				totalCount = this.service.getRecodeCount();
			} // if-else 
		    
			model.addAttribute("__List__", list);
		
			PageDTO pageDTO = new PageDTO(cri, totalCount);
		
			if(cri.getOrder() != null) {
				String orderStr1 = cri.getOrder();
				switch(orderStr1) {
					case "disprice": cri.setOrder("lowPrice"); break;
					case "pname": cri.setOrder("productName"); break;
					case "pno": cri.setOrder("newProduct"); break;
					case "discount": cri.setOrder("best"); break;
				} // switch-case
			} // if

			model.addAttribute("__PAGE_MAKER__",pageDTO);
			
			// 현재 페이지
			Integer cp = cri.getCurrPage();
			model.addAttribute("cp", cp);
			
			// 브랜드 이름 가져오기
			List<ProductVO> brandVO = this.service.getSearchBrandName();
			model.addAttribute("__BrandName__", brandVO);
						
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // list
	
	
	// 상단 정렬 메소드
	public List<ProductVO> getOrderMathod(Criteria cri) throws ControllerException {
		try {
			log.info("\t getOrderMathod(cri) invoked");
			
			cri.setOrderby("ORDER BY");

			String orderStr = cri.getOrder();
			switch(orderStr) {
				case "lowPrice": cri.setOrder("disprice"); break;
				case "productName": cri.setOrder("pname"); break;
				case "newProduct": cri.setOrder("pno"); break;
				case "best": cri.setOrder("discount"); break;
			} // switch-case
			
			if(cri.getOrder().equalsIgnoreCase("pno") || cri.getOrder().equalsIgnoreCase("discount") ){
				cri.setOrder1("desc");
			} else {
				cri.setOrder1("asc");
			} // if-else
			
			List<ProductVO> list = this.service.getOrder(cri);
		
			return list;
		} catch(Exception e) { 
			throw new ControllerException(e);
		} // try-catch
	} // getOrderMathod()
	 
	
	// 브랜드 검색 메소드 
	public Criteria getBrandMethod(Criteria cri) throws ControllerException {
		try {
			log.info("\t getBrandMethod(cri) invoked");

			cri.setBrand(cri.getBrand().replace("(", ""));
			cri.setBrand(cri.getBrand().replace(")", "")); 
			
			if(cri.getWhere() == null ) {
				cri.setWhere("WHERE brandname in");
			} // if
			
			int idx = cri.getBrand().indexOf(",");
			if(idx > 0) {
				StringTokenizer stk = new StringTokenizer(cri.getBrand(),",");
				StringBuilder sb = new StringBuilder();
				
				while(stk.hasMoreTokens()) {
					sb.append("\'" + stk.nextToken()  + "\'" + ",");
				} // while
				String str = sb.substring(0, sb.length()-1);
				cri.setBrand(str);
			} else {
				cri.setBrand("\'" + cri.getBrand()  + "\'");
			} // if-else

			return cri;
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // getBrandMethod()
	
	
	
	@GetMapping("/info")
	public void info(@Param("pno") Integer pno, Model model) throws ControllerException{
		log.trace("info() invoked");
		
		try {
			ProductDTO dto = this.service.getProductDetail(pno);
			
			model.addAttribute("__INFO__", dto);
			
			String title = dto.getPtitle();
			
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
	

} // end class
