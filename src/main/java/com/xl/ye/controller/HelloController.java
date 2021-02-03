package com.xl.ye.controller;

import java.util.List;

import com.xl.ye.bean.NolSysDate;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xl.ye.bean.NolSysParam;
import com.xl.ye.logs.LogManager;
import com.xl.ye.service.NolSysParamService;

@RestController
@RequestMapping(path="/")
public class HelloController {
	
	@Autowired
	private NolSysParamService nolSysParamService;

	@Autowired
	private NolSysDateService nolSysDateService;
	
	@Autowired
	private LogManager logManager;

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	JobLocator jobLocator;
	private Logger log = LoggerFactory.getLogger(HelloController.class);


	@Transactional
	@RequestMapping(path="hello", method=RequestMethod.GET)
	public NolSysParam hello() {
		
		logManager.MY_LOGGER.info("hello controller  !");
		log.info("logfactory .... -----");
		List<NolSysParam> params = nolSysParamService.load("nol");

		return params.get(0);
		
		
	}

	@RequestMapping(path="runJob", method=RequestMethod.GET)
	public String runJob() throws NoSuchJobException, JobParametersInvalidException,
			JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException {

		logManager.MY_LOGGER.info("start job  controller  !");

		Job job = jobLocator.getJob("xxx");
		JobParameters params = new JobParametersBuilder().addString("file","jiss1ns")
					.toJobParameters();

		JobExecution je = jobLauncher.run(job, params);
		return je.getJobInstance().getInstanceId() + "";


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
