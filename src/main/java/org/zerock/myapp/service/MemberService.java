package org.zerock.myapp.service;

import org.zerock.myapp.domain.MemberVO;

public interface MemberService {

	// 회원가입
	public void memberJoin(MemberVO memberVO) throws Exception;
	
} // end class
