package com.ahuan.miaosha.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
* Created by Mybatis Generator on 2020/04/07
*/
@ApiModel(value="com.example.miaosha.model.TOrder")
@Data
public class TOrder implements Serializable {
    /**
     * 
     */
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 
     */
    @ApiModelProperty(value="orderName")
    private String orderName;

    /**
     * 
     */
    @ApiModelProperty(value="orderUser")
    private String orderUser;

    private static final long serialVersionUID = 1L;
}