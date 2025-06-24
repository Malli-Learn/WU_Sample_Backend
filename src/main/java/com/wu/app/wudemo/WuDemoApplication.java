package com.wu.app.wudemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WuDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(WuDemoApplication.class, args);
    }

}
