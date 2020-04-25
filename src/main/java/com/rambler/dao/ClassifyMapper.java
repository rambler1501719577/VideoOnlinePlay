package com.rambler.dao;

import com.rambler.beans.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassifyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Classify record);

    int insertSelective(Classify record);

    Classify selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);

    List<Classify> selectAll();

    List<Classify> selectList(@Param("start") Integer page, @Param("limit") Integer limit);

    Classify getByName(String name);
}