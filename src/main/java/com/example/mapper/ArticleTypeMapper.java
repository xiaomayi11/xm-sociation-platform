package com.example.mapper;

import com.example.entity.ArticleType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleTypeMapper {

    int insert(ArticleType articleType);

    void updateById(ArticleType articleType);

    void deleteById(Integer id);

    @Select("select * from `article_type` where id = #{id}")
    ArticleType selectById(Integer id);

    List<ArticleType> selectAll(ArticleType articleType);

}
