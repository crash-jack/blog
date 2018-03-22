package com.blog.article.dao;

import com.blog.article.domain.ArticleDetail;

public interface ArticleDetailMapper {
    int insert(ArticleDetail record);

    int insertSelective(ArticleDetail record);
}