package org.zerock.myapp.domain;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/**/root-*.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CriteriaTests {

//	@Disabled
	@Test
	@Order(1)
	@DisplayName("")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void criteriaTest() {
		log.trace("\t criteriaTest() invoked");
		
		Criteria cri = new Criteria();
		cri.setCurrPage(1);
		cri.setAmount(12);
		cri.setPagesPerPage(10);
		
		String queryString = cri.getPagingUri();
		log.info("\t queryString : {}", queryString);
	} // criteriaTest
} // end class
