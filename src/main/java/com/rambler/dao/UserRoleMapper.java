package com.rambler.dao;

import com.rambler.beans.Role;
import com.rambler.beans.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    Role searchRoleByUser(String userId);
}