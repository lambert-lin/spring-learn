package com.xl.ye.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xl.ye.bean.NolSysParam;
import com.xl.ye.dao.NolSysParamDao;
import com.xl.ye.service.NolSysParamService;

@Service
public class NolSysParamServiceImpl implements NolSysParamService {
	
	
	@Autowired
	private NolSysParamDao nolSysParamDao;

	@Override
	public List<NolSysParam> findBySysId(String sysId) {
		// TODO Auto-generated method stub
		
		return nolSysParamDao.findBySysId(sysId);
	}

	@Override
	public void insert(NolSysParam nolSysParam) {
		nolSysParamDao.add(nolSysParam);
	}

	@Override
	public List<NolSysParam> load(String id) {
		return nolSysParamDao.load(id);
	}


}
