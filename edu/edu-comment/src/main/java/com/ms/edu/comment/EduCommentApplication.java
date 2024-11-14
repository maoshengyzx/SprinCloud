package com.ms.edu.comment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.ms.edu.comment.mapper")
@EnableTransactionManagement
public class EduCommentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduCommentApplication.class, args);
	}

}
