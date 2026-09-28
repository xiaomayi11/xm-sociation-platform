package com.example.controller;

import com.example.common.Result;
import com.example.entity.Notification;
import com.example.service.NotificationService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Resource
    private NotificationService notificationService;

    @PostMapping("/add")
    public Result add(@RequestBody Notification notification) {
        notificationService.add(notification);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Notification notification) {
        notificationService.updateById(notification);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        notificationService.deleteById(id);
        return Result.success();
    }

    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        notificationService.deleteBatch(ids);
        return Result.success();
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Notification notification = notificationService.selectById(id);
        return Result.success(notification);
    }

    @GetMapping("/selectAll")
    public Result selectAll(Notification notification) {
        List<Notification> list = notificationService.selectAll(notification);
        return Result.success(list);
    }

    @GetMapping("/selectPage")
    public Result selectPage(Notification notification,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Notification> pageInfo = notificationService.selectPage(notification, pageNum, pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/countUnread")
    public Result countUnread(@RequestParam Integer userId) {
        int count = notificationService.countUnread(userId);
        return Result.success(count);
    }

    @GetMapping("/readAll")
    public Result readAll(@RequestParam Integer userId) {
        notificationService.readAll(userId);
        return Result.success();
    }

    @GetMapping("/latestUnreadAnnouncement")
    public Result latestUnreadAnnouncement(@RequestParam Integer userId) {
        Notification notification = notificationService.selectLatestUnreadAnnouncement(userId);
        return Result.success(notification);
    }
}