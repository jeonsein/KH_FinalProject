package org.zerock.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.CategoryVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.NoticeVO;
import org.zerock.myapp.domain.PageDTO;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.exception.AException;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.service.ProductService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor

@Component
@SessionAttributes({"product", "productDTO"})

@Controller
@RequestMapping("/admin")
public class AdminController {
   
   
   private ProductService service;
   private ProductDTO dto;
   
   //채영 테스트
   
   
   /* 1. 관리자 페이지 이동 */
   
   @GetMapping("/main")
   public String adminMain() throws AException{
      log.trace("adminMain() invoked. (관리자 페이지 이동)");
      
      return "admin/main";
      
      // 어드민 수정 테스트입니당~
      // 다시수정할게용
      // 졸리당
      // 테스트입니당당당
      // 테스트예요 TT
      // TEST
      
   } // adminMain
   
   
   
   
//   =========================== 상품 ===========================
   
// [별이] 메소드 추가

    /* 상품 목록 GET */
	@GetMapping("/product/list")
	public void list(Criteria cri, Model model) throws ControllerException {	// 게시판 전체 목록 조회 요청 처리 핸들러
		
		log.trace("list({}, {}) invoked.", cri, model);
		
		// 주입 잘 됐는지 확인용
//		Objects.requireNonNull(this.service);
//		log.info("\t+ this.service: {}", this.service);
		
		try {
			// 페이징처리된 현재 pageNum에 해당하는 게시글목록 받아옴
			List<ProductDTO> list = this.service.getListPaging(cri);
			model.addAttribute("list", list); // view로 날아갈 model 상자 안에 model 데이터를 담음
			
			
			int totalAmount = this.service.getTotal();
			PageDTO pageDTO = new PageDTO(cri, totalAmount);
			model.addAttribute("pageMaker", pageDTO);
			
		} catch (Exception e) {
			throw new ControllerException(e);
		} // try-catch
		
	} // list()
	
	
	/* 상품 상세, 수정 상세 */
	@GetMapping({"/product/get", "/product/modify"})
	public void get(@RequestParam("no") Integer no, Model model) throws ControllerException {
		// 매개변수 이름이 전송 파라미터와 어쩔수없이 달라야 한다면
		// 이 RequestParam으로 값을 달라고 할 전송 파라미터를 지정
		
		log.trace("get({}, {}) invoked.", no, model);
		
		try {
			
	         ObjectMapper objm = new ObjectMapper();
	         
	         List<CategoryVO> list = this.service.getCateList();
	         
	         String cateList = objm.writeValueAsString(list);
	         
	         model.addAttribute("cateList", cateList);
	         
	         ProductDTO dto = this.service.get(no);
	         model.addAttribute("product", dto);
		} catch (Exception e) {
			throw new ControllerException(e);
		} // try-catch
		
	} // get()
	
	
	/* 상품 수정 */
	@PostMapping("/product/modify")
	public String modify(@RequestParam("files") List<MultipartFile> files, ProductDTO dto, RedirectAttributes rttrs) 
			throws ControllerException {
		
		log.trace("remove({}, {}, {}) invoked.", dto, rttrs);
		
		try {
			
		            files.forEach( f-> {
		               log.info("\t+1.Name:{}", f.getName());
		               log.info("\t+2.originalfilename:{}", f.getOriginalFilename());
		               log.info("\t+3.Contenttype:{}", f.getContentType());
		               log.info("\t+4.Size:{}", f.getSize());
		               log.info("\t ---------------------------");
		               
		               if(!"".equals(f.getOriginalFilename())) {
		                  
		                  //방법1
		                  try {
		                     f.transferTo(new File("C:/app/2023/eclipse/workspace/jee-2022-06/MYMG/src/main/webapp/resources/product/" +f.getOriginalFilename()));
		                     for (int i = 0; i < files.size(); i++) {
		                    	    MultipartFile file = files.get(i);
		                    	    String filename = file.getOriginalFilename();

		                    	    // 각 파일의 이름에 따라 DTO 객체의 필드 설정
		                    	    switch (i) {
		                    	        case 0:
		                    	            dto.setMain_image(filename);
		                    	            break;
		                    	        case 1:
		                    	            dto.setSub_image1(filename);
		                    	            break;
		                    	        case 2:
		                    	            dto.setSub_image2(filename);
		                    	            break;
		                    	        case 3:
		                    	            dto.setSub_image3(filename);
		                    	            break;
		                    	        case 4:
		                    	            dto.setSub_image4(filename);
		                    	            break;
		                    	        case 5:
		                    	            dto.setContent_image(filename);
		                    	            break;
		                    	        default:
		                    	            break;
		                    	    } // switch
		                    	} // for
		                  } catch(IOException e) {
		                     e.printStackTrace();
		                  } // try catch
		                  
		               } // if
		            }); // .forEach
		            
			boolean success = this.service.modify(dto); 
			log.info("\t: success : {}", success);
			
			rttrs.addAttribute("result", (success)? "success" : "failure"); 

			return "redirect:/admin/product/list";
		}catch(Exception e) {
			throw new ControllerException(e);
		} // try catch
	} // modify()
	
	
	
