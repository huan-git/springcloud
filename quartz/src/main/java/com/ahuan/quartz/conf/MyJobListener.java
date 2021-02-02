package com.ahuan.quartz.conf;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 *
 * @author huan
 * @date 2019/03/27
 */
public class MyJobListener implements JobListener {
    private Logger logger = LoggerFactory.getLogger(MyJobListener.class);

    @Override // 相当于为我们的监听器命名
    public String getName() {
        return "myJobListener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        logger.info("{},触发对{}的开始执行的监听工作，这里可以完成任务前的一些资源准备工作或日志记录", getName(), context.getJobDetail().getJobClass());
    }

    @Override // “否决JobDetail”是在Triiger被其相应的监听器监听时才具备的能力
    public void jobExecutionVetoed(JobExecutionContext context) {
        logger.warn("被否决执行了，可以做些日志记录。");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        logger.info("{}触发对{}结束执行的监听工作，这里可以进行资源销毁工作或做一些新闻扒取结果的统计工作", getName(), context.getJobDetail().getJobClass());

    }

}
