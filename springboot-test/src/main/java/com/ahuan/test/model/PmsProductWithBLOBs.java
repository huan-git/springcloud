package com.ahuan.test.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="com.ahuan.test.model.PmsProductWithBLOBs")
public class PmsProductWithBLOBs extends PmsProduct implements Serializable {
    /**
     * 商品描述
     */
    @ApiModelProperty(value="商品描述")
    private String description;

    /**
     * 
     */
    @ApiModelProperty(value="detailDesc")
    private String detailDesc;

    /**
     * 产品详情网页内容
     */
    @ApiModelProperty(value="产品详情网页内容")
    private String detailHtml;

    /**
     * 移动端网页详情
     */
    @ApiModelProperty(value="移动端网页详情")
    private String detailMobileHtml;

    private static final long serialVersionUID = 1L;
}