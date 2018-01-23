package com.blog.article.dao;

import com.blog.article.model.Domain;

import java.util.List;
import java.util.Map;

public interface DomainPreMapper {
    int deleteByPrimaryKey(Long sId);

    int insert(Domain record);

    int insertSelective(Domain record);

    Domain selectByPrimaryKey(Long sId);

    int updateByPrimaryKeySelective(Domain record);

    int updateByPrimaryKey(Domain record);

    int deleteAll();

    List<Domain> getMiList(Map map);
}