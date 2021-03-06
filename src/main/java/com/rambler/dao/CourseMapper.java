package com.rambler.dao;

import com.rambler.beans.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {
    int deleteByPrimaryKey(String id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> getByClassifyId(String classifyId);

    List<Course> getCourseByUser(String userId);

    List<Course> getTeacherCourse(String teacherId);

    List<Course> selectList(@Param("start") Integer start, @Param("limit") Integer limit);

    List<Course> selectRequestList(@Param("start") Integer start, @Param("limit") Integer limit);

    List<Course> selectAll();

    List<Course> selectRequestAll();

    int updateApply(@Param("id") String id,@Param("status")int status);
}