package com.example.mapper;

import com.example.entity.Notification;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NotificationMapper {

    int insert(Notification notification);

    void updateById(Notification notification);

    void deleteById(Integer id);

    @Select("select * from `notification` where id = #{id}")
    Notification selectById(Integer id);

    List<Notification> selectAll(Notification notification);

    @Select("select count(*) from `notification` where user_id = #{userId} and is_read = 0")
    int countUnread(Integer userId);

    @Select("update `notification` set is_read = 1 where user_id = #{userId} and is_read = 0")
    void readAll(Integer userId);

    @Select("select * from `notification` where user_id = #{userId} and type = 'announcement' and is_read = 0 order by id desc limit 1")
    Notification selectLatestUnreadAnnouncement(Integer userId);
}