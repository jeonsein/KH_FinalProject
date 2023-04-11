package org.zerock.myapp.mapper;

import org.zerock.myapp.domain.MemberVO;

public interface MemberMapper {
	
	// 회원가입
//	public void memberJoin(MemberVO memberVO);

	// 로그인
	public MemberVO memberLogin(MemberVO memberVO);
	
	// 회원 가입  혁규
	public void memberSignup(MemberVO memberVO);
	
	// 주문자 주소 정보 (찬돌)
	public MemberVO getMemberInfo(String memberId);
	
} // end class
