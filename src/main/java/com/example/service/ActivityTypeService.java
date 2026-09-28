package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.ActivityType;
import com.example.mapper.ActivityTypeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 竞赛分类业务层方法
 */
@Service
public class ActivityTypeService {

    @Resource
    private ActivityTypeMapper activityTypeMapper;

    public void add(ActivityType activityType) {
        activityTypeMapper.insert(activityType);
    }

    public void updateById(ActivityType activityType) {
        activityTypeMapper.updateById(activityType);
    }

    public void deleteById(Integer id) {
        activityTypeMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            activityTypeMapper.deleteById(id);
        }
    }

    public ActivityType selectById(Integer id) {
        return activityTypeMapper.selectById(id);
    }

    public List<ActivityType> selectAll(ActivityType activityType) {
        return activityTypeMapper.selectAll(activityType);
    }

    public PageInfo<ActivityType> selectPage(ActivityType activityType, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ActivityType> list = activityTypeMapper.selectAll(activityType);
        return PageInfo.of(list);
    }

}
