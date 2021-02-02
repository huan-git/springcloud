package com.ahuan.quartz.job;

import com.ahuan.quartz.service.GoodInfoService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
public class GoodAddJob extends MyJob {
    static Logger logger = LoggerFactory.getLogger(GoodAddJob.class);
    @Autowired
    private GoodInfoService goodInfoService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("执行商品添加任务，任务时间：{}", new Date());
    }

}
