package com.rambler.controller;

import com.rambler.beans.User;
import com.rambler.config.Response;
import com.rambler.config.Variable;
import com.rambler.utils.BasicUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {


    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        // 检测用户是否登陆, 如果未登录跳 转登陆页面, 否则跳到首页
        HttpSession session = request.getSession();
        if (session.getAttribute(Variable.CURRENT_USER) != null) {
            return "index/index.html";
        }
        return "common/login.html";
    }

    @RequestMapping("/page/register")
    public String registerPage(){
        return "common/register.html";
    }

    User getSessionUser(HttpServletRequest request) {
        return BasicUtil.getCurrentUser(request);
    }

    @RequestMapping(value = "mkTempSession", method = RequestMethod.POST)
    @ResponseBody
    public Response mkTempSession(HttpServletRequest request) {
        User user = new User();
        user.setName("游客");
        user.setRoleId("visitor");
        request.getSession().setAttribute(Variable.CURRENT_USER, user);
        return Response.createSuccessResponse("成功");
    }

}
