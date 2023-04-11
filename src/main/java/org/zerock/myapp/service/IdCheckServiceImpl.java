package org.zerock.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.mapper.IdCheckMapper;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@Service
public class IdCheckServiceImpl implements IdCheckService {

	@Autowired
	IdCheckMapper idCheckMapper;
	
	// 아이디 중복체크
	@Override
	public int idCheck(String id) {
		log.trace("id ({})invoked. 서비스 impl", id);
		
		int cntId = idCheckMapper.idCheck(id);
		
		log.trace("cntId : {} invoked ", cntId);
		
		return cntId;
		
	} // idCheck
	
	
} // end class
