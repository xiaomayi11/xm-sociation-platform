package com.example.controller;

import com.example.common.Result;
import com.example.entity.News;
import com.example.service.NewsService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 竞赛新闻前端请求接口
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Resource
    private NewsService newsService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody News news) {
        newsService.add(news);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result update(@RequestBody News news) {
        newsService.updateById(news);
        return Result.success();
    }

    /**
     * 单个删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        newsService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        newsService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 单个查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        News news = newsService.selectById(id);
        return Result.success(news);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(News news) {
        List<News> list = newsService.selectAll(news);
        return Result.success(list);
    }

    /**
     * 查询top6
     */
    @GetMapping("/top6")
    public Result top6() {
        List<News> list = newsService.top6();
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(News news,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<News> pageInfo = newsService.selectPage(news, pageNum, pageSize);
        return Result.success(pageInfo);
    }

    /**
     * 查询top10
     */
    @GetMapping("/top10")
    public Result top10() {
        List<News> list = newsService.top10();
        return Result.success(list);
    }

    /**
     * 按分类统计篇数
     */
    @GetMapping("/countByCategory")
    public Result countByCategory() {
        List<Map<String, Object>> list = newsService.countByCategory();
        return Result.success(list);
    }

}