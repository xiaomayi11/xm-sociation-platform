package com.example.mapper;

import com.example.entity.TeamMember;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TeamMemberMapper {
    int insert(TeamMember teamMember);
    int deleteById(Integer id);
    int deleteBatch(List<Integer> ids);
    int updateById(TeamMember teamMember);
    TeamMember selectById(Integer id);
    List<TeamMember> selectAll(TeamMember teamMember);
}