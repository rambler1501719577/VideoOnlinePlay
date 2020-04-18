package com.rambler.dao;

import com.rambler.beans.UserSurvey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserSurveyMapper {
    int insert(UserSurvey record);

    int insertSelective(UserSurvey record);
}