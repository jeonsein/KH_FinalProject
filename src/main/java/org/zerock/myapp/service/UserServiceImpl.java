package org.zerock.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.UserVO;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.persistence.UserDAO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service
public class UserServiceImpl implements UserService {

	@Setter(onMethod_=@Autowired)
	private UserDAO userDAO;

	@Override
	public UserVO login(LoginDTO dto) throws ServiceException {
		log.trace("login({}) invoked.", dto);
		
		try {
			return this.userDAO.selectUser(dto);
		} catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch
		
	} // login()

} // end class
