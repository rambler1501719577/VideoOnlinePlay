package com.rambler.controller;

import com.rambler.beans.Classify;
import com.rambler.beans.Course;
import com.rambler.beans.User;
import com.rambler.config.Response;
import com.rambler.config.TableResponse;
import com.rambler.service.ClassifyService;
import com.rambler.service.CourseService;
import com.rambler.utils.BasicUtil;
import com.rambler.vo.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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

    @ResponseBody
    @RequestMapping("video")
    public TableResponse getVideoList(Integer page, Integer limit) {
        return courseService.getVideoList(page, limit);
    }

    @ResponseBody
    @RequestMapping("removeVideo")
    public Response getUserCourse(String id) {
        int result = courseService.removeVideo(id);
        if (result > 0) {
            return Response.createSuccessResponse("success");
        }
        return Response.createErrorResponse("error");
    }

    @ResponseBody
    @RequestMapping("tableList")
    public TableResponse getTableList(Integer page, Integer limit) {
        return courseService.getPageData(page, limit);
    }

    @RequestMapping("delete")
    @ResponseBody
    public Response deleteCourse(String id) {
        int result = courseService.deleteCourse(id);
        if (result > 0) {
            return Response.createSuccessResponse("删除成功");
        }
        return Response.createErrorResponse("删除失败");
    }

    @ResponseBody
    @RequestMapping("requestTableList")
    public TableResponse getRequestTableList(Integer page, Integer limit) {
        return courseService.getRequestPageData(page, limit);
    }

    @ResponseBody
    @RequestMapping("agree")
    public Response agree(String id) {
        // 1表示通过
        int result = courseService.apply(id, 0);
        if (result > 0) {
            return Response.createSuccessResponse("审批成功");
        }
        return Response.createErrorResponse("审批失败");
    }

    @ResponseBody
    @RequestMapping("disagree")
    public Response disagree(String id) {
        // 不通过就是删除了!!
        int result = courseService.apply(id, 1);
        if (result > 0) {
            return Response.createSuccessResponse("审批成功");
        }
        return Response.createErrorResponse("审批失败");
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addCourse(HttpServletRequest request, String classify, String title, String description, @RequestParam(value = "video", required = false) MultipartFile video,
                          @RequestParam(value = "coverImage", required = false) MultipartFile coverImage) {
        int result = courseService.addNewCourse(classify,title,description,video,coverImage,request);
        if(result>0){
            return "index/alert.html";
        }
        return "index/error.html";
    }

}
