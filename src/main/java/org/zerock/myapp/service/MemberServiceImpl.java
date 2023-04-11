package org.zerock.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.MemberVO;
import org.zerock.myapp.mapper.MemberMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@NoArgsConstructor
@Log4j2
@Service
public class MemberServiceImpl implements MemberService {
	

	// 혁규 회원가입
		@Setter(onMethod_=@Autowired)
		MemberMapper mapper;
		@Override
		public void memberSignup(MemberVO memberVO) throws Exception{

			log.trace("MemberVO : {} invoked", memberVO );
			
			mapper.memberSignup(memberVO);
			
			log.trace("MemberVO : {} invoked", memberVO );
		}

	// 로그인
	@Override
	public MemberVO memberLogin(MemberVO memberVo) throws Exception {
		
		return mapper.memberLogin(memberVo);
	
	} // memberLogin()
	
	
	
	
} // end class
