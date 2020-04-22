package com.rambler.controller;

import com.rambler.beans.Classify;
import com.rambler.beans.Course;
import com.rambler.config.Response;
import com.rambler.service.ClassifyService;
import com.rambler.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ClassifyService classifyService;

    @ResponseBody
    @RequestMapping("/getCourse")
    public Response getCourseByClassify(String classifyName) {
        Classify classify = classifyService.getClassifyByName(classifyName);
        if (classify.getId() != null) {
            List<Course> list = courseService.getCourseByClassifyId(classify.getId());
            return Response.createSuccessResponse(list);
        }
        return Response.createSuccessResponse(null);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public Response getDetailById(String id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return Response.createSuccessResponse(course);
        }
        return Response.createErrorResponse("不存在");
    }
}
