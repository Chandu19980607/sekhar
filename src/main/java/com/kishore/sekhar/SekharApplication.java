package com.kishore.sekhar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SekharApplication {

	public static final Logger logger=LogManager.getLogger(SekharApplication.class);	
			public static void main(String[] args) {
		SpringApplication.run(SekharApplication.class, args);
		  // loggers are asynchronous
		logger.info("This is Information Method");   // this logger is used in production level ex:transaction (production logs/general logs)
		logger.debug("debug level");    // these loggers are called debug loggers  (developer logs)
		logger.warn("warn level");   // if(time<20000) to warn for transactions  (warning logger)
		logger.error("error level");  // to print the failures/problems
		logger.fatal("fatal level");  // server down/ database down/ memory leaks-system related issues we use this
	}

}
