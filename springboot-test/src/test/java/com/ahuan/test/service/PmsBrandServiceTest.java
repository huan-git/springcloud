package com.ahuan.test.service;

import com.ahuan.test.model.PmsBrand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsBrandServiceTest  {
    @Autowired
    PmsBrandService pmsBrandService;

    @Test
    public void details() {
        PmsBrand details = pmsBrandService.details(2L);
        System.out.println(details);
    }

    @Test
    public void testDetails() {
    }

    @Test
    public void update() {
        PmsBrand pmsBrand=new PmsBrand();
        pmsBrand.setId(2L);
        pmsBrand.setProductCount(2000);
        String res = pmsBrandService.update(pmsBrand);
        Assert.assertTrue(res.contains("successed"));
    }
}