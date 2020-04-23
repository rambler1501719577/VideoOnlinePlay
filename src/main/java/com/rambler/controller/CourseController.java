package com.rambler.controller;

import com.rambler.beans.Classify;
import com.rambler.beans.Course;
import com.rambler.beans.User;
import com.rambler.config.Response;
import com.rambler.service.ClassifyService;
import com.rambler.service.CourseService;
import com.rambler.utils.BasicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController extends BaseController {

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

    @ResponseBody
    @RequestMapping(value = "attend", method = RequestMethod.POST)
    public Response attend(String id, HttpServletRequest request) {
        User user = getSessionUser(request);
        if (user == null) {
            return Response.createErrorResponse("未登录");
        }
        boolean result = courseService.attendCourse(id, user.getId());
        if (result) {
            return Response.createSuccessResponse("参加成功");
        }
        return Response.createErrorResponse("您已经参加过该课程");
    }

    @ResponseBody
    @RequestMapping("userCourse")
    public Response getUserCourse(HttpServletRequest request) {
        User user = BasicUtil.getCurrentUser(request);
        if (user == null) {
            return Response.createErrorResponse("未登录, 获取课程列表失败");
        }
        List<Course> list = courseService.getCourseByUserId(user.getId());
        return Response.createSuccessResponse(list);
    }
}
