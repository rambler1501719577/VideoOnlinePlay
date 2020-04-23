package com.rambler.dao;

import com.rambler.beans.Survey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SurveyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Survey record);

    int insertSelective(Survey record);

    Survey selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Survey record);

    int updateByPrimaryKey(Survey record);

    List<Survey> selectByUser(@Param("userId") String userId, @Param("courseId") String courseId);
}