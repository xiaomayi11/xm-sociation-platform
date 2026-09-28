package com.example.controller;

import com.example.common.Result;
import com.example.entity.Praise;
import com.example.service.PraiseService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 点赞信息前端请求接口
 */
@RestController
@RequestMapping("/praise")
public class PraiseController {

    @Resource
    private PraiseService praiseService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Praise praise) {
        praiseService.add(praise);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result update(@RequestBody Praise praise) {
        praiseService.updateById(praise);
        return Result.success();
    }

    /**
     * 单个删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        praiseService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        praiseService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 单个查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Praise praise = praiseService.selectById(id);
        return Result.success(praise);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Praise praise) {
        List<Praise> list = praiseService.selectAll(praise);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Praise praise,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Praise> pageInfo = praiseService.selectPage(praise, pageNum, pageSize);
        return Result.success(pageInfo);
    }

}
