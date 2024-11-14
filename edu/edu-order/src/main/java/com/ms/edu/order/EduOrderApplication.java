package com.ms.edu.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ms.edu.order.mapper")
public class EduOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduOrderApplication.class, args);
    }

}
