package com.example.mapper;

import com.example.entity.ActivityType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ActivityTypeMapper {

    int insert(ActivityType activityType);

    void updateById(ActivityType activityType);

    void deleteById(Integer id);

    @Select("select * from `activity_type` where id = #{id}")
    ActivityType selectById(Integer id);

    List<ActivityType> selectAll(ActivityType activityType);

}
