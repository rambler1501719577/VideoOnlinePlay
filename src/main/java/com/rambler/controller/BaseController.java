package com.rambler.controller;

import com.rambler.config.Response;
import com.rambler.config.Variable;
import com.rambler.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        // 检测用户是否登陆, 如果未登录跳转登陆页面, 否则跳到首页
        HttpSession session = request.getSession();
        if (session.getAttribute(Variable.CURRENT_USER) != null) {
            return "index.html";
        }
        return "login.html";
//        return "index.html";
    }

    @RequestMapping(value = "menu", method = RequestMethod.GET)
    @ResponseBody
    public Response getSystemMenu(HttpServletRequest request) {
        return menuService.searchMenuByRole(request);
    }
}
