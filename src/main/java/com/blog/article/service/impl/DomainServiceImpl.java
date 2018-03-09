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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


import java.util.*;

@Service
public class DomainServiceImpl implements DomainService {
    static Logger logger = Logger.getLogger(DomainServiceImpl.class.getName());


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
        logger.info("aaaaaaaaaaaaa");
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
        System.out.println("杩涘叆鏃堕棿锛�" + DateFormat.DateToString(new Date()));
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
        System.out.println("鐢熸垚缁撴潫,鍏辨湁" + list.size() + "鏉℃暟鎹�,鏃堕棿锛�" + DateFormat.DateToString(new Date()));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            urlList.add(sb.append(list.get(i)).append(".").append(domainVo.getHouzhui()).toString());
            sb.delete(0, sb.length());
        }

        //鑾峰彇瀹岀粨鏋� 寮�濮嬫煡璇㈡槸鍚﹀瓨鍦�
        //鍒嗘壒鏌ヨ 500鏉′竴娈�
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
            System.out.println(m.getUrl() + "****鐘舵�侊細" + m.getCode());
        }

        System.out.println("鎬诲叡鏈�" + resultList.size() + "涓彲鐢�,鏌ヨ鐜╂椂闂达細" + DateFormat.DateToString(new Date()));
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);// 浜嬬墿闅旂绾у埆锛屽紑鍚柊浜嬪姟
        TransactionStatus status = txManager.getTransaction(def); // 鑾峰緱浜嬪姟鐘舵��
        System.out.println("鍙敤鏁版嵁涓轰互涓嬭繖浜�");

        logger.info("aaaaaaaaaaaaa");

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
            //閫昏緫浠ｇ爜锛屽彲浠ュ啓涓婁綘鐨勯�昏緫澶勭悊浠ｇ爜
        }
        txManager.commit(status);
        return null;
    }


    public static String isUsed(String resultStr) {
        int i = resultStr.indexOf("<original>");
        String code = resultStr.substring(i + 10, i + 13);
        return code;
    }


    @Override
    public int updateByPrimaryKeySelective(Domain domain) {
        return domainMapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public List<Domain> getAllData() {
        return domainMapper.getAllData();
    }





}
