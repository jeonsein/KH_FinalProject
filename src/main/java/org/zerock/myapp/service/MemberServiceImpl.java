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
	
	// getMemberInfo() Mapper 메서드를 호출하고 반환받은 MemberVO 객체를 반환해주는 코드를 작성 (찬돌)
	@Override
	public MemberVO getMemberInfo(String memberId) {
		
		return memberMapper.getMemberInfo(memberId);
	} // getMemberInfo
	
} // end class
