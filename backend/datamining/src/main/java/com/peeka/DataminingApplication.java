package com.peeka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.peeka.mapper")
public class DataminingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataminingApplication.class, args);
    }

}
