package com.ahuan.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahuan.test.service.PmsProductService;

/***
 *@author Created by Mybatis Generator on 2021/01/25
 */
@RestController
@RequestMapping("/pmsProduct")
public class PmsProductController {

    @Autowired
    private PmsProductService pmsProductService;

}