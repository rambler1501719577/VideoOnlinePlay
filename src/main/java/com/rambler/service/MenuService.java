package com.rambler.service;

import com.rambler.beans.Menu;
import com.rambler.beans.Role;
import com.rambler.config.Response;
import com.rambler.dao.MenuMapper;
import com.rambler.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> getMenuByRole(String roleId) {
        Role role = roleMapper.selectByPrimaryKey(roleId);
        return menuMapper.getMenuListByRoleId(role.getId());
    }
}