	/* 상품 삭제 */
	@PostMapping("/product/remove")
	public String remove(Criteria cri, Integer no, RedirectAttributes rttrs) 
			throws ControllerException {
		
		log.trace("remove({}, {}, {}) invoked.", cri, no, rttrs);
		
		try {
			boolean success = this.service.remove(no); 
		
			
			rttrs.addAttribute("result", (success)? "success" : "failure"); 
			//성공했던 실패했든 그대로 있으면 안되고 이동시켜야 하기 때문에 리다이렉션 무조건 
			return "redirect:/admin/product/list"; // redirect 때문에 string으로 선언한듯
		}catch(Exception e) {
			throw new ControllerException(e);
		} // try catch
	} // remove()
   
   
   /* 상품 등록 GET - 카테고리 */
   @GetMapping("/product/register")
   public void register(Model model) throws ControllerException, JsonProcessingException {
      log.trace("register() invoked. (관리자 페이지 상품 등록-GET)", model);
      
      try {
         ObjectMapper objm = new ObjectMapper();
         
         List<CategoryVO> list = this.service.getCateList();
         
         String cateList = objm.writeValueAsString(list);
         
         model.addAttribute("cateList", cateList); // view로 날아갈 model 상자 안에 model 데이터를 담음

         log.info("------변경 전 : " + list);
         log.info("------변경 후 : " + cateList);
         
      } catch (ServiceException e) {
         throw new ControllerException(e);
      } // try-catch
      

   } // register-get
   
   
   /* 상품 등록 POST - 상품 내용, 이미지 등록 */
   @PostMapping("/product/register")
   public String processMultipart(@RequestParam("files") List<MultipartFile> files, ProductDTO dto, RedirectAttributes rttrs) throws ControllerException {
      log.trace("processMultiPart({}) invoked", files);
      try {
          
            files.forEach( f-> {
               log.info("\t+1.Name:{}", f.getName());
               log.info("\t+2.originalfilename:{}", f.getOriginalFilename());
               log.info("\t+3.Contenttype:{}", f.getContentType());
               log.info("\t+4.Size:{}", f.getSize());
               log.info("\t ---------------------------");
               
               if(!"".equals(f.getOriginalFilename())) {
                  
                  //방법1
                  try {
                     f.transferTo(new File("C:/app/2023/eclipse/workspace/jee-2022-06/MYMG/src/main/webapp/resources/product/" +f.getOriginalFilename()));
                     for (int i = 0; i < files.size(); i++) {
                    	    MultipartFile file = files.get(i);
                    	    String filename = file.getOriginalFilename();

                    	    // 각 파일의 이름에 따라 DTO 객체의 필드 설정
                    	    switch (i) {
                    	        case 0:
                    	            dto.setMain_image(filename);
                    	            break;
                    	        case 1:
                    	            dto.setSub_image1(filename);
                    	            break;
                    	        case 2:
                    	            dto.setSub_image2(filename);
                    	            break;
                    	        case 3:
                    	            dto.setSub_image3(filename);
                    	            break;
                    	        case 4:
                    	            dto.setSub_image4(filename);
                    	            break;
                    	        case 5:
                    	            dto.setContent_image(filename);
                    	            break;
                    	        default:
                    	            break;
                    	    } // switch
                    	} // for
                  } catch(IOException e) {
                     e.printStackTrace();
                  } // try catch
                  
               } // if
            }); // .forEach
            	 
            boolean success = this.service.register(dto);
            log.info("\t: success: {}", success);

            // 비지니스 요청 처리용 전송파라미터 전송처리
            rttrs.addAttribute("result", (success)? "success" : "failure"); 
            // KEY = 등록처리결과

            return "redirect:/admin/product/list"; // 실패했든 성공했든 여기로 이동

            } catch (Exception e) {
               throw new ControllerException(e);
            } // try-catch
         
      } // register-post

   
} // end class