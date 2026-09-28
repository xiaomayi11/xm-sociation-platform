package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.entity.Dynamic;
import com.example.entity.Notification;
import com.example.entity.Praise;
import com.example.exception.CustomException;
import com.example.mapper.DynamicMapper;
import com.example.mapper.NotificationMapper;
import com.example.mapper.PraiseMapper;
import com.example.mapper.UserMapper;
import com.example.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 点赞业务层方法
 */
@Service
public class PraiseService {

    @Resource
    private PraiseMapper praiseMapper;
    @Resource
    private DynamicMapper dynamicMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private NotificationMapper notificationMapper;

    public void add(Praise praise) {
        Dynamic dynamic = dynamicMapper.selectById(praise.getDynamicId());
        if (ObjectUtil.isEmpty(dynamic)) {
            throw new CustomException("500", "该动态不存在");
        }
        List<Praise> praises = praiseMapper.selectAll(praise);
        if (CollectionUtil.isNotEmpty(praises)) {
            // 说明该用户已经点赞过该动态了，需要取消点赞，把该记录删掉
            praiseMapper.deleteById(praises.get(0).getId());
            // 该动态的点赞数 - 1
            dynamic.setPraise(dynamic.getPraise() - 1);
        } else {
            // 否则就没有点赞，那么直接往点赞表里面新增一条点赞记录即可
            praiseMapper.insert(praise);
            // 该动态的点赞数 + 1
            dynamic.setPraise(dynamic.getPraise() + 1);
            // 给动态作者发通知（不给自己发）
            if (!praise.getUserId().equals(dynamic.getUserId())) {
                User fromUser = userMapper.selectById(praise.getUserId());
                String snippet = dynamic.getContent();
                if (snippet != null && snippet.length() > 20) snippet = snippet.substring(0, 20) + "...";
                Notification notification = new Notification();
                notification.setUserId(dynamic.getUserId());
                notification.setFromUserId(praise.getUserId());
                notification.setType("like");
                notification.setRelId(dynamic.getId());
                notification.setContent((fromUser != null ? fromUser.getName() : "有人") + "赞了你的动态");
                notification.setTime(DateUtil.now());
                notification.setIsRead(false);
                notificationMapper.insert(notification);
            }
        }
        dynamicMapper.updateById(dynamic);
    }

    public void updateById(Praise praise) {
        praiseMapper.updateById(praise);
    }

    public void deleteById(Integer id) {
        praiseMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            praiseMapper.deleteById(id);
        }
    }

    public Praise selectById(Integer id) {
        return praiseMapper.selectById(id);
    }

    public List<Praise> selectAll(Praise praise) {
        return praiseMapper.selectAll(praise);
    }

    public PageInfo<Praise> selectPage(Praise praise, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Praise> list = praiseMapper.selectAll(praise);
        return PageInfo.of(list);
    }

}