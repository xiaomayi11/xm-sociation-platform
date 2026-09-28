package com.example.controller;

import com.example.common.Result;
import com.example.entity.SystemConfig;
import com.example.service.SystemConfigService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systemConfig")
public class SystemConfigController {

    @Resource
    private SystemConfigService systemConfigService;

    @PostMapping("/add")
    public Result add(@RequestBody SystemConfig systemConfig) {
        systemConfigService.add(systemConfig);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody SystemConfig systemConfig) {
        systemConfigService.updateById(systemConfig);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        systemConfigService.deleteById(id);
        return Result.success();
    }

    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        systemConfigService.deleteBatch(ids);
        return Result.success();
    }

    @GetMapping("/selectAll")
    public Result selectAll(SystemConfig systemConfig) {
        return Result.success(systemConfigService.selectAll(systemConfig));
    }

    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             SystemConfig systemConfig) {
        PageInfo<SystemConfig> pageInfo = systemConfigService.selectPage(pageNum, pageSize, systemConfig);
        return Result.success(pageInfo);
    }
}