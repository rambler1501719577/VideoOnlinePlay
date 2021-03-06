package com.rambler.dao;

import com.rambler.beans.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<Question> getQuestionByUserId(@Param("userId") String userId,@Param("courseId") String courseId);

    List<Question> getQuestionListByUser(String userId);

    List<Question> getQuestionByCourseId(String courseId);
}