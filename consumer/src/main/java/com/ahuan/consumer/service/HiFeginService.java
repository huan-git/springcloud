package com.ahuan.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springcloud
 * @description: feign远程调用
 * @author: ahuan
 * @version: 2021-01-09 17:14
 **/
@Component
@FeignClient(name = "serivce-provide-hi",path = "/hi")
public interface HiFeginService {

    /**
     * 调用服务端接口
     * @param name
     * @return
     */
    @RequestMapping("hello/{name}")
    String hello(@PathVariable String name);
}