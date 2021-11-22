package com.example.hospital;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalMgmtApplication {
	private static final Logger LOGGER= (Logger) LoggerFactory.getLogger(HospitalMgmtApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(HospitalMgmtApplication.class, args);

		LOGGER.info("Welcome to hospital management");
		LOGGER.info("Appointment saved successfully");
		LOGGER.info("Appointment updated successfully");
		LOGGER.info("disease saved successfully");
		LOGGER.info("doctor updated successfully");
		LOGGER.info("doctor saved successfully");
		LOGGER.info("patient saved successfully");
		LOGGER.info("patient deleted successfully");

	}

}
