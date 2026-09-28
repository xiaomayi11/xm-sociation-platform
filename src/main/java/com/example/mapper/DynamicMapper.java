package com.example.mapper;

import com.example.entity.Dynamic;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DynamicMapper {

    int insert(Dynamic dynamic);

    void updateById(Dynamic dynamic);

    void deleteById(Integer id);

    @Select("select * from `dynamic` where id = #{id}")
    Dynamic selectById(Integer id);

    List<Dynamic> selectAll(Dynamic dynamic);

}
