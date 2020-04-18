package com.rambler.dao;

import com.rambler.beans.Apply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
}