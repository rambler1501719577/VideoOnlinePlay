package com.rambler.controller;

import com.rambler.beans.Course;
import com.rambler.config.Response;
import com.rambler.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("analyze")
public class AnalyzeController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("option")
    @ResponseBody
    public Response getOption() {
        List<Course> list = courseService.getCourseList();
        List<Integer> x = new ArrayList<>();
        List<String> y = new ArrayList<>();
        for (Course c : list) {
            x.add(c.getStudyTimes());
            y.add(c.getName());
        }
        Map<String, Object> option = new HashMap<>();
        option.put("x", x);
        option.put("y", y);
        return Response.createSuccessResponse(option);
    }

}
