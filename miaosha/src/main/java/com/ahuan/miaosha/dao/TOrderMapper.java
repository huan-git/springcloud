package com.ahuan.miaosha.dao;

import com.ahuan.miaosha.model.TOrder;

/**
* Created by Mybatis Generator on 2020/04/07
*/
public interface TOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);
}