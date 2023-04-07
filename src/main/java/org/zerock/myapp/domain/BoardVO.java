package org.zerock.myapp.domain;

import java.sql.Timestamp;
//timestamp가 Date타입의 자식테이블이라 써도 상관없음

import lombok.Value;
import lombok.extern.log4j.Log4j2;

@Log4j2

@Value
public class BoardVO {

   private Integer bno;
   private String Title;
   private String Content;
   private String Writer;
   private Timestamp Insert_ts; // Timestamp가 뭘가
   private Timestamp Update_ts;
   
   
} // end class