package com.ahuan.test.service;

import com.ahuan.test.model.PmsBrand;

/***
 *@author Created by Mybatis Generator on on 2021/01/14
 */
public interface PmsBrandService {

    PmsBrand details(Long id);

    String update(PmsBrand pmsBrand);
}