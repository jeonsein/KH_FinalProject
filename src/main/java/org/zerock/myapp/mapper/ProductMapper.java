package org.zerock.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.myapp.domain.ApiRecipesRowVO;
import org.zerock.myapp.domain.CategoryVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.Page_ProductDTO;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.domain.ProductVO;

public interface ProductMapper {

//	[04/29 진호]
//	======================================================================================
	@Select("""
			SELECT no, name, price, discount, discount_price, main_image, category AS code,
			( SELECT count(no) FROM product ${code_info}) as totalCount
			FROM product 
			${code_info}
			ORDER BY no DESC
			OFFSET ( #{currPage} -1) * #{amount} ROWS FETCH NEXT #{amount} ROWS ONLY
			""")
	public abstract List<Page_ProductDTO> SelectAllList(Criteria cri);		// 전체목록 가져오기
	
	public abstract List<Page_ProductDTO> SelectOrder(Criteria cri);	// 상단 메뉴타입 순서대로 상품 목록 조회
	
	public abstract Page_ProductDTO SelectDetail(Integer pno);	// 상품 상세 조회
	
	public abstract List<ApiRecipesRowVO> SelectApiRecipes(String title); // 레시피 정보 가져오기(공공데이터)
	
	@Select("""
			SELECT count(rno)
			FROM product_recipes 
			WHERE rcp_parts_dtls like '%'||#{title}||'%'
			""")
	public abstract Integer SelectApiRecipesCount(String title); // 레시피 갯수 가져오기
	
	public abstract List<Page_ProductDTO> SelectSearchOrigin();  // 원산지 종류 가져오기

	@Select("""
			SELECT name AS categoryName, code
			FROM category
			""")
	public abstract List<Page_ProductDTO> SelectCategoryAll();		// 전체 카테고리 가져오기
	
	@Select("""
			SELECT name AS categoryName, code
			FROM category
			WHERE code = #{code}
			""")
	public abstract List<Page_ProductDTO> SelectCategory(Criteria cri); // 카테고리 가져오기

//	==============================================================
//	[별이]
	
	/* 상품 전체 조회 */
	@Select("SELECT * FROM PRODUCT ORDER BY NO DESC")
	public abstract List<ProductDTO> selectAll();
	
	/* 상품 전체 조회(페이징처리) */
	public abstract List<ProductDTO> selectAllPaging(Criteria cri);
	
	//-------------------------- XML 매핑 방식 ------------------------------//
	
	/* 상품 상세 조회 */
	public abstract ProductDTO select(Integer no);
	
	/* 상품 등록 */
	public abstract Integer insert(ProductDTO dto);
	
	/* 상품 수정 */
	public abstract Integer update(ProductDTO dto);
	
	/* 상품 삭제 */
	public abstract Integer delete(Integer no);
	
	/* 상품 게시글 총 갯수 */
	public abstract Integer getTotal();
		
	/* 카테고리 리스트 */
	public abstract List<CategoryVO> cateList();

} // end interface
