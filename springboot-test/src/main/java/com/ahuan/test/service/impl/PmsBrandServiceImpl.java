package com.ahuan.test.service.impl;

import javax.annotation.Resource;

import com.ahuan.test.model.PmsBrand;
import org.springframework.stereotype.Service;

import com.ahuan.test.service.PmsBrandService;
import com.ahuan.test.dao.PmsBrandMapper;

/***
 *@author Created by Mybatis Generator on 2021/01/14
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Resource
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public PmsBrand details(Long id) {
       return pmsBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public String update(PmsBrand pmsBrand) {
        pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
        return "successed";
    }
}