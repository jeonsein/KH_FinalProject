package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class AttachImageVO {
	
	private String uuid; // pk

	private String uploadPath;
	
	private String fileName;
	
	private Integer product_no; // product 테이블의 pk인 no를 fk로 가져옴

	@Override
	public String toString() {
		return "AttachImageVO [uploadPath=" + uploadPath + ", uuid=" + uuid + ", fileName=" + fileName + ", product_no="
				+ product_no + "]";
	}
	
}
