package com.xl.ye.logs;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogManager {
	
	public Logger MY_LOGGER;
	
	@PostConstruct
	public void initLogger() {

		System.out.println("++++++++++++++++++++"+ "log init ");
		
		this.MY_LOGGER = LoggerFactory.getLogger("My.Log");
		
	}

}
