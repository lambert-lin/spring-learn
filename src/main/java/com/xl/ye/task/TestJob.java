package com.xl.ye.task;

import com.xl.ye.logs.LogManager;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



public class TestJob implements Job {

	@Autowired
	private LogManager logManagers;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println("test job start");
//		logManagers.MY_LOGGER.info("test job executing !");
		
	}

}
