package com.execise.demo.scademopage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients   // 开启Feign
public class ScaDemoPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScaDemoPageApplication.class, args);
    }

}
