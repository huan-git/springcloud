package com.ahuan.test.controller;

import com.ahuan.test.BaseTest;
import com.ahuan.test.model.PmsBrand;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.transaction.annotation.Transactional;

public class PmsBrandControllerTest extends BaseTest {

    @Test()
    public void testDetails() {
        String res = test("/pmsBrand/details/2", "", HttpMethod.GET);
        Assert.assertTrue(isSuccess(res));
    }

//    @Transactional
    @Test
    public void update() {
        PmsBrand pmsBrand=new PmsBrand();
        pmsBrand.setId(2L);
        pmsBrand.setProductCount(1000000000);
        String res = test("/pmsBrand/update", JSONObject.toJSONString(pmsBrand), HttpMethod.POST);
        Assert.assertTrue(isSuccess(res));
    }

    @Override
    protected void mockBehave() {

    }

}