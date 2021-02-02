package com.ahuan.test.dao;

import com.ahuan.test.model.PmsProduct;
import com.ahuan.test.model.PmsProductWithBLOBs;

/**
 * @author  Created by Mybatis Generator on 2021/01/25
 */
public interface PmsProductMapper {
    /**
     * 根据主键删除
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增
     * @param record
     * @return int
     */
    int insert(PmsProductWithBLOBs record);

    /**
     * 选择性新增
     * @param record
     * @return int
     */
    int insertSelective(PmsProductWithBLOBs record);

    /**
     * 根据主键查询
     * @param id
     * @return PmsProductWithBLOBs
     */
    PmsProductWithBLOBs selectByPrimaryKey(Long id);

    /**
     * 根据主键选择更新
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(PmsProductWithBLOBs record);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(PmsProductWithBLOBs record);

    /**
     * 根据主键更新
     * @param record
     * @return int
     */
    int updateByPrimaryKey(PmsProduct record);
}