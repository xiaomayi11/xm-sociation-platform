package com.example.controller;

import com.example.common.Result;
import com.example.entity.ActivityType;
import com.example.service.ActivityTypeService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 竞赛分类前端请求接口
 */
@RestController
@RequestMapping("/activityType")
public class ActivityTypeController {

    @Resource
    private ActivityTypeService activityTypeService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody ActivityType activityType) {
        activityTypeService.add(activityType);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result update(@RequestBody ActivityType activityType) {
        activityTypeService.updateById(activityType);
        return Result.success();
    }

    /**
     * 单个删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        activityTypeService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        activityTypeService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 单个查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        ActivityType activityType = activityTypeService.selectById(id);
        return Result.success(activityType);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(ActivityType activityType) {
        List<ActivityType> list = activityTypeService.selectAll(activityType);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(ActivityType activityType,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<ActivityType> pageInfo = activityTypeService.selectPage(activityType, pageNum, pageSize);
        return Result.success(pageInfo);
    }

}
