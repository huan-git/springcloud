package com.ahuan.quartz.controller;

import com.ahuan.quartz.entity.GoodInfoEntity;
import com.ahuan.quartz.service.GoodInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @author huan
 * @date 2019/03/27
 */
@Api(description = "商品管理")
@RestController
@RequestMapping(value = "/good")
public class GoodController {
    /**
     * 商品业务逻辑实现
     */
    @Autowired
    private GoodInfoService goodInfoService;

    /**
     * 添加商品
     *
     * @return
     */

    @ApiOperation("save")
    @RequestMapping(value = "/save")
    public Integer save(GoodInfoEntity good) throws Exception {
        return goodInfoService.saveGood(good);
    }
}