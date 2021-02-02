package com.ahuan.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 单点登录服务
 * @author huan
 */
@EnableEurekaClient
@SpringBootApplication
public class SecurityOauth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityOauth2ServerApplication.class, args);
    }

}
