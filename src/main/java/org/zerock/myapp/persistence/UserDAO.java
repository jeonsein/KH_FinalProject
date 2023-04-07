package org.zerock.myapp.persistence;

import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.DAOException;

public interface UserDAO {

	// 1. 로그인 창에서, 아이디/암호/자동 로그인 여부에 따라,
	//	  매칭되는 회원 정보를 조회/반환함.
	public abstract UserVO selectUser(LoginDTO dto) throws DAOException;
	
} // end interface
