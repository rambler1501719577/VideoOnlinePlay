package com.rambler.controller;

import com.rambler.beans.Role;
import com.rambler.beans.User;
import com.rambler.service.RoleService;
import com.rambler.utils.BasicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author rambler
 * @since 2020-02-02 21:17
 */
@Controller
@RequestMapping("page")
public class PageController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("detail")
    public String detailPage(HttpServletRequest request) {
        User user = BasicUtil.getCurrentUser(request);
        if (user == null) {
            return "common/forbidden.html";
        }
        return "index/detail.html";
    }

    @RequestMapping("help")
    public String help() {
        return "index/help.html";
    }

    @RequestMapping("about")
    public String about() {
        return "index/about.html";
    }

    @RequestMapping("manage")
    public String manage(HttpServletRequest request) {
        User user = BasicUtil.getCurrentUser(request);
        if (user != null) {
            Role role = roleService.getRoleById(user.getRoleId());
            if (role.getName().equals("管理员")) {
                return "manage/index.html";
            }
        }
        return "common/forbidden.html";
    }

    @RequestMapping("editInfo")
    public String editInfo() {
        return "index/editInfo.html";
    }

    @RequestMapping("mycourse")
    public String coursePage() {
        return "index/mycourse.html";
    }

    @RequestMapping("myquestion")
    public String question(){
        return "index/myquestion.html";
    }

    @RequestMapping("correct")
    public String correctPage(){
        return "index/correct.html";
    }

    @RequestMapping("correct/detail")
    public String correctDetailPage(){
        return "index/questiondetail.html";
    }

    @RequestMapping("evaluate")
    public String evaluatePage(){
        return "index/evaluate.html";
    }

    @RequestMapping("survey/detail")
    public String surveyDetail(){
        return "index/surveyDetail.html";
    }
}
