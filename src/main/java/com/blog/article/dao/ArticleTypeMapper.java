package com.blog.article.dao;

import com.blog.article.domain.ArticleType;

public interface ArticleTypeMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    ArticleType selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);
}