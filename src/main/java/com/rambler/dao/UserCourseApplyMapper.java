package com.rambler.dao;

import com.rambler.beans.UserCourseApply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCourseApplyMapper {
    int insert(UserCourseApply record);

    int insertSelective(UserCourseApply record);
}