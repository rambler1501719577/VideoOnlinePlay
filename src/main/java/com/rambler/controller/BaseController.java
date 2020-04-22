package com.rambler.controller;

import com.rambler.beans.Classify;
import com.rambler.beans.Course;
import com.rambler.config.Variable;
import com.rambler.service.ClassifyService;
import com.rambler.service.CourseService;
import com.rambler.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BaseController {

    @Autowired
    private ClassifyService classifyService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        // 检测用户是否登陆, 如果未登录跳 转登陆页面, 否则跳到首页
        HttpSession session = request.getSession();
        if (session.getAttribute(Variable.CURRENT_USER) != null) {

            return "index/index.html";
        }
        return "common/login.html";
    }

}
