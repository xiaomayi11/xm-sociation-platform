package com.example.controller;

import com.example.common.Result;
import com.example.entity.Dynamic;
import com.example.service.DynamicService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户动态前端请求接口
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicController {

    @Resource
    private DynamicService dynamicService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Dynamic dynamic) {
        dynamicService.add(dynamic);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result update(@RequestBody Dynamic dynamic) {
        dynamicService.updateById(dynamic);
        return Result.success();
    }

    /**
     * 单个删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        dynamicService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        dynamicService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 单个查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Dynamic dynamic = dynamicService.selectById(id);
        return Result.success(dynamic);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Dynamic dynamic) {
        List<Dynamic> list = dynamicService.selectAll(dynamic);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Dynamic dynamic,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Dynamic> pageInfo = dynamicService.selectPage(dynamic, pageNum, pageSize);
        return Result.success(pageInfo);
    }

}
