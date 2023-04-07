package org.zerock.myapp.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;
	
	@DateTimeFormat(pattern="yyyy/MM/dd") 
	// 표준 형식인 YYYY-MM-DD이 아닌 다른 형식으로 날짜가 들어오면? 
//	@DateTimeFormat(iso=ISO.DATE) // YYYY-MM-DD
	private Date dueDate;
	
} // end class
