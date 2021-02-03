package com.xl.ye.dao;

import java.util.List;


import com.xl.ye.bean.NolSysParam;

public interface NolSysParamDao {
	
	
	public List<NolSysParam> findBySysId(String sysId);

	void add(NolSysParam nolSysParam);

	public List<NolSysParam> load(String id);
}
