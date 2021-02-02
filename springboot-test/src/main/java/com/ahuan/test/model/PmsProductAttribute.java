package com.ahuan.test.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/***
 * @author  Created by Mybatis Generator on 2021/01/25
 */
@ApiModel(value="com.ahuan.test.model.PmsProductAttribute")
@Data
public class PmsProductAttribute implements Serializable {
    /**
     * 
     */
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 
     */
    @ApiModelProperty(value="productAttributeCategoryId")
    private Long productAttributeCategoryId;

    /**
     * 
     */
    @ApiModelProperty(value="name")
    private String name;

    /**
     * 属性选择类型：0->唯一；1->单选；2->多选
     */
    @ApiModelProperty(value="属性选择类型：0->唯一；1->单选；2->多选")
    private Integer selectType;

    /**
     * 属性录入方式：0->手工录入；1->从列表中选取
     */
    @ApiModelProperty(value="属性录入方式：0->手工录入；1->从列表中选取")
    private Integer inputType;

    /**
     * 可选值列表，以逗号隔开
     */
    @ApiModelProperty(value="可选值列表，以逗号隔开")
    private String inputList;

    /**
     * 排序字段：最高的可以单独上传图片
     */
    @ApiModelProperty(value="排序字段：最高的可以单独上传图片")
    private Integer sort;

    /**
     * 分类筛选样式：1->普通；1->颜色
     */
    @ApiModelProperty(value="分类筛选样式：1->普通；1->颜色")
    private Integer filterType;

    /**
     * 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
     */
    @ApiModelProperty(value="检索类型；0->不需要进行检索；1->关键字检索；2->范围检索")
    private Integer searchType;

    /**
     * 相同属性产品是否关联；0->不关联；1->关联
     */
    @ApiModelProperty(value="相同属性产品是否关联；0->不关联；1->关联")
    private Integer relatedStatus;

    /**
     * 是否支持手动新增；0->不支持；1->支持
     */
    @ApiModelProperty(value="是否支持手动新增；0->不支持；1->支持")
    private Integer handAddStatus;

    /**
     * 属性的类型；0->规格；1->参数
     */
    @ApiModelProperty(value="属性的类型；0->规格；1->参数")
    private Integer type;

    private static final long serialVersionUID = 1L;
}