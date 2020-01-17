package com.gg3083.jenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JenkinsTestApplication {

    public static void main(String[] args) {
        System.err.println("启动完成");
        SpringApplication.run(JenkinsTestApplication.class, args);
    }

}
