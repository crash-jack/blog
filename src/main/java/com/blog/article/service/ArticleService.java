package com.blog.article.service;

import com.blog.article.model.Article;
import com.blog.article.qo.ArticleQo;
import com.blog.article.utils.Pagination;

import java.util.List;

public interface ArticleService {
    List<Article> getArticleList(ArticleQo articleQo, Pagination page);

    int insertSelective(Article article);

    int updateByPrimaryKeySelective(Article article);
 }
