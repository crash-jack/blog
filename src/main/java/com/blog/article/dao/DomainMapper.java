package com.blog.article.dao;

import com.blog.article.model.Domain;

public interface DomainMapper {
    int deleteByPrimaryKey(Long sId);

    int insert(Domain record);

    int insertSelective(Domain record);

    Domain selectByPrimaryKey(Long sId);

    int updateByPrimaryKeySelective(Domain record);

    int updateByPrimaryKey(Domain record);
}