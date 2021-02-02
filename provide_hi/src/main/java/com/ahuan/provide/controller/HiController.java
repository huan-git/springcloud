package com.ahuan.provide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description: TODO this is the description of the HiController class
 * @author: ahuan
 * @version: 2021-01-08 17:47
 **/
@RestController
//@RequestMapping("/hi")
public class HiController {

    @Value("${server.port}")
    private  Integer port;

    @Value("${spring.application.name}")
    private  String appName;

    @GetMapping("/hello/{name}")
    public  String hi(@PathVariable String name){
        return "hello "+name+", I am "+appName+":"+port+"server,Nice to meet to you ";
    }
}