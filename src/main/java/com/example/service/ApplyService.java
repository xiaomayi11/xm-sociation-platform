package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Apply;
import com.example.entity.Notification;
import com.example.mapper.ActivityMapper;
import com.example.mapper.ApplyMapper;
import com.example.mapper.NotificationMapper;
import com.example.entity.Activity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 竞赛申请业务层方法
 */
@Service
public class ApplyService {

    @Resource
    private ApplyMapper applyMapper;
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private NotificationMapper notificationMapper;

    public void add(Apply apply) {
        apply.setTime(DateUtil.now());
        applyMapper.insert(apply);
    }

    public void updateById(Apply apply) {
        applyMapper.updateById(apply);
        // 状态变更时通知申请人
        if (apply.getStatus() != null && !"待审核".equals(apply.getStatus())) {
            Apply dbApply = applyMapper.selectById(apply.getId());
            if (dbApply != null) {
                Activity activity = activityMapper.selectById(dbApply.getActivityId());
                String activityName = activity != null ? activity.getTitle() : "竞赛";
                Notification notification = new Notification();
                notification.setUserId(dbApply.getUserId());
                notification.setType("apply");
                notification.setRelId(apply.getId());
                notification.setContent("你报名的《" + activityName + "》审核结果：" + apply.getStatus());
                notification.setTime(DateUtil.now());
                notification.setIsRead(false);
                notificationMapper.insert(notification);
            }
        }
    }

    public void deleteById(Integer id) {
        applyMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            applyMapper.deleteById(id);
        }
    }

    public void updateBatch(List<Apply> applies) {
        for (Apply apply : applies) {
            updateById(apply);
        }
    }

    public Apply selectById(Integer id) {
        return applyMapper.selectById(id);
    }

    public List<Apply> selectAll(Apply apply) {
        return applyMapper.selectAll(apply);
    }

    public PageInfo<Apply> selectPage(Apply apply, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Apply> list = applyMapper.selectAll(apply);
        return PageInfo.of(list);
    }

}