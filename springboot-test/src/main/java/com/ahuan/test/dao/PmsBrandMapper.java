package com.ahuan.test.dao;

import com.ahuan.test.model.PmsBrand;

/**
 * @author  Created by Mybatis Generator on 2021/01/14
 */
public interface PmsBrandMapper {
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
    int insert(PmsBrand record);

    /**
     * 选择性新增
     * @param record
     * @return int
     */
    int insertSelective(PmsBrand record);

    /**
     * 根据主键查询
     * @param id
     * @return PmsBrand
     */
    PmsBrand selectByPrimaryKey(Long id);

    /**
     * 根据主键选择更新
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(PmsBrand record);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(PmsBrand record);

    /**
     * 根据主键更新
     * @param record
     * @return int
     */
    int updateByPrimaryKey(PmsBrand record);
}