package org.zerock.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.myapp.domain.ApiRecipesRowVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.domain.ProductVO;

public interface ProductMapper {

	@Select("""
			SELECT pno, pname, content, image, price, discount, 
			brandname, insert_ts, readcount, (price - (price * (discount / 100))) - mod(price - 
			(price * (discount /100)), 10) as disprice 
			FROM product_list 
			ORDER BY pno DESC
			OFFSET ( #{currPage} -1) * #{amount} ROWS FETCH NEXT #{amount} ROWS ONLY
			""")
	public abstract List<ProductVO> SelectAllList(Criteria cri);		// 전체목록 가져오기
	
	@Select("SELECT count(pno) FROM product_list")
	public abstract Integer SelectRecodeAll();						// 전체 레코드 갯수 가져오기
	
	public abstract List<ProductVO> SelectOrder(Criteria cri);	// 상단 메뉴타입 순서대로 상품 목록 조회
	
	public abstract ProductDTO SelectDetail(Integer pno);	// 상품 상세 조회
	
	public abstract List<ApiRecipesRowVO> SelectApiRecipes(String title); // 레시피 정보 가져오기(공공데이터)
	
	@Select("""
			SELECT count(rno)
			FROM product_recipes 
			WHERE rcp_parts_dtls like '%'||#{title}||'%'
			""")
	public abstract Integer SelectApiRecipesCount(String title); // 레시피 갯수 가져오기
	
	
	public abstract List<ProductVO> SelectSearchBrand();  // 브랜드 종류 가져오기
	
	public abstract List<ProductVO> SelectSearchBrandGet(Criteria cri); // 검색된 브랜드 가져오기
	
} // end interface

