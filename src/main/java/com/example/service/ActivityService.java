package com.example.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HtmlUtil;
import com.example.entity.Activity;
import com.example.mapper.ActivityMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 校园竞赛业务层方法
 */
@Service
public class ActivityService {

    @Resource
    private ActivityMapper activityMapper;

    public void add(Activity activity) {
        activity.setTime(DateUtil.now());
        activityMapper.insert(activity);
    }

    public void updateById(Activity activity) {
        activityMapper.updateById(activity);
    }

    public void deleteById(Integer id) {
        activityMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            activityMapper.deleteById(id);
        }
    }

    public Activity selectById(Integer id) {
        return activityMapper.selectById(id);
    }

    public List<Activity> selectAll(Activity activity) {
        return activityMapper.selectAll(activity);
    }

    public PageInfo<Activity> selectPage(Activity activity, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Activity> list = activityMapper.selectAll(activity);
        for (Activity dbActivity : list) {
            dbActivity.setDescription(HtmlUtil.cleanHtmlTag(dbActivity.getContent()));
        }
        return PageInfo.of(list);
    }

    public List<Activity> top2() {
        return activityMapper.top2();
    }
}
