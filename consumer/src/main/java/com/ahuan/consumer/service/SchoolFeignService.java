package com.ahuan.consumer.service;

import com.ahuan.common.entity.School;
import com.ahuan.common.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springcloud
 * @description: TODO this is the description of the SchoolFeignService interface
 * @author: ahuan
 * @version: 2021-01-09 18:25
 **/
@Component
@FeignClient(name = "service-school",path = "/school",fallbackFactory = SchoolFeignServiceImpl.class)
public interface SchoolFeignService {
    @RequestMapping("/test")
    Result<School> test();
}
