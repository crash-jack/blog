package com.blog.article.controller;


import com.blog.article.model.Domain;
import com.blog.article.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping("/testController")
public class ArticleController {

    @Autowired
    DomainService domainService;

    @RequestMapping(value="/getView")
    @ResponseBody
    public String getTest(HttpServletRequest request){
    	System.out.println(111111);
        List<Domain> list =  domainService.getAllData();
        for (Domain data : list){
            System.out.println(data.getsId()+"_________"+data.getCode()+data.getCreateTime());
        }


//        ModelAndView modelAndView = new ModelAndView("test");



        return "asdf123333123";
    }
}