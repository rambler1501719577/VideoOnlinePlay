package com.rambler.service;

import com.rambler.beans.Menu;
import com.rambler.beans.Role;
import com.rambler.beans.User;
import com.rambler.beans.UserRole;
import com.rambler.config.Response;
import com.rambler.config.Variable;
import com.rambler.dao.MenuMapper;
import com.rambler.dao.RoleMapper;
import com.rambler.dao.UserMapper;
import com.rambler.dao.UserRoleMapper;
import com.rambler.utils.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    public Response login(String account, String password, HttpServletRequest request) {
        User user = userMapper.selectByAccount(account);
        HttpSession session = request.getSession();
        if (null != user) {
            if (user.getPassword().equals(password)) {
                Role role = roleMapper.selectByPrimaryKey(user.getRoleId());
                List<Menu> menuList = menuMapper.getMenuListByRoleId(role.getId());
                Map<String,Object> map = new HashMap<>();
                map.put("user",user);
                map.put("menu",menuList);
                session.setAttribute(Variable.CURRENT_USER, map);
                return Response.createSuccessResponse(user);
            } else {
                return Response.createErrorResponse("密码错误");
            }
        }
        return null;
    }

    public Response updateUser(User user, HttpServletRequest request) {
        int result = userMapper.updateByPrimaryKeySelective(user);
        User sessionUser = userMapper.selectByPrimaryKey(user.getId());
        HttpSession session = request.getSession();
        session.setAttribute(Variable.CURRENT_USER, sessionUser);
        if (result >= 1) {
            return Response.createSuccessResponse("更新成功");
        } else {
            return Response.createErrorResponse("更新失败");
        }
    }

    public Response addUser(User user) {
        String id = IDUtil.uuid();
        user.setId(id);
        int result = userMapper.insertSelective(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(id);
        userRole.setRoleId(Variable.TEACHER_ROIE_ID);
        userRoleMapper.insert(userRole);
        if (result >= 1) {
            return Response.createSuccessResponse("操作成功");
        }
        return Response.createErrorResponse("操作失败");
    }

}
