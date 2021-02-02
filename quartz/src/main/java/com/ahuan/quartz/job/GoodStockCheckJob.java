package com.ahuan.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class GoodStockCheckJob extends MyJob {
    static Logger logger = LoggerFactory.getLogger(GoodStockCheckJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("执行库存检查定时任务，执行时间：{}", new Date());

    }

}
