package com.example.controller;

import com.example.common.Result;
import com.example.entity.OperationLog;
import com.example.service.OperationLogService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operationLog")
public class OperationLogController {

    @Resource
    private OperationLogService operationLogService;

    @PostMapping("/add")
    public Result add(@RequestBody OperationLog operationLog) {
        operationLogService.add(operationLog);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody OperationLog operationLog) {
        operationLogService.updateById(operationLog);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        operationLogService.deleteById(id);
        return Result.success();
    }

    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        operationLogService.deleteBatch(ids);
        return Result.success();
    }

    @GetMapping("/selectAll")
    public Result selectAll(OperationLog operationLog) {
        return Result.success(operationLogService.selectAll(operationLog));
    }

    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             OperationLog operationLog) {
        PageInfo<OperationLog> pageInfo = operationLogService.selectPage(pageNum, pageSize, operationLog);
        return Result.success(pageInfo);
    }
}