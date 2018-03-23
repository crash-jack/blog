package com.blog.article.service.impl;

import com.blog.article.dao.ArticleMapper;
import com.blog.article.model.Article;
import com.blog.article.qo.ArticleQo;
import com.blog.article.service.ArticleService;
import com.blog.article.utils.Pagination;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleServiceImpl implements ArticleService {
    static Logger logger = Logger.getLogger(ArticleServiceImpl.class.getName());

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> getArticleList(ArticleQo articleQo, Pagination page) {
        return null;
    }

    @Override
    public int save(ArticleQo ArticleQo) {


        return 0;
    }

    @Override
    public int update(ArticleQo ArticleQo) {
        return 0;
    }

    @Override
    public Article getDetails(Long oid) {
        return null;
    }
}
