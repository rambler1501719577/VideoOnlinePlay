package com.rambler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author rambler
 * @since 2020-02-02 21:17
 */
@Controller
@RequestMapping("page")
public class PageController {
    @RequestMapping("detail")
    public String detailPage(){
        return "index/detail.ftl";
    }
}
