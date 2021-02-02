package com.ahuan.test.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/***
 * @author  Created by Mybatis Generator on 2021/01/14
 */
@ApiModel(value="com.ahuan.testng.model.PmsBrand")
@Data
public class PmsBrand implements Serializable {
    /**
     * 
     */
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 
     */
    @ApiModelProperty(value="name")
    private String name;

    /**
     * 首字母
     */
    @ApiModelProperty(value="首字母")
    private String firstLetter;

    /**
     * 
     */
    @ApiModelProperty(value="sort")
    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    @ApiModelProperty(value="是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;

    /**
     * 
     */
    @ApiModelProperty(value="showStatus")
    private Integer showStatus;

    /**
     * 产品数量
     */
    @ApiModelProperty(value="产品数量")
    private Integer productCount;

    /**
     * 产品评论数量
     */
    @ApiModelProperty(value="产品评论数量")
    private Integer productCommentCount;

    /**
     * 品牌logo
     */
    @ApiModelProperty(value="品牌logo")
    private String logo;

    /**
     * 专区大图
     */
    @ApiModelProperty(value="专区大图")
    private String bigPic;

    /**
     * 品牌故事
     */
    @ApiModelProperty(value="品牌故事")
    private String brandStory;

    private static final long serialVersionUID = 1L;
}