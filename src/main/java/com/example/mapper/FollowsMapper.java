package com.example.mapper;

import com.example.entity.Follows;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FollowsMapper {

    int insert(Follows follows);

    void updateById(Follows follows);

    void deleteById(Integer id);

    @Select("select * from `follows` where id = #{id}")
    Follows selectById(Integer id);

    List<Follows> selectAll(Follows follows);

}
