package com.ahuan.quartz.service;

import com.ahuan.quartz.entity.GoodInfoEntity;
import com.ahuan.quartz.entity.QuartzEntity;
import com.ahuan.quartz.job.GoodStockCheckJob;
import com.ahuan.quartz.mapper.GoodInfoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class GoodInfoService {

    @Autowired
    TaskService taskService;
    /**
     * 商品数据接口
     */
    @Autowired
    private GoodInfoEntityMapper goodInfoEntityMapper;

    /**
     * 保存商品基本信息
     *
     * @param good 商品实例
     * @return
     */
    public Integer saveGood(GoodInfoEntity good) throws Exception {
        int insert = goodInfoEntityMapper.insert(good);

        QuartzEntity quartz = new QuartzEntity();
        // 设置开始时间为1分钟后
        long startAtTime = System.currentTimeMillis() + 1000 * 60;
        // 任务名称
        String name = UUID.randomUUID().toString();
        // 任务分组
        String group = GoodStockCheckJob.class.getSimpleName();
        quartz.setJobClassName("com.example.quartz.job.GoodStockCheckJob");
        quartz.setJobName(name);
        quartz.setJobGroup(group);
        quartz.setTriggerStartTime(new Date(startAtTime));
        taskService.createTask(quartz);

        return good.getBgiId();
    }
}