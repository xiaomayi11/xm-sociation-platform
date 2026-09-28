package com.example.controller;

import com.example.common.Result;
import com.example.entity.ArticleType;
import com.example.service.ArticleTypeService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 帖子分类前端请求接口
 */
@RestController
@RequestMapping("/articleType")
public class ArticleTypeController {

    @Resource
    private ArticleTypeService articleTypeService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody ArticleType articleType) {
        articleTypeService.add(articleType);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result update(@RequestBody ArticleType articleType) {
        articleTypeService.updateById(articleType);
        return Result.success();
    }

    /**
     * 单个删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        articleTypeService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        articleTypeService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 单个查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        ArticleType articleType = articleTypeService.selectById(id);
        return Result.success(articleType);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(ArticleType articleType) {
        List<ArticleType> list = articleTypeService.selectAll(articleType);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(ArticleType articleType,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<ArticleType> pageInfo = articleTypeService.selectPage(articleType, pageNum, pageSize);
        return Result.success(pageInfo);
    }

}
