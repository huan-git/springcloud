package com.ahuan.test.dao;

import com.ahuan.test.model.PmsProductAttribute;

/**
 * @author  Created by Mybatis Generator on 2021/01/25
 */
public interface PmsProductAttributeMapper {
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
    int insert(PmsProductAttribute record);

    /**
     * 选择性新增
     * @param record
     * @return int
     */
    int insertSelective(PmsProductAttribute record);

    /**
     * 根据主键查询
     * @param id
     * @return PmsProductAttribute
     */
    PmsProductAttribute selectByPrimaryKey(Long id);

    /**
     * 根据主键选择更新
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(PmsProductAttribute record);

    /**
     * 根据主键更新
     * @param record
     * @return int
     */
    int updateByPrimaryKey(PmsProductAttribute record);
}