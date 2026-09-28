package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Comment;
import com.example.entity.Dynamic;
import com.example.mapper.CommentMapper;
import com.example.mapper.DynamicMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户动态业务层方法
 */
@Service
public class DynamicService {

    @Resource
    private DynamicMapper dynamicMapper;
    @Resource
    private CommentMapper commentMapper;

    public void add(Dynamic dynamic) {
        dynamic.setTime(DateUtil.now());
        dynamicMapper.insert(dynamic);
    }

    public void updateById(Dynamic dynamic) {
        dynamicMapper.updateById(dynamic);
    }

    public void deleteById(Integer id) {
        dynamicMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            dynamicMapper.deleteById(id);
        }
    }

    public Dynamic selectById(Integer id) {
        return dynamicMapper.selectById(id);
    }

    public List<Dynamic> selectAll(Dynamic dynamic) {
        return dynamicMapper.selectAll(dynamic);
    }

    public PageInfo<Dynamic> selectPage(Dynamic dynamic, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Dynamic> list = dynamicMapper.selectAll(dynamic);
        for (Dynamic dbDynamic : list) {
            Comment comment = new Comment();
            comment.setType("动态");
            comment.setRelId(dbDynamic.getId());
            List<Comment> comments = commentMapper.selectAll(comment);
            dbDynamic.setComments(comments);
        }
        return PageInfo.of(list);
    }

}
