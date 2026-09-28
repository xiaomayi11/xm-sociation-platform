package com.example.mapper;

import com.example.entity.SystemConfig;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SystemConfigMapper {
    int insert(SystemConfig systemConfig);
    int deleteById(Integer id);
    int deleteBatch(List<Integer> ids);
    int updateById(SystemConfig systemConfig);
    SystemConfig selectById(Integer id);
    List<SystemConfig> selectAll(SystemConfig systemConfig);
}