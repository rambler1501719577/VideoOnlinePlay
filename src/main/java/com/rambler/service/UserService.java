package com.rambler.service;

import com.rambler.beans.*;
import com.rambler.config.Response;
import com.rambler.config.TableResponse;
import com.rambler.config.Variable;
import com.rambler.dao.*;
import com.rambler.utils.IDUtil;
import com.rambler.vo.TeacherVo;
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
    private CourseMapper courseMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    public Response delete(String id) {
        return userMapper.deleteByPrimaryKey(id) > 0 ? Response.createSuccessResponse(null) : Response.createErrorResponse("审批成功");
    }

    public Response updateStatus(String id, int status) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user != null) {
            user.setStatus(0);
            userMapper.updateByPrimaryKeySelective(user);
            return Response.createSuccessResponse(user);
        } else {
            return Response.createErrorResponse("审批失败");
        }
    }

    public User register(String account, String password, String name, String role) {
        User user = new User();
        user.setId(IDUtil.uuid());
        // 教师需要审核, 学员不用审核
        if (role.equalsIgnoreCase("teacher")) {
            user.setStatus(1);
        } else {
            user.setStatus(0);
        }
        user.setRoleId(role);
        user.setAccount(account);
        user.setName(name);
        user.setPassword(password);
        user.setHeader("/static/upload/images/" + role + ".png");
        int result = userMapper.insertSelective(user);
        if (result > 0) {
            return user;
        }
        return null;
    }

    public Response login(String account, String password, HttpServletRequest request) {
        User user = userMapper.selectByAccount(account);
        HttpSession session = request.getSession();
        if (null != user) {
            if (user.getPassword().equals(password) && user.getStatus() == 0) {
                session.setAttribute(Variable.CURRENT_USER, user);
                return Response.createSuccessResponse(user);
            } else {
                return Response.createErrorResponse("密码错误或者未通过审核");
            }
        }
        return null;
    }

    public Response updateUser(User user, HttpServletRequest request) {
        int result = userMapper.updateByPrimaryKeySelective(user);
        User sessionUser = userMapper.selectByPrimaryKey(user.getId());
        HttpSession session = request.getSession();
        session.removeAttribute(Variable.CURRENT_USER);
        session.setAttribute(Variable.CURRENT_USER, sessionUser);
        if (result >= 1) {
            return Response.createSuccessResponse(sessionUser);
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

    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public TableResponse getTeacherList(Integer start, Integer limit) {
        List<User> list = userMapper.getAllTeachers(0);
        List<TeacherVo> result = new ArrayList<>();
        List<User> temp = userMapper.getTeacherList((start - 1) * limit, limit, 0);
        for (User user : temp) {
            List<Course> courses = courseMapper.getTeacherCourse(user.getId());
            result.add(new TeacherVo(user, courses));
        }
        return TableResponse.createSuccessResponse("", result, list.size());
    }

    public TableResponse getApplyTeachers(Integer start, Integer limit) {
        List<User> list = userMapper.getAllTeachers(1);
        List<TeacherVo> result = new ArrayList<>();
        List<User> temp = userMapper.getTeacherList((start - 1) * limit, limit, 1);
        for (User user : temp) {
            List<Course> courses = courseMapper.getTeacherCourse(user.getId());
            result.add(new TeacherVo(user, courses));
        }
        return TableResponse.createSuccessResponse("", result, list.size());
    }


}
