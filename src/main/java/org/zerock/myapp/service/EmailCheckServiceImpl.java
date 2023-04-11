package org.zerock.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.mapper.EmailCheckMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service
public class EmailCheckServiceImpl implements EmailCheckService {

	@Setter(onMethod_={@Autowired})
	EmailCheckMapper emailCheckMapper; 
	
	// 이메일 중복 확인
	@Override
	public int emailCheck(String email) {
		log.trace("emailCheck () invoked. 이메일 중복 확인 ");
		
		int cntEmail = emailCheckMapper.emailCheck(email);
		
		log.trace("emailCheck () invoked. 이메일 중복 ㅇㅇㅇ ");
		
		return cntEmail;
		
	} // emailCheck

} // end class
