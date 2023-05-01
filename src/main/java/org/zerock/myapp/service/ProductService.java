package org.zerock.myapp.service;

import java.util.List;

import org.zerock.myapp.domain.ApiRecipesRowVO;
import org.zerock.myapp.domain.CategoryVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.FarmVO;
import org.zerock.myapp.domain.Page_ProductDTO;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.domain.ProductVO;
import org.zerock.myapp.exception.ServiceException;

public interface ProductService {

// [04/29 진호]
//	=============================================================================
	// 1. 전체 상품 목록 조회
	public abstract List<Page_ProductDTO> getList(Criteria cri) throws ServiceException; 
		
	// 2. 상단 메뉴타입 순서대로 상품 목록 조회
	public abstract List<Page_ProductDTO> getOrder(Criteria cri) throws ServiceException;
		
	// 3. 상품 상세 조회
	public abstract Page_ProductDTO getProductDetail(Integer pno) throws ServiceException;
		
	// 4. 공공데이터(레시피) 조회
	public abstract List<ApiRecipesRowVO> getRecipes(String title) throws ServiceException;
		
	// 5. 공공데이터(레시피) 갯수 조회
	public abstract Integer getRecipesCount(String title) throws ServiceException;
		
	// 6. 브랜드이름 전체 조회
	public abstract List<Page_ProductDTO> getSearchOriginName() throws ServiceException;
		
	// 7. 카테고리 정보 전체 조회
	public abstract List<Page_ProductDTO> getCategoryAll() throws ServiceException;
		
	// 8. 카테고리 정보 조회
	public abstract List<Page_ProductDTO> getCategory(Criteria cri) throws ServiceException;
	
	
//	----------------------------------
//	[별이 4/14]
	
	// 1. 전체 상품 목록 조회
	public abstract List<ProductDTO> getList() throws ServiceException;
	
	// 1-1. 상품 목록 조회(페이징)
	public abstract List<ProductDTO> getListPaging(Criteria cri) throws ServiceException;
		
	// 2. 상품 상세 조회
	public abstract ProductDTO get(Integer no) throws ServiceException;
		
	// 3. 상품 등록
	public abstract Boolean register(ProductDTO dto) throws ServiceException;
	
	// 4. 상품 수정
	public abstract Boolean modify(ProductDTO dto) throws ServiceException;
	
	// 5. 상품 삭제
	public abstract Boolean remove(Integer no) throws ServiceException;
	
	// 6. 카테고리 등록
	public abstract List<CategoryVO> getCateList() throws ServiceException;
	
	// 7. 게시글 건수 반환
	public abstract Integer getTotal() throws ServiceException;
	
	
} // end interface
