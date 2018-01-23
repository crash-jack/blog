package com.blog.article.service;

import com.blog.article.model.Domain;
import com.blog.article.utils.Pagination;
import com.blog.article.vo.DomainVo;

import java.util.List;

public interface DomainService {
    List<Domain> getAllData();

    int insertSelective(Domain domain);

    int updateByPrimaryKeySelective(Domain domain);

    List<Domain> miList(DomainVo domainVo);

    List<Domain> getMiList(DomainVo domainVo, Pagination page);
 }
