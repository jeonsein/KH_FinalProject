package org.zerock.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.MemberVO;
import org.zerock.myapp.mapper.MemberMapper;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Setter(onMethod_=@Autowired)
	MemberMapper memberMapper;

	@Override
	public void memberJoin(MemberVO memberVO) throws Exception {
		
		memberMapper.memberJoin(memberVO);
		
	} // memberJoin()
	
} // end class
