package com.blog.article.test;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/testController")
public class ArticleController {

    @RequestMapping(value="/getView")
    @ResponseBody
    public ModelAndView getTest(HttpServletRequest request){
    	System.out.println(111111);
        ModelAndView modelAndView = new ModelAndView("test");
        return modelAndView;
    }
}