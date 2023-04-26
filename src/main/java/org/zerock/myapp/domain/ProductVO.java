package org.zerock.myapp.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ProductVO {
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
	private Integer totalCount;
} // end class
