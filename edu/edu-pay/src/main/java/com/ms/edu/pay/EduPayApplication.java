package com.ms.edu.pay;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ms.edu.pay.mapper")
@EnableAutoDataSourceProxy
public class EduPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduPayApplication.class, args);
    }

}
