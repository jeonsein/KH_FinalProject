package org.zerock.myapp.domain;

import java.util.Date;

import lombok.Data;

@Data
//@Value
public class MemberVO {

	// 셍나 테스트용 VO
	private String MEMBER_ID;
	private String MEMBER_PW;
	private String  MEMBER_NAME;
	private String  MEMBER_MAIL;
	private String MEMBER_HP;
	private String  MEMBER_ADDR1;
	private String  MEMBER_ADDR2;
	private Integer  MEMBER_ZIPCODE;
	private  Integer ADMINCK;
//  private String GENDER;
	
	// 채영 웅ㅇ니꺼 VO
	private String id;
	private String password;
	private String name;
	private String email;
	private Integer tel;
	private Integer address1;
	private String address2;
	private String address3;
	private String gender;
	private Date birth_date;
	private Date join_date;
	private Integer adminck;

} // end class