package com.ahuan.test.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.ahuan.test.service.PmsProductAttributeService;
import com.ahuan.test.dao.PmsProductAttributeMapper;

/***
 *@author Created by Mybatis Generator on 2021/01/25
 */
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {

    @Resource
    private PmsProductAttributeMapper pmsProductAttributeMapper;

}