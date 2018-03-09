package com.blog.article.service.impl;

import com.blog.article.controller.ASSS;
import com.blog.article.dao.ArticleMapper;
import com.blog.article.dao.DomainMapper;
import com.blog.article.dao.DomainPreMapper;
import com.blog.article.model.Article;
import com.blog.article.model.CommonApi;
import com.blog.article.model.Domain;
import com.blog.article.model.Pinying;
import com.blog.article.qo.ArticleQo;
import com.blog.article.service.ArticleService;
import com.blog.article.service.DomainService;
import com.blog.article.utils.DateFormat;
import com.blog.article.utils.HttpClick;
import com.blog.article.utils.Pagination;
import com.blog.article.vo.DomainVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.*;

@Service
public class ArticleServiceImpl implements ArticleService {
    static Logger logger = Logger.getLogger(ArticleServiceImpl.class.getName());

    @Autowired
    ArticleMapper articleMapper;

    public List<Article> getArticleList(ArticleQo articleQo,Pagination page) {
        return null;
    }

    public int insertSelective(Article article) {
        return 0;
    }

    public int updateByPrimaryKeySelective(Article article) {
        return 0;
    }
}
