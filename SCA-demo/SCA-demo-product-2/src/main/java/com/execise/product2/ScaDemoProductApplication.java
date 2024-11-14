package com.execise.product2;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.execise.product2.mapper")
public class ScaDemoProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScaDemoProductApplication.class, args);
    }

}
