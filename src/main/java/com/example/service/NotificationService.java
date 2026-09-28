package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Notification;
import com.example.mapper.NotificationMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Resource
    private NotificationMapper notificationMapper;

    public void add(Notification notification) {
        notification.setTime(DateUtil.now());
        notification.setIsRead(false);
        notificationMapper.insert(notification);
    }

    public void updateById(Notification notification) {
        notificationMapper.updateById(notification);
    }

    public void deleteById(Integer id) {
        notificationMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            notificationMapper.deleteById(id);
        }
    }

    public Notification selectById(Integer id) {
        return notificationMapper.selectById(id);
    }

    public List<Notification> selectAll(Notification notification) {
        return notificationMapper.selectAll(notification);
    }

    public PageInfo<Notification> selectPage(Notification notification, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Notification> list = notificationMapper.selectAll(notification);
        return PageInfo.of(list);
    }

    public int countUnread(Integer userId) {
        return notificationMapper.countUnread(userId);
    }

    public void readAll(Integer userId) {
        notificationMapper.readAll(userId);
    }

    public Notification selectLatestUnreadAnnouncement(Integer userId) {
        return notificationMapper.selectLatestUnreadAnnouncement(userId);
    }
}