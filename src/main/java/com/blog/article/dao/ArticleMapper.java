package com.blog.article.dao;

import com.blog.article.model.Article;
import com.blog.article.qo.ArticleQo;
import com.blog.article.utils.Pagination;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> getArticleList(ArticleQo articleQo, Pagination page);
}