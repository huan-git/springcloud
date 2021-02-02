package com.ahuan.consumer.controller;

import com.ahuan.common.entity.School;
import com.ahuan.common.response.Result;
import com.ahuan.consumer.service.HiFeginService;
import com.ahuan.consumer.service.HiService;
import com.ahuan.consumer.service.SchoolFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud
 * @description: TODO this is the description of the HiController class
 * @author: ahuan
 * @version: 2021-01-08 18:00
 **/
@RestController
public class HiController {

    @Autowired
    HiService hiService;

    @Autowired
    HiFeginService hiFeginService;

    @Autowired
    SchoolFeignService schoolFeignService;

    @GetMapping("/hi")
    public String hello(){
        return hiService.hello();
    }

    @GetMapping("/feign/test/{name}")
    public  String feigntest(@PathVariable String name){
        return hiFeginService.hello(name);
    }

    @GetMapping(value = "/school",produces = {"application/json;charset=UTF-8"})
    public Result<School> school(){
        Result<School> test = schoolFeignService.test();
        return test;
    }
}
