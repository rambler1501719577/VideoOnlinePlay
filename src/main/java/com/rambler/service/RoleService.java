package com.rambler.service;

import com.rambler.beans.Role;
import com.rambler.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public Role getRoleById(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
