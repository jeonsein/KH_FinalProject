package org.zerock.myapp.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;


public interface Sample1Mapper {
	
	// #{} 바인드 변수
	@Insert("INSERT INTO tbl_sample1 (col) VALUES ( #{col} )")
	public abstract int insert(@Param("col") String data);
	
} // end interface
