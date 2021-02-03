package com.xl.ye.service.impl;

import com.xl.ye.bean.NolSysDate;
import com.xl.ye.dao.NolSysDateDao;
import com.xl.ye.service.NolSysDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NolSysDateServiceImpl implements NolSysDateService {
	
	
	@Autowired
	private NolSysDateDao nolSysDateDao;



	@Override
	public void insert(NolSysDate nolSysDate) {
		nolSysDateDao.add(nolSysDate);
	}


}
