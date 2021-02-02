package com.ahuan.test.controller;

import com.ahuan.common.response.Result;
import com.ahuan.test.model.PmsBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ahuan.test.service.PmsBrandService;

/***
 *@author Created by Mybatis Generator on 2021/01/14
 */
@RestController
@RequestMapping("/pmsBrand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    @GetMapping(value = "/details/{id}", produces = "application/json")
    public Result<PmsBrand> details(@PathVariable Long id) {
        PmsBrand pmsBrand = pmsBrandService.details(id);
        return Result.ok(pmsBrand);
    }

    @PostMapping(value = "/update", produces = "application/json")
    public Result<String> update(@RequestBody PmsBrand pmsBrand) {
        String update = pmsBrandService.update(pmsBrand);
        return Result.ok(update);
    }

}