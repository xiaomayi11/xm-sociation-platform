package com.example.controller;

import com.example.common.Result;
import com.example.entity.Competition;
import com.example.service.CompetitionService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competition")
public class CompetitionController {

    @Resource
    private CompetitionService competitionService;

    @PostMapping("/add")
    public Result add(@RequestBody Competition competition) {
        competitionService.add(competition);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Competition competition) {
        competitionService.updateById(competition);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        competitionService.deleteById(id);
        return Result.success();
    }

    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        competitionService.deleteBatch(ids);
        return Result.success();
    }

    @GetMapping("/selectAll")
    public Result selectAll(Competition competition) {
        return Result.success(competitionService.selectAll(competition));
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        return Result.success(competitionService.selectById(id));
    }

    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             Competition competition) {
        PageInfo<Competition> pageInfo = competitionService.selectPage(pageNum, pageSize, competition);
        return Result.success(pageInfo);
    }

    @GetMapping("/selectRegistering")
    public Result selectRegistering() {
        return Result.success(competitionService.selectRegistering());
    }
}