package org.zerock.myapp.mapper;

import org.zerock.myapp.domain.MemberVO;

public interface MemberMapper {
	
	// 회원 가입  혁규
	public void memberSignup(MemberVO memberVO);

	// 로그인
	public MemberVO memberLogin(MemberVO memberVO);	
	
	
} // end class
