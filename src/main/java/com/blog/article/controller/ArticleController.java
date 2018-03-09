package com.blog.article.controller;


import com.blog.article.model.Article;
import com.blog.article.model.Domain;
import com.blog.article.qo.ArticleQo;
import com.blog.article.service.ArticleService;
import com.blog.article.service.DomainService;
import com.blog.article.utils.Pagination;
import com.blog.article.vo.DomainVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired



    ArticleService articleService;

    @RequestMapping(value="/getArticleList")
    @ResponseBody
    public List<Article> getArticleList(ArticleQo articleQo, Pagination page){
        List<Article> list =  articleService.getArticleList(articleQo,page);
        return  list;
    }
}