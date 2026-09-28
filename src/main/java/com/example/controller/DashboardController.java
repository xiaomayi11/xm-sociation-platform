package com.example.controller;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.example.common.Result;
import com.example.entity.*;
import com.example.service.*;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Resource
    private ArticleService articleService;
    @Resource
    private NewsService newsService;
    @Resource
    private ActivityService activityService;
    @Resource
    private UserService userService;
    @Resource
    private DynamicService dynamicService;
    @Resource
    private ArticleTypeService articleTypeService;
    @Resource
    private ActivityTypeService activityTypeService;
    @Resource
    private ApplyService applyService;
    @Resource
    private CertificationService certificationService;


    @GetMapping("/base")
    public Result base() {
        Map<String, Object> map = new HashMap<>();
        map.put("articleNum", articleService.selectAll(new Article()).stream().filter(x -> "审核通过".equals(x.getStatus())).count());
        map.put("newsNum", newsService.selectAll(new News()).size());
        map.put("activityNum", activityService.selectAll(new Activity()).size());
        map.put("userNum", userService.selectAll(new User()).size());
        map.put("pendingArticleNum", articleService.selectAll(new Article()).stream().filter(x -> "待审核".equals(x.getStatus())).count());
        map.put("pendingApplyNum", applyService.selectAll(new Apply()).stream().filter(x -> "待审核".equals(x.getStatus())).count());
        map.put("certificationNum", certificationService.selectAll(new Certification()).size());
        return Result.success(map);
    }

    @GetMapping("/line")
    public Result line() {
        Map<String, Object> map = new HashMap<>();
        // 获取最近7天的数据（年-月-日）放在xList里
        Date today = new Date();
        DateTime start = DateUtil.offsetDay(today, -7);
        List<String> xList = DateUtil.rangeToList(start, today, DateField.DAY_OF_YEAR).stream().map(DateUtil::formatDate).toList();

        List<Long> yList = new ArrayList<>();
        List<Dynamic> dynamics = dynamicService.selectAll(new Dynamic());
        for (String day : xList) {
            long count = dynamics.stream().filter(x -> x.getTime().contains(day)).count();
            yList.add(count);
        }
        map.put("x", xList);
        map.put("y", yList);
        return Result.success(map);
    }

    @GetMapping("/pie1")
    public Result pie1() {
        List<Map<String, Object>> list = new ArrayList<>();
        List<ArticleType> articleTypes = articleTypeService.selectAll(new ArticleType());
        List<Article> articles = articleService.selectAll(new Article()).stream().filter(x -> "审核通过".equals(x.getStatus())).collect(Collectors.toList());

        for (ArticleType articleType : articleTypes) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", articleType.getName());
            map.put("value", articles.stream().filter(x -> x.getTypeId().equals(articleType.getId())).count());
            list.add(map);
        }
        return Result.success(list);
    }

    @GetMapping("/pie2")
    public Result pie2() {
        List<Map<String, Object>> list = new ArrayList<>();
        List<ActivityType> activityTypes = activityTypeService.selectAll(new ActivityType());
        List<Activity> activities = activityService.selectAll(new Activity());

        for (ActivityType activityType : activityTypes) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", activityType.getName());
            map.put("value", activities.stream().filter(x -> x.getTypeId().equals(activityType.getId())).count());
            list.add(map);
        }
        return Result.success(list);
    }





}