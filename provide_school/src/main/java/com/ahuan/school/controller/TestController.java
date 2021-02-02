package com.ahuan.school.controller;

import com.ahuan.common.entity.School;
import com.ahuan.common.response.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @program: springcloud
 * @description: TODO this is the description of the TestController class
 * @author: ahuan
 * @version: 2021-01-09 18:19
 **/
@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET ,produces = {"application/json;charset=UTF-8"})
    public Result<School> test(){
        School school=new School();
        school.setAddr("河南省郑州市高新区");
        school.setName("郑州市一中");
        school.setTel("0371-666888");
        return Result.ok(school);
    }
}