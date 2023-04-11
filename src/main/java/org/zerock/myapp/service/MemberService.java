package org.zerock.myapp.service;

import org.zerock.myapp.domain.MemberVO;

public interface MemberService {

	// 회원가입
	public void memberJoin(MemberVO memberVO) throws Exception;
	
	// 주문자 정보 (찬돌)
	public MemberVO getMemberInfo(String memberId);
	
} // end class
