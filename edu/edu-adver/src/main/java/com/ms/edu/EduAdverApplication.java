package com.ms.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ms.edu.mapper")
public class EduAdverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduAdverApplication.class, args);
	}

}
