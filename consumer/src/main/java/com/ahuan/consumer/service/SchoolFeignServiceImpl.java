package com.ahuan.consumer.service;

import com.ahuan.common.entity.School;
import com.ahuan.common.response.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud
 * @description: TODO this is the description of the SchoolFeignServiceImpl class
 * @author: ahuan
 * @version: 2021-01-09 19:29
 **/
@Component
public class SchoolFeignServiceImpl implements FallbackFactory<SchoolFeignService> {


    public Result<School> fallback() {
        School school=new School();
        school.setTel("0000");
        school.setName("0000");
        school.setAddr("0000");
        return Result.ok(school);
    }

    @Override
    public SchoolFeignService create(Throwable cause) {
        cause.printStackTrace();
        return ()->{
           return fallback();
        };
    }
}