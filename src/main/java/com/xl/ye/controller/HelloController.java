package com.xl.ye.controller;

import java.util.List;

import com.xl.ye.bean.NolSysDate;
import com.xl.ye.common.RespResult;
import com.xl.ye.exception.BusiException;
import com.xl.ye.service.NolSysDateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.xl.ye.bean.NolSysParam;
import com.xl.ye.logs.LogManager;
import com.xl.ye.service.NolSysParamService;

@RestController
@RequestMapping(path="/hello")
public class HelloController {
	
	@Autowired
	private NolSysParamService nolSysParamService;

	@Autowired
	private NolSysDateService nolSysDateService;
	
	@Autowired
	private LogManager logManager;


	private Logger log = LoggerFactory.getLogger(HelloController.class);


	@Transactional
	@GetMapping
	public RespResult hello() {
		
		logManager.MY_LOGGER.info("hello controller  !");
		log.info("logfactory .... -----");
		List<NolSysParam> params = nolSysParamService.load("nol");

		return RespResult.success(params.get(0));
		
		
	}

	@GetMapping(value = "/test")
	public String test() {

		return "3223232";
	}

	@GetMapping(value = "/testException")
	public String testExce() {

		throw new BusiException("2323", "d业务异常了");
	}



	@Transactional
	@RequestMapping(path="trans", method=RequestMethod.GET)
	public void trans() {

		logManager.MY_LOGGER.info("trans controller  !");


		NolSysParam nolSysParam = new NolSysParam();
		nolSysParam.setSysId("ss");
		nolSysParam.setUseFlag("0");
		nolSysParam.setParamCode("cod");
		nolSysParam.setParamValue("dss");

		NolSysDate nolSysDate = new NolSysDate();
		nolSysDate.setTodayDate("20190000");

		nolSysParamService.insert(nolSysParam);

		if("ss".equals(nolSysParam.getSysId())){
			throw new RuntimeException("sdfsdf");
		}
		nolSysDateService.insert(nolSysDate);

	}
}
