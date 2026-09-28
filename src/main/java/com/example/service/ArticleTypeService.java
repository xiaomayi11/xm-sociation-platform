package com.example.service;

import com.example.entity.ArticleType;
import com.example.mapper.ArticleTypeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 帖子分类业务层方法
 */
@Service
public class ArticleTypeService {

    @Resource
    private ArticleTypeMapper articleTypeMapper;

    public void add(ArticleType articleType) {
        articleTypeMapper.insert(articleType);
    }

    public void updateById(ArticleType articleType) {
        articleTypeMapper.updateById(articleType);
    }

    public void deleteById(Integer id) {
        articleTypeMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            articleTypeMapper.deleteById(id);
        }
    }

    public ArticleType selectById(Integer id) {
        return articleTypeMapper.selectById(id);
    }

    public List<ArticleType> selectAll(ArticleType articleType) {
        return articleTypeMapper.selectAll(articleType);
    }

    public PageInfo<ArticleType> selectPage(ArticleType articleType, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleType> list = articleTypeMapper.selectAll(articleType);
        return PageInfo.of(list);
    }

}
