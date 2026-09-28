package com.example.mapper;

import com.example.entity.TeamApplication;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TeamApplicationMapper {
    int insert(TeamApplication teamApplication);
    int deleteById(Integer id);
    int deleteBatch(List<Integer> ids);
    int updateById(TeamApplication teamApplication);
    TeamApplication selectById(Integer id);
    List<TeamApplication> selectAll(TeamApplication teamApplication);
}
