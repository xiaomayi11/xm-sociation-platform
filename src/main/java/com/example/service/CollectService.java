package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.entity.Article;
import com.example.entity.Collect;
import com.example.mapper.ArticleMapper;
import com.example.mapper.CollectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收藏业务层方法
 */
@Service
public class CollectService {

    @Resource
    private CollectMapper collectMapper;
    @Resource
    private ArticleMapper articleMapper;

    public void add(Collect collect) {
        List<Collect> collects = collectMapper.selectAll(collect);
        if (CollectionUtil.isNotEmpty(collects)) {
            // 说明该用户已经收藏过该帖子了，需要取消收藏，把该记录删掉
            collectMapper.deleteById(collects.get(0).getId());
        } else {
            // 否则就没有收藏，那么直接往收藏表里面新增一条收藏记录即可
            collectMapper.insert(collect);
        }
    }

    public void updateById(Collect collect) {
        collectMapper.updateById(collect);
    }

    public void deleteById(Integer id) {
        collectMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            collectMapper.deleteById(id);
        }
    }

    public Collect selectById(Integer id) {
        return collectMapper.selectById(id);
    }

    public List<Collect> selectAll(Collect collect) {
        return collectMapper.selectAll(collect);
    }

    public PageInfo<Collect> selectPage(Collect collect, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Collect> list = collectMapper.selectAll(collect);
        for (Collect dbCollect : list) {
            Article article = articleMapper.selectById(dbCollect.getArticleId());
            if (ObjectUtil.isNotEmpty(article)) {
                dbCollect.setArticle(article);
            }
        }
        return PageInfo.of(list);
    }

}
