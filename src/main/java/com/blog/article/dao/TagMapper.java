package com.blog.article.dao;

import com.blog.article.domain.Tag;

public interface TagMapper {
    int deleteByPrimaryKey(Long oid);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Long oid);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}