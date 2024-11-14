package com.execise.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.execise.demo.common.mapper")
public class ScaDemoUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScaDemoUserApplication.class, args);
    }

}
