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
@ApiModel(value="com.example.miaosha.model.TStock")
@Data
public class TStock implements Serializable {
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
     * 
     */
    @ApiModelProperty(value="stock")
    private Long stock;

    private static final long serialVersionUID = 1L;
}