package com.blog.article.dao;

import com.blog.article.domain.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}