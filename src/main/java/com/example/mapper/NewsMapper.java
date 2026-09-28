package com.example.mapper;

import com.example.entity.News;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsMapper {

    int insert(News news);

    void updateById(News news);

    void deleteById(Integer id);

    @Select("select * from `news` where id = #{id}")
    News selectById(Integer id);

    List<News> selectAll(News news);

    @Select("select * from `news` order by views desc limit 6")
    List<News> top6();

    @Select("select * from `news` order by views desc limit 10")
    List<News> top10();

    @Select("select category, count(*) as count from news group by category")
    List<java.util.Map<String, Object>> countByCategory();
}