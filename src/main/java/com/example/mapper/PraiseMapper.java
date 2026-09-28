package com.example.mapper;

import com.example.entity.Praise;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PraiseMapper {

    int insert(Praise praise);

    void updateById(Praise praise);

    void deleteById(Integer id);

    @Select("select * from `praise` where id = #{id}")
    Praise selectById(Integer id);

    List<Praise> selectAll(Praise praise);

}
