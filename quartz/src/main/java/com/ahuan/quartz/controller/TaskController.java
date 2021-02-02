package com.ahuan.quartz.controller;

import com.ahuan.quartz.entity.QuartzEntity;
import com.ahuan.quartz.response.ResponseResult;
import com.ahuan.quartz.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/***
 *
 * @author huan
 * @date 2019/03/27
 */
@Api(description = "任务清单")
@RestController
@RequestMapping("/task")
public class TaskController {

    // private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);
    @Autowired
    private TaskService taskService;

    @ApiOperation("任务列表")
    @GetMapping("/list")
    public ResponseResult<List<Map<String, Object>>> taskList() {
        return ResponseResult.success(taskService.list());
    }

    @ApiOperation("新增任务")
    @PostMapping("/add")
    public ResponseResult<String> addTask(@RequestBody QuartzEntity quartz) {
        return taskService.createTask(quartz);
    }

    @ApiOperation("触发任务")
    @PostMapping("/trigger")
    public ResponseResult<String> trigger(@RequestBody QuartzEntity quartz) {
        return taskService.execute(quartz, "trigger");
    }

    @ApiOperation("暂停任务")
    @PostMapping("/pause")
    public ResponseResult<String> pause(@RequestBody QuartzEntity quartz) {
        return taskService.execute(quartz, "pause");
    }

    @ApiOperation("恢复任务")
    @PostMapping("/resume")
    public ResponseResult<String> resume(@RequestBody QuartzEntity quartz) {
        return taskService.execute(quartz, "resume");
    }

    @ApiOperation("删除任务")
    @PostMapping("/remove")
    public ResponseResult<String> remove(@RequestBody QuartzEntity quartz) {
        return taskService.execute(quartz, "remove");
    }
}
