package org.zerock.myapp.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.ApiRecipesRowVO;
import org.zerock.myapp.domain.CategoryVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.domain.Page_ProductDTO;
import org.zerock.myapp.domain.ProductDTO;
import org.zerock.myapp.domain.ProductVO;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.ProductMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@ToString
@Log4j2
@NoArgsConstructor

@Service("productService")
public class ProductServiceImpl implements ProductService, InitializingBean{

	@Setter(onMethod_= { @Autowired })
	private ProductMapper mapper;
	
	
// [04/29 진호]	
	@Override
	public void afterPropertiesSet() throws ServiceException {   
		log.trace("afterPropertiesSet() invoked");
		
		try {
			Objects.requireNonNull(this.mapper);
		} catch(Exception e) {
			throw new ServiceException(e);
		} //try-catch
	} // afterPropertiesSet

	@Override
	public List<Page_ProductDTO> getList(Criteria cri) throws ServiceException {
		log.trace("\t getList({}) invoked", cri);
		
		try {
			return this.mapper.SelectAllList(cri);
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} // getList
	
	@Override
	public List<Page_ProductDTO> getOrder(Criteria cri) throws ServiceException {
		log.trace("\t getMenuOrder() invoked");
		
		try {
			return this.mapper.SelectOrder(cri);
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} // getMenuOrder

	@Override
	public Page_ProductDTO getProductDetail(Integer no) throws ServiceException {
		log.trace("\t getProductDetail({}) invoked", no);
		
		try {
			return this.mapper.SelectDetail(no);
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} //getProductDetail
	
	@Override
	public List<ApiRecipesRowVO> getRecipes(String title) throws ServiceException {
		log.trace("\t getRecipes({}) invoked", title);
		
		try {
			return this.mapper.SelectApiRecipes(title);
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} // getRecipes
	
	@Override
	public Integer getRecipesCount(String title) throws ServiceException {
		log.trace("\t getRecipesCount({}) invoked", title);
		
		try {
			return this.mapper.SelectApiRecipesCount(title);
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} //getRecipesCount
	
	@Override
	public List<Page_ProductDTO> getSearchOriginName() throws ServiceException {
		log.trace("\t getSearchOriginName() invoked");
		
		try {
			return this.mapper.SelectSearchOrigin();
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} // getSearchOriginName
	
	@Override
	public List<Page_ProductDTO> getCategoryAll() throws ServiceException {
		log.info("\t getCategory() invoked");
		
		try {
			return this.mapper.SelectCategoryAll();
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} // getCategoryAll

	@Override
	public List<Page_ProductDTO> getCategory(Criteria cri) throws ServiceException {
		log.info("\t getCategory() invoked");
		
		try {
			return this.mapper.SelectCategory(cri);
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} //getCategory
	
	

//	==================================================
//	[별이]
	
	
	/* 상품 목록 조회 */
	@Override
	public List<ProductDTO> getList() throws ServiceException {
		log.trace("getList() invoked. - 상품 목록 조회");
		
		try {
			return this.mapper.selectAll();
		}catch (Exception e) {
			throw new ServiceException(e);
		} // try-catch

	} // getList
	
	
	@Override
	public List<ProductDTO> getListPaging(Criteria cri) throws ServiceException {
		
		try {
			return this.mapper.selectAllPaging(cri);
		} catch (Exception e) {
			throw new ServiceException(e);
		} // try-catch
		
	} // getListPaging
	

	
	/* 상품 상세 조회 */
	@Override
	public ProductDTO get(Integer no) throws ServiceException {
		log.trace("getList() invoked. - 상품번호-{} 상세 조회", no);
		
		try {
			return this.mapper.select(no);
		}catch (Exception e) {
			throw new ServiceException(e);
		} // try-catch
	
	} //get
	
	
	/* 상품 등록 */
	@Override
	public Boolean register(ProductDTO dto) throws ServiceException {
	    log.trace("register({}) invoked.", dto);

	    try {
	        return this.mapper.insert(dto) == 1;
	    } catch (Exception e) {
	        throw new ServiceException(e);
	    } // try-catch
	    
	} // register
	

	/* 상품 수정 */
	@Override
	public Boolean modify(ProductDTO dto) throws ServiceException {
		log.trace("modify() invoked. - 상품 수정");
		
		try {
			return this.mapper.update(dto) == 1;
		}catch (Exception e) {
			throw new ServiceException(e);
		} // try-catch
	
	} // modify

	
	/* 상품 삭제 */
	@Override
	public Boolean remove(Integer no) throws ServiceException {
		log.trace("remove() invoked. - 상품 수정");
		
		try {
			return this.mapper.delete(no) == 1;
		}catch (Exception e) {
			throw new ServiceException(e);
		} // try-catch
	
	} // remove

	
	
	/* 카테고리 등록 */
	@Override
	public List<CategoryVO> getCateList() throws ServiceException {
		log.trace("getCateList() invoked.");
		
		try {
			return this.mapper.cateList();
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	
	} // getCateList
	

	/* 페이징 등록 */
	@Override
	public Integer getTotal() throws ServiceException {
		log.trace("getTotal() invoked.");
		
		try {
			return this.mapper.getTotal();
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
	} // getTotal

	

} // end class
