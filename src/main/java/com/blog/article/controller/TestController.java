package com.blog.article.controller;


import com.blog.article.model.Domain;
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
@RequestMapping("/testController")
public class TestController {

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
        return "asdf123333123";
    }

    @RequestMapping(value="/generateMi",method = RequestMethod.GET)
    @ResponseBody
    public String generateMi(DomainVo domainVo){
//        DomainVo domainVo = new DomainVo();
//        domainVo.setType(type);
//        domainVo.setNumber(number);
//        domainVo.setHouzhui(houzhui);
        System.out.println(111111);
        try{
            List<Domain> list =  domainService.miList(domainVo);
        }catch (Exception e){
            e.printStackTrace();
            return "有问题";
        }
        return "没问题";
    }

    @RequestMapping(value="/listMi")
    @ResponseBody
    public List<Domain> listMi(DomainVo domainVo,Pagination page){
        List<Domain> list =  domainService.getMiList(domainVo,page);
        return  list;
    }
}