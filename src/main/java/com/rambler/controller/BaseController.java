package com.rambler.controller;

import com.rambler.beans.User;
import com.rambler.config.Variable;
import com.rambler.utils.BasicUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    User getSessionUser(HttpServletRequest request){
        return BasicUtil.getCurrentUser(request);
    }

}
