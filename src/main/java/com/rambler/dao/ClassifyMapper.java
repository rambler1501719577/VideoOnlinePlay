package com.rambler.dao;

import com.rambler.beans.Classify;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassifyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Classify record);

    int insertSelective(Classify record);

    Classify selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);
}