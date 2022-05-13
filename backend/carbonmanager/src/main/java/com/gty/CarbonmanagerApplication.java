package com.gty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gty.mapper")
public class CarbonmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarbonmanagerApplication.class, args);
	}

}
