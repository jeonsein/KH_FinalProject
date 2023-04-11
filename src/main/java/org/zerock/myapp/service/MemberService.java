package org.zerock.myapp.service;

import org.zerock.myapp.domain.MemberVO;

public interface MemberService {

	// 회원가입
//	public void memberJoin(MemberVO memberVO) throws Exception;
	
	// 로그인
	// MemberVO를 파라미터, 반환 값으로 사용함
	public MemberVO memberLogin(MemberVO memberVo) throws Exception;
	
	// 회원가입 혁규
	public void memberSignup(MemberVO memberVO) throws Exception;
	
	// 주문자 정보 (찬돌)
	public MemberVO getMemberInfo(String memberId);
	
} // end class
