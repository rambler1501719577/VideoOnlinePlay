package com.rambler.controller;

import com.rambler.beans.Menu;
import com.rambler.beans.User;
import com.rambler.config.Response;
import com.rambler.service.MenuService;
import com.rambler.service.RoleService;
import com.rambler.utils.BasicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ResponseBody
    @RequestMapping("list")
    public Response getMenuByUser(HttpServletRequest request) {
        User user = BasicUtil.getCurrentUser(request);
        if (user != null) {
            List<Menu> list = menuService.getMenuByRole(user.getRoleId());
            return Response.createSuccessResponse(list);
        }
        return Response.createErrorResponse("用户未登录, 获取菜单失败");
    }
}
