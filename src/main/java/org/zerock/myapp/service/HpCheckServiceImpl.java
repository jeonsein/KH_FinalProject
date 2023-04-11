package org.zerock.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.mapper.HpCheckMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service

@NoArgsConstructor
@Log4j2
public class HpCheckServiceImpl implements HpCheckService {

	@Setter(onMethod_ = { @Autowired })
	HpCheckMapper hpCheckMapper;

	@Override
	public int hpCheck(String tel) {

		log.trace("hpCheck () invoked. 핸드폰 중복 확인 ");

		int cntTel = hpCheckMapper.hpCheck(tel);

		log.trace("hpCheck () invoked. 핸드폰 중복 ㅇㅇㅇ ");

		return cntTel;
	}

}
