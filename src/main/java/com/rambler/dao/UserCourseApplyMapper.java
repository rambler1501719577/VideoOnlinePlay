package com.rambler.dao;

import com.rambler.beans.UserCourseApply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCourseApplyMapper {
    int insert(UserCourseApply record);

    int insertSelective(UserCourseApply record);

    List<UserCourseApply> getApplyByUser(@Param("userId") String userId, @Param("courseId") String courseId);
}