package com.ahuan.miaosha.dao;

import com.ahuan.miaosha.model.TStock;

import java.util.List;

/**
* Created by Mybatis Generator on 2020/04/07
*/
public interface TStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TStock record);

    int insertSelective(TStock record);

    TStock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TStock record);

    int updateByPrimaryKey(TStock record);

    List<TStock> selectByStockName(String name);
}