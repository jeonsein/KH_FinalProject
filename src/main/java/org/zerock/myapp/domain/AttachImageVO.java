package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class AttachImageVO {
	
	private String uploadPath;
	
	private String uuid;
	
	private String fileName;
	
	private Integer productId;

	@Override
	public String toString() {
		return "AttachImageVO [uploadPath=" + uploadPath + ", uuid=" + uuid + ", fileName=" + fileName + ", productId="
				+ productId + "]";
	}
	
}
