package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.SystemConfig;
import com.example.mapper.SystemConfigMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemConfigService {

    @Resource
    private SystemConfigMapper systemConfigMapper;

    public void add(SystemConfig systemConfig) {
        systemConfig.setUpdateTime(DateUtil.now());
        systemConfigMapper.insert(systemConfig);
    }

    public void updateById(SystemConfig systemConfig) {
        systemConfig.setUpdateTime(DateUtil.now());
        systemConfigMapper.updateById(systemConfig);
    }

    public void deleteById(Integer id) {
        systemConfigMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        systemConfigMapper.deleteBatch(ids);
    }

    public SystemConfig selectById(Integer id) {
        return systemConfigMapper.selectById(id);
    }

    public List<SystemConfig> selectAll(SystemConfig systemConfig) {
        return systemConfigMapper.selectAll(systemConfig);
    }

    public PageInfo<SystemConfig> selectPage(Integer pageNum, Integer pageSize, SystemConfig systemConfig) {
        PageHelper.startPage(pageNum, pageSize);
        List<SystemConfig> list = systemConfigMapper.selectAll(systemConfig);
        return PageInfo.of(list);
    }
}