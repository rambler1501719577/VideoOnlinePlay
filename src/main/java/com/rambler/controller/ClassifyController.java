package com.rambler.controller;

import com.rambler.beans.Classify;
import com.rambler.config.Response;
import com.rambler.config.TableResponse;
import com.rambler.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("classify")
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;

    @RequestMapping("list")
    @ResponseBody
    public TableResponse classifyList(Integer page, Integer limit) {
        return classifyService.getAllClassify(page, limit);
    }

    @RequestMapping("update")
    @ResponseBody
    public Response update(String id, String name) {
        int result = classifyService.update(id, name);
        if (result > 0) {
            return Response.createSuccessResponse("成功");
        } else {
            return Response.createErrorResponse("失败");
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public Response delete(String id) {
        int result = classifyService.delete(id);
        if (result > 0) {
            return Response.createSuccessResponse("succcess");
        }
        return Response.createErrorResponse("失败");
    }
}
