package com.rambler.dao;

import com.rambler.beans.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByAccount(String account);

    List<User> getTeacherList(@Param("start") Integer start, @Param("limit") Integer limit,@Param("status") int status);

    List<User> getAllTeachers(int status);

}