package com.blog.article.controller;


import com.blog.article.model.Article;
import com.blog.article.qo.ArticleQo;
import com.blog.article.service.ArticleService;
import com.blog.article.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired



    ArticleService articleService;

    @RequestMapping(value="/toHome.do")
    public String toHome(){
        return  "view/view/index.jsp";
    }



}