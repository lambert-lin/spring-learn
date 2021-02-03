package com.xl.ye;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.xl.ye.bean.NolSysParam;
import com.xl.ye.service.NolSysParamService;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {
	
	@Autowired
	private NolSysParamService nolSysParamService;

	@Test
	public void ttt() {
		List<NolSysParam> params = nolSysParamService.findBySysId("nol");
		System.out.println(params.get(0).toString());
	}
}
