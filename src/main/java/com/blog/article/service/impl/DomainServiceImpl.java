package com.blog.article.service.impl;

import com.blog.article.controller.ASSS;
import com.blog.article.dao.DomainMapper;
import com.blog.article.dao.DomainPreMapper;
import com.blog.article.model.CommonApi;
import com.blog.article.model.Domain;
import com.blog.article.model.Pinying;
import com.blog.article.service.DomainService;
import com.blog.article.utils.DateFormat;
import com.blog.article.utils.HttpClick;
import com.blog.article.utils.Pagination;
import com.blog.article.vo.DomainVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


import java.util.*;

@Service
public class DomainServiceImpl implements DomainService {

    @Autowired
    DomainMapper domainMapper;

    @Autowired
    DomainPreMapper domainPreMapper;
    @Autowired
    private DataSourceTransactionManager txManager;

    @Override
    public int insertSelective(Domain domain) {
        return domainMapper.insertSelective(domain);
    }


    @Override
    public List<Domain> getMiList(DomainVo domainVo, Pagination page) {
        Map map = new HashMap<String,Object>();
        map.put("data",domainVo);
        map.put("page",page);
        List<Domain> list = domainPreMapper.getMiList(map);

        return list;
    }

    /**
     * by zbb
     * @throws
     * @title: getUrl
     * @Description: TODO
     * void
     */
    @Override
    public List<Domain> miList(DomainVo domainVo) {
        System.out.println("******************************");
        System.out.println("进入时间：" + DateFormat.DateToString(new Date()));
        List<DomainVo> resultList = new ArrayList<DomainVo>();
        List<String> list = new ArrayList<String>();
        List<String> urlList = new ArrayList<String>();
        switch (domainVo.getType()) {
            case 1:
                ASSS.get(list, CommonApi.shuzi, domainVo.getNumber());
                break;
            case 2:
                ASSS.get(list, CommonApi.zimu, domainVo.getNumber());
                break;
            case 3:
                ASSS.get(list, Pinying.pinying, domainVo.getNumber());
                break;
            case 4:
                ASSS.get(list, CommonApi.shengmu, domainVo.getNumber());
                break;
            default:
                break;
        }
        System.out.println("生成结束,共有" + list.size() + "条数据,时间：" + DateFormat.DateToString(new Date()));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            urlList.add(sb.append(list.get(i)).append(".").append(domainVo.getHouzhui()).toString());
            sb.delete(0, sb.length());
        }

        //获取完结果 开始查询是否存在
        //分批查询 500条一段
        for (int i = 0; i < urlList.size(); i++) {
            String resultStr = HttpClick.httpURLConectionGET(CommonApi.URL + urlList.get(i), i);
            DomainVo m = new DomainVo();
            m.setUrl(urlList.get(i));
            m.setCode(isUsed(resultStr));
            if ("210".equals(m.getCode())) {
                m.setFlag(true);
            } else {
                m.setFlag(false);
            }
            resultList.add(m);
            System.out.println(m.getUrl() + "****状态：" + m.getCode());
        }

        System.out.println("总共有" + resultList.size() + "个可用,查询玩时间：" + DateFormat.DateToString(new Date()));
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);// 事物隔离级别，开启新事务
        TransactionStatus status = txManager.getTransaction(def); // 获得事务状态
        System.out.println("可用数据为以下这些");



        domainPreMapper.deleteAll();
        for (int i = 0; i < resultList.size(); i++) {
            Domain domain = new Domain();
            DomainVo par = resultList.get(i);
            domain.setSort(i);
            domain.setUrl(resultList.get(i).getUrl()+domainVo.getHouzhui());
            domain.setCode(par.getCode());
            domain.setSuffix(domainVo.getHouzhui());
//            domain.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            domainPreMapper.insertSelective(domain);
            //逻辑代码，可以写上你的逻辑处理代码
        }
        txManager.commit(status);
        return null;
    }


    public static String isUsed(String resultStr) {
        int i = resultStr.indexOf("<original>");
        String code = resultStr.substring(i + 10, i + 13);
        return code;
    }



    public int updateByPrimaryKeySelective(Domain domain) {
        return domainMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public List<Domain> getAllData() {
        return domainMapper.getAllData();
    }





}
