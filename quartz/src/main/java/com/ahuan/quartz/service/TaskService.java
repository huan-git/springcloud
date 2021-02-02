package com.ahuan.quartz.service;


import com.ahuan.quartz.entity.QuartzEntity;
import com.ahuan.quartz.response.ResponseResult;

import java.util.List;
import java.util.Map;

public interface TaskService {
    /***
     * 任务list
     */
    public List<Map<String, Object>> list();

    public ResponseResult<String> createTask(QuartzEntity quartz);

    public ResponseResult<String> execute(QuartzEntity quartz, String methed);
}
