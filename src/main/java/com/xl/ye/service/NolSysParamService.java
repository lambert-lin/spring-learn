package com.xl.ye.service;

import java.util.List;

import com.xl.ye.bean.NolSysParam;

public interface NolSysParamService {
	
	public List<NolSysParam> findBySysId(String sysId);

	public void insert(NolSysParam nolSysParam);

	public List<NolSysParam> load(String id);

}
