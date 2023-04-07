package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class LoginDTO {

	// 직접 getter,setter 만들거 아니면
	// 필드의 이름이 전송 파라미터의 이름이 같아야 함
	private String userid;
	private String userpw;
	
	// remeberMe = check-box 
	// -> check-box가 켜져있는지 꺼져있는지만 보기! = boolean 타입으로
	private Boolean rememberMe;
	
} // end class
