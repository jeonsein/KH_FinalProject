package org.zerock.myapp.persistence;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.DAOException;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;


@Log4j2
//@NoArgsConstructor
@AllArgsConstructor

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public UserVO selectUser(LoginDTO dto) throws DAOException {
		
		log.trace("selectUser({}) invoked.", dto);
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		try (sqlSession) {
			
			String namespace = "org.zerock.myapp.persistence.UserDAO";
			String sqlId = "selectUser";
			String mappedStmt = namespace + "." + sqlId;
			
			return sqlSession.<UserVO>selectOne(mappedStmt, dto);
			
		} catch (Exception e) {
			
			throw new DAOException(e);
				
		} // try-catch
		
	} // selectUser()
	
} // end class
