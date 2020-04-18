package com.rambler.dao;

import com.rambler.beans.CourseComment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseCommentMapper {
    int insert(CourseComment record);

    int insertSelective(CourseComment record);
}