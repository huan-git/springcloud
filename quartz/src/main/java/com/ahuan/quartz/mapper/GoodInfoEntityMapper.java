package com.ahuan.quartz.mapper;


import com.ahuan.quartz.entity.GoodInfoEntity;

import java.util.List;

public interface GoodInfoEntityMapper {
    int deleteByPrimaryKey(Integer bgiId);

    int insert(GoodInfoEntity record);

    GoodInfoEntity selectByPrimaryKey(Integer bgiId);

    List<GoodInfoEntity> selectAll();

    int updateByPrimaryKey(GoodInfoEntity record);
}