package com.ahuan.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud
 * @description: 通过RestTemplate 进行远程服务调用
 * @author: ahuan
 * @version: 2021-01-08 18:02
 **/
@Service
public class HiService {

    @Autowired
    RestTemplate restTemplate;

    public String hello(){
        String hello = restTemplate.getForObject("http://SERIVCE-PROVIDE-HI/hi/hello/restTemplate", String.class);
        System.out.println(hello);
        return hello;
    }
}