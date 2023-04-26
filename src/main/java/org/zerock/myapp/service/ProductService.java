package org.zerock.myapp.service;

import java.util.List;

import org.zerock.myapp.domain.ApiRecipesRowVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.domain.ProductVO;
import org.zerock.myapp.exception.ServiceException;

public interface ProductService {

	// 1. 전체 상품 목록 조회
	public abstract List<ProductVO> getList(Criteria cri) throws ServiceException; 
	
	// 2. 전체 레코드 개수 조회
	public abstract Integer getRecodeCount() throws ServiceException;

	// 3. 상단 메뉴타입 순서대로 상품 목록 조회
	public abstract List<ProductVO> getOrder(Criteria cri) throws ServiceException;
	
	// 4. 상품 상세 조회
	public abstract ProductDTO getProductDetail(Integer pno) throws ServiceException;
	
	// 5. 공공데이터(레시피) 조회
	public abstract List<ApiRecipesRowVO> getRecipes(String title) throws ServiceException;
	
	// 6. 공공데이터(레시피) 갯수 조회
	public abstract Integer getRecipesCount(String title) throws ServiceException;
	
	
	// 7. 브랜드이름 전체 조회
	public abstract List<ProductVO> getSearchBrandName() throws ServiceException;
	
	// 8. 검색된 브랜드 이름 조회
	public abstract List<ProductVO> getSelectSearchBrandName(Criteria cri) throws ServiceException;
} // end interface
