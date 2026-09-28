package com.example.mapper;

import com.example.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OperationLogMapper {
    int insert(OperationLog operationLog);
    int deleteById(Integer id);
    int deleteBatch(List<Integer> ids);
    int updateById(OperationLog operationLog);
    OperationLog selectById(Integer id);
    List<OperationLog> selectAll(OperationLog operationLog);
}