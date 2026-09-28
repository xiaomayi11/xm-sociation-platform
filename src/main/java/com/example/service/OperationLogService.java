package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.OperationLog;
import com.example.mapper.OperationLogMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationLogService {

    @Resource
    private OperationLogMapper operationLogMapper;

    public void add(OperationLog operationLog) {
        operationLog.setTime(DateUtil.now());
        operationLogMapper.insert(operationLog);
    }

    public void updateById(OperationLog operationLog) {
        operationLogMapper.updateById(operationLog);
    }

    public void deleteById(Integer id) {
        operationLogMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        operationLogMapper.deleteBatch(ids);
    }

    public OperationLog selectById(Integer id) {
        return operationLogMapper.selectById(id);
    }

    public List<OperationLog> selectAll(OperationLog operationLog) {
        return operationLogMapper.selectAll(operationLog);
    }

    public PageInfo<OperationLog> selectPage(Integer pageNum, Integer pageSize, OperationLog operationLog) {
        PageHelper.startPage(pageNum, pageSize);
        List<OperationLog> list = operationLogMapper.selectAll(operationLog);
        return PageInfo.of(list);
    }
}