package com.ms.edu.course;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ms.edu.course.mapper")
@EnableAutoDataSourceProxy
public class EduCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduCourseApplication.class, args);
    }

}
