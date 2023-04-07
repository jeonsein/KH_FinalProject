package org.zerock.myapp.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CartDTO {
	
	private Integer cartid;
	private String userid;
	private String productid;
	private Integer cart_count;
	private Date cartDate;
	
}
