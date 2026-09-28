package com.example.controller;

import com.example.common.Result;
import com.example.entity.Follows;
import com.example.service.FollowsService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 关注取关前端请求接口
 */
@RestController
@RequestMapping("/follows")
public class FollowsController {

    @Resource
    private FollowsService followsService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Follows follows) {
        followsService.add(follows);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result update(@RequestBody Follows follows) {
        followsService.updateById(follows);
        return Result.success();
    }

    /**
     * 单个删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        followsService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        followsService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 单个查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Follows follows = followsService.selectById(id);
        return Result.success(follows);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Follows follows) {
        List<Follows> list = followsService.selectAll(follows);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Follows follows,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Follows> pageInfo = followsService.selectPage(follows, pageNum, pageSize);
        return Result.success(pageInfo);
    }

}
