package com.rambler.controller;

import com.rambler.beans.User;
import com.rambler.config.Response;
import com.rambler.config.TableResponse;
import com.rambler.config.Variable;
import com.rambler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author rambler
 * @since 2020-02-02 17:28
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "validate", method = RequestMethod.POST)
    @ResponseBody
    public Response login(String account, String password, HttpServletRequest request) {
        return userService.login(account, password, request);
    }

    @RequestMapping(value = "current", method = RequestMethod.GET)
    @ResponseBody
    public Response currentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Variable.CURRENT_USER);
        if (user != null) {
            return Response.createSuccessResponse(user);
        } else {
            return Response.createErrorResponse("未登录");
        }
    }

    @RequestMapping("register")
    @ResponseBody
    public Response register(String account, String password, String name, String role, HttpServletRequest request) {
        User result = userService.register(account, password, name, role);
        if (result != null) {
            if (role.equalsIgnoreCase("student")) {
                HttpSession session = request.getSession();
                session.setAttribute(Variable.CURRENT_USER, result);
                return Response.createSuccessResponse("成功");
            }
            return Response.createSuccessResponse("成功");
        }
        return Response.createErrorResponse("注册失败");
    }

    @RequestMapping(value = "quit")
    public String quitCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute(Variable.CURRENT_USER) != null) {
            session.removeAttribute(Variable.CURRENT_USER);
        }
        return "common/login.html";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Response updateUserInfo(User user, HttpServletRequest request) {
        return userService.updateUser(user, request);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Response addUser(User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "teachers")
    @ResponseBody
    public TableResponse teacherList(Integer page, Integer limit) {
        return userService.getTeacherList(page, limit);
    }

    @RequestMapping(value = "teachers/apply")
    @ResponseBody
    public TableResponse applyTeacherList(Integer page, Integer limit) {
        return userService.getApplyTeachers(page, limit);
    }

    @RequestMapping("/teacherApply/agree")
    @ResponseBody
    public Response agree(String id,HttpServletRequest request){
       return userService.updateStatus(id,0);
    }
    @RequestMapping("/teacherApply/disagree")
    @ResponseBody
    public Response disagree(String id){
        return userService.delete(id);
    }

}
