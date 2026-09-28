package com.example.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HtmlUtil;
import com.example.entity.Article;
import com.example.entity.User;
import com.example.mapper.ArticleMapper;
import com.example.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 帖子信息业务层方法
 */
@Service
public class ArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private UserMapper userMapper;

    public void add(Article article) {
        article.setTime(DateUtil.now());
        articleMapper.insert(article);
    }

    public void updateById(Article article) {
        articleMapper.updateById(article);
    }

    public void deleteById(Integer id) {
        articleMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            articleMapper.deleteById(id);
        }
    }

    public void updateBatch(List<Article> articles) {
        for (Article article : articles) {
            articleMapper.updateById(article);
        }
    }

    public Article selectById(Integer id) {
        return articleMapper.selectById(id);
    }

    public List<Article> selectAll(Article article) {
        return articleMapper.selectAll(article);
    }

    public PageInfo<Article> selectPage(Article article, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Article> list = articleMapper.selectAll(article);
        for (Article dbArticle : list) {
            dbArticle.setDescription(HtmlUtil.cleanHtmlTag(dbArticle.getContent()));
        }
        return PageInfo.of(list);
    }

    public List<Article> top5() {
        List<Article> list = articleMapper.top5();
        for (Article dbArticle : list) {
            dbArticle.setDescription(HtmlUtil.cleanHtmlTag(dbArticle.getContent()));
            User user = userMapper.selectById(dbArticle.getUserId());
            if (ObjectUtil.isNotEmpty(user)) {
                dbArticle.setUserAvatar(user.getAvatar());
                dbArticle.setUserName(user.getName());
            }
        }
        return list;
    }
}