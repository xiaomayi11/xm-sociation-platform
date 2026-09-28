package com.example.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HtmlUtil;
import com.example.entity.News;
import com.example.mapper.NewsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 竞赛新闻业务层方法
 */
@Service
public class NewsService {

    @Resource
    private NewsMapper newsMapper;

    public void add(News news) {
        news.setTime(DateUtil.now());
        newsMapper.insert(news);
    }

    public void updateById(News news) {
        newsMapper.updateById(news);
    }

    public void deleteById(Integer id) {
        newsMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            newsMapper.deleteById(id);
        }
    }

    public News selectById(Integer id) {
        return newsMapper.selectById(id);
    }

    public List<News> selectAll(News news) {
        return newsMapper.selectAll(news);
    }

    public PageInfo<News> selectPage(News news, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<News> list = newsMapper.selectAll(news);
        for (News dbNews : list) {
            dbNews.setDescription(HtmlUtil.cleanHtmlTag(dbNews.getContent()));
        }
        return PageInfo.of(list);
    }

    public List<News> top6() {
        return newsMapper.top6();
    }

    public List<News> top10() {
        return newsMapper.top10();
    }

    public List<Map<String, Object>> countByCategory() {
        return newsMapper.countByCategory();
    }
}