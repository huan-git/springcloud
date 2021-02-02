package com.ahuan.quartz.service.impl;

import com.ahuan.quartz.entity.QuartzEntity;
import com.ahuan.quartz.response.ResponseResult;
import com.ahuan.quartz.service.TaskService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
    private Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private Scheduler scheduler;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Cacheable(value = "task:list")
    @Override
    public List<Map<String, Object>> list() {
        System.out.println("111111111111");
        String sql =
                " SELECT job.JOB_NAME as jobName,job.JOB_GROUP as jobGroup,job.DESCRIPTION as description,job.JOB_CLASS_NAME as jobClassName, "
                        + " cron.CRON_EXPRESSION as cronExpression,tri.TRIGGER_NAME as triggerName,tri.TRIGGER_STATE as triggerState, "
                        + " job.JOB_NAME as oldJobName,job.JOB_GROUP as oldJobGroup  "
                        + " FROM qrtz_job_details AS job LEFT JOIN qrtz_triggers AS tri ON job.JOB_NAME = tri.JOB_NAME  "
                        + " LEFT JOIN qrtz_cron_triggers AS cron ON cron.TRIGGER_NAME = tri.TRIGGER_NAME  "
                        + " WHERE tri.TRIGGER_TYPE = 'CRON'";
        System.out.println("22222222222");
        return jdbcTemplate.queryForList(sql);

    }

    @Override
    public ResponseResult<String> createTask(QuartzEntity quartz) {
        Class cls = null;
        try {
            cls = Class.forName(quartz.getJobClassName());
            cls.newInstance();

            JobDetail jobDetail = JobBuilder.newJob(cls).withIdentity(quartz.getJobName(), quartz.getJobGroup())
                    .withDescription(quartz.getDescription()).build();
            // 写入元数据;
            if (quartz.getJobDataMap().size() > 0) {
                jobDetail.getJobDataMap().putAll(quartz.getJobDataMap());
            }
            TriggerBuilder<Trigger> triggerBuilder =
                    TriggerBuilder.newTrigger().withIdentity(quartz.getJobName(), quartz.getJobGroup());
            if (!StringUtils.isEmpty(quartz.getCronExpression())) {
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(quartz.getCronExpression()));
            }
            if (quartz.getTriggerStartTime() != null) {
                triggerBuilder.startAt(quartz.getTriggerStartTime());
            }
            // 如果 cronExpression triggerStartTime都为空;
            if (quartz.getTriggerStartTime() == null && StringUtils.isEmpty(quartz.getCronExpression())) {
                triggerBuilder.startAt(new Date());
            }
            Trigger trigger = triggerBuilder.build();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SchedulerException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
            logger.error("{} 任务创建失败", quartz.getJobName());
            return ResponseResult.success(e.getMessage());
        }
        logger.info("{} 任务创建成功", quartz.getJobName());
        return ResponseResult.success();
    }

    @Override
    public ResponseResult<String> execute(QuartzEntity quartz, String methed) {
        JobKey jobKey = JobKey.jobKey(quartz.getJobName(), quartz.getJobGroup());
        try {
            if ("trigger".equals(methed)) {
                scheduler.triggerJob(jobKey);
                logger.info("触发任务{}", quartz.getJobName());
            }
            if ("pause".equals(methed)) {
                scheduler.pauseJob(jobKey);
                logger.info("停止任务{}", quartz.getJobName());
            }
            if ("resume".equals(methed)) {
                scheduler.resumeJob(jobKey);
                logger.info("恢复任务{}", quartz.getJobName());
            }
            if ("remove".equals(methed)) {
                TriggerKey triggerKey = TriggerKey.triggerKey(quartz.getJobName(), quartz.getJobGroup());
                // 停止触发器
                scheduler.pauseTrigger(triggerKey);
                // 移除触发器
                scheduler.unscheduleJob(triggerKey);
                // 删除Job
                scheduler.deleteJob(jobKey);
                logger.info("删除任务{}", quartz.getJobName());
            }

        } catch (SchedulerException e) {
            e.printStackTrace();
            return ResponseResult.success(e.getMessage());

        }
        return ResponseResult.success();

    }

}
