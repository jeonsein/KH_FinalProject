package org.zerock.myapp.mapper;

import org.zerock.myapp.domain.MemberDTO;
import org.zerock.myapp.domain.MemberVO;

public interface MemberMapper {
	
	// 회원 가입  혁규
		public void memberSignup(MemberVO memberVO);

	
	// 회원 가입테스트  혁규
	public void memberSignupTest(MemberDTO memberDTO);

	// 로그인
	public MemberVO memberLogin(MemberVO memberVO);	
	
	
} // end class
