package com.sb.gestoradb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sb.gestoradb.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	private DBService dbService;
	
	public void generateDataBase() {
		this.dbService.generateDataBase();
	}
}
