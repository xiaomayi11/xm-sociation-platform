package com.example.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.entity.Article;
import com.example.entity.Comment;
import com.example.entity.Dynamic;
import com.example.entity.Notification;
import com.example.mapper.ArticleMapper;
import com.example.mapper.CommentMapper;
import com.example.mapper.DynamicMapper;
import com.example.mapper.NotificationMapper;
import com.example.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户平台业务层方法
 */
@Service
public class CommentService {

    @Resource
    private CommentMapper commentMapper;
    @Resource
    private DynamicMapper dynamicMapper;
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private NotificationMapper notificationMapper;

    public void add(Comment comment) {
        comment.setTime(DateUtil.now());
        commentMapper.insert(comment);

        // 给被评论的作者发通知
        Integer targetUserId = null;
        String content = "";
        if ("动态".equals(comment.getType())) {
            Dynamic dynamic = dynamicMapper.selectById(comment.getRelId());
            if (ObjectUtil.isNotEmpty(dynamic)) {
                targetUserId = dynamic.getUserId();
                String snippet = dynamic.getContent();
                if (snippet.length() > 20) snippet = snippet.substring(0, 20) + "...";
                content = "评论了你的动态：" + snippet;
            }
        }
        if ("帖子".equals(comment.getType())) {
            Article article = articleMapper.selectById(comment.getRelId());
            if (ObjectUtil.isNotEmpty(article)) {
                targetUserId = article.getUserId();
                content = "评论了你的帖子《" + article.getTitle() + "》";
            }
        }
        if (targetUserId != null && !targetUserId.equals(comment.getUserId())) {
            Notification notification = new Notification();
            notification.setUserId(targetUserId);
            notification.setFromUserId(comment.getUserId());
            notification.setType("comment");
            notification.setRelId(comment.getRelId());
            notification.setContent(content);
            notification.setTime(DateUtil.now());
            notification.setIsRead(false);
            notificationMapper.insert(notification);
        }
    }

    public void updateById(Comment comment) {
        commentMapper.updateById(comment);
    }

    public void deleteById(Integer id) {
        commentMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            commentMapper.deleteById(id);
        }
    }

    public Comment selectById(Integer id) {
        return commentMapper.selectById(id);
    }

    public List<Comment> selectAll(Comment comment) {
        return commentMapper.selectAll(comment);
    }

    public PageInfo<Comment> selectPage(Comment comment, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> list = commentMapper.selectAll(comment);
        for (Comment dbComment : list) {
            if ("动态".equals(dbComment.getType())) {
                Dynamic dynamic = dynamicMapper.selectById(dbComment.getRelId());
                if (ObjectUtil.isNotEmpty(dynamic)) {
                    dbComment.setRelName(dynamic.getContent());
                }
            }
            if ("帖子".equals(dbComment.getType())) {
                Article article = articleMapper.selectById(dbComment.getRelId());
                if (ObjectUtil.isNotEmpty(article)) {
                    dbComment.setRelName(article.getTitle());
                }
            }
        }
        return PageInfo.of(list);
    }

}