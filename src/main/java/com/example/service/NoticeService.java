package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Notice;
import com.example.entity.Notification;
import com.example.entity.User;
import com.example.mapper.NoticeMapper;
import com.example.mapper.NotificationMapper;
import com.example.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层方法
 */
@Service
public class NoticeService {

    @Resource
    private NoticeMapper noticeMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private NotificationMapper notificationMapper;

    public void add(Notice notice) {
        notice.setTime(DateUtil.now());
        noticeMapper.insert(notice);

        try {
            List<User> users = userMapper.selectAll(new User());
            for (User user : users) {
                Notification notification = new Notification();
                notification.setUserId(user.getId());
                notification.setFromUserId(notice.getUserId());
                notification.setFromUserName(notice.getUserName());
                notification.setType("announcement");
                notification.setContent("【系统公告】" + notice.getTitle());
                notification.setRelId(notice.getId());
                notification.setTime(DateUtil.now());
                notification.setIsRead(false);
                notificationMapper.insert(notification);
            }
        } catch (Exception e) {
            // 广播通知失败不影响公告发布本身
        }
    }

    public void updateById(Notice notice) {
        noticeMapper.updateById(notice);
    }

    public void deleteById(Integer id) {
        noticeMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            noticeMapper.deleteById(id);
        }
    }

    public Notice selectById(Integer id) {
        return noticeMapper.selectById(id);
    }

    public List<Notice> selectAll(Notice notice) {
        return noticeMapper.selectAll(notice);
    }

    public PageInfo<Notice> selectPage(Notice notice, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Notice> list = noticeMapper.selectAll(notice);
        return PageInfo.of(list);
    }

}