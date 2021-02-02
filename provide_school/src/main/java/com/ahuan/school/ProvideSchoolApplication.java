package com.ahuan.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 这是一个学校服务商
 * @author huan
 */
@EnableEurekaClient
@SpringBootApplication
public class ProvideSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvideSchoolApplication.class, args);
    }

}
