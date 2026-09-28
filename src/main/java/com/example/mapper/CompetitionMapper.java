package com.example.mapper;

import com.example.entity.Competition;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CompetitionMapper {
    int insert(Competition competition);
    int deleteById(Integer id);
    int deleteBatch(List<Integer> ids);
    int updateById(Competition competition);
    Competition selectById(Integer id);
    List<Competition> selectAll(Competition competition);
}