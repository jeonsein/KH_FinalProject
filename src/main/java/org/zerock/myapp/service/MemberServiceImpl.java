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
	
//	@Setter(onMethod_=@Autowired)
//	MemberMapper memberMapper;
//
//	// 회원가입
//	@Override
//	public void memberJoin(MemberVO memberVO) throws Exception {
//		
//		memberMapper.memberJoin(memberVO);
//		
//	}
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
	
	// getMemberInfo() Mapper 메서드를 호출하고 반환받은 MemberVO 객체를 반환해주는 코드를 작성 (찬돌)
	@Override
	public MemberVO getMemberInfo(String memberId) {
		
		return mapper.getMemberInfo(memberId);
	} // getMemberInfo
	
	
	
	
} // end class
