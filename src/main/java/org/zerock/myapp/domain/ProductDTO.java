package org.zerock.myapp.domain;

import java.sql.Timestamp;

import lombok.Value;

@Value
public class ProductDTO {
	private Integer pno;
	private String pname;
	private String content;
	private String image;
	private Integer price;
	private Integer discount;
	private String brandname;
	private Timestamp insert_ts;
	private Integer readcount;
	private Integer disprice;
	private String subimage1;
	private String subimage2;
	private String subimage3;
	private String subimage4;
	
} // end class
