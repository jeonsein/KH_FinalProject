package org.zerock.myapp.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public void list(@Param("amount") Integer amount, Criteria cri, Model model) throws ControllerException {
		log.trace("\t list() invoked");
		
		try {
			log.info("\t param : {}", amount);
			
			cri.setAmount(amount);
			
			if(cri.getCurrPage() == null || cri.getAmount() == null) {
				cri.setCurrPage(1);
				cri.setAmount(12);
			} // if
			
			List<ProductVO> list = null;
			if(cri.getOrder() != null) {
				list = this.service.getOrder(cri);
			} else {
				list = this.service.getList(cri);
			} // if-else
			
//			List<ProductVO> list = this.service.getList(cri);
			model.addAttribute("__List__", list);
			
			Integer totalCount = this.service.getRecodeCount();
			PageDTO pageDTO = new PageDTO(cri, totalCount);
			
			log.info("\t totalCount : {}", totalCount);
			log.info("\t pagdDTO : {}", pageDTO);
			
			model.addAttribute("__PAGE_MAKER__",pageDTO);
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // list
	
	@GetMapping("/info")
	public void info(@Param("pno") Integer pno, Model model) throws ControllerException{
		log.trace("info() invoked");
		
		try {
			ProductDTO dto = this.service.getProductDetail(pno);
			
			log.info("\t dto : {}", dto);
			
			model.addAttribute("__INFO__", dto);
			
		} catch(Exception e) {
			throw new ControllerException(e);
		} // try-catch
	} // info
	

} // end class
