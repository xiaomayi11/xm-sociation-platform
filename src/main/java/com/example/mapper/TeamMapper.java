package com.example.mapper;

import com.example.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TeamMapper {
    int insert(Team team);
    int deleteById(Integer id);
    int deleteBatch(List<Integer> ids);
    int updateById(Team team);
    Team selectById(Integer id);
    List<Team> selectAll(Team team);
}