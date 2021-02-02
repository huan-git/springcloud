package com.ahuan.test.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.ahuan.test.service.PmsProductService;
import com.ahuan.test.dao.PmsProductMapper;

/***
 *@author Created by Mybatis Generator on 2021/01/25
 */
@Service
public class PmsProductServiceImpl implements PmsProductService {

    @Resource
    private PmsProductMapper pmsProductMapper;

}