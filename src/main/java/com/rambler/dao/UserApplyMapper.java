package com.rambler.dao;

import com.rambler.beans.UserApply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserApplyMapper {
    int insert(UserApply record);

    int insertSelective(UserApply record);
}