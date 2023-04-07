package org.zerock.myapp.service;

import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.ServiceException;

public interface UserService {

	// 1. 사용자가 입력한 아이디/암호로 기등록된 사용자 정보를 획득
	public abstract UserVO login(LoginDTO dto) throws ServiceException;
	
} // end interface
