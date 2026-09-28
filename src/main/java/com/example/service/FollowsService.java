package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.example.entity.Follows;
import com.example.entity.Notification;
import com.example.entity.User;
import com.example.mapper.FollowsMapper;
import com.example.mapper.NotificationMapper;
import com.example.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 关注取关业务层方法
 */
@Service
public class FollowsService {

    @Resource
    private FollowsMapper followsMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private NotificationMapper notificationMapper;

    public void add(Follows follows) {
        List<Follows> list = followsMapper.selectAll(follows);
        if (CollectionUtil.isNotEmpty(list)) {
            // 有数据说明关注过，那么这次点击的就是取消关注，把这条记录给删掉
            followsMapper.deleteById(list.get(0).getId());
        } else {
            // 没有数据说明没关注过，那么这次就是关注，直接往数据库里面写一条记录
            followsMapper.insert(follows);
            // 给被关注的用户发通知
            User fromUser = userMapper.selectById(follows.getFromId());
            Notification notification = new Notification();
            notification.setUserId(follows.getToId());
            notification.setFromUserId(follows.getFromId());
            notification.setType("follow");
            notification.setContent((fromUser != null ? fromUser.getName() : "有人") + "关注了你");
            notification.setTime(DateUtil.now());
            notification.setIsRead(false);
            notificationMapper.insert(notification);
        }
    }

    public void updateById(Follows follows) {
        followsMapper.updateById(follows);
    }

    public void deleteById(Integer id) {
        followsMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            followsMapper.deleteById(id);
        }
    }

    public Follows selectById(Integer id) {
        return followsMapper.selectById(id);
    }

    public List<Follows> selectAll(Follows follows) {
        List<Follows> list = followsMapper.selectAll(follows);
        for (Follows dbFollows : list) {
            Integer fromId = dbFollows.getFromId();
            Integer toId = dbFollows.getToId();
            dbFollows.setFromUser(userMapper.selectById(fromId));
            dbFollows.setToUser(userMapper.selectById(toId));
        }
        return list;
    }

    public PageInfo<Follows> selectPage(Follows follows, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Follows> list = followsMapper.selectAll(follows);
        return PageInfo.of(list);
    }

}