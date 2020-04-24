package com.rambler.controller;

import com.rambler.beans.Question;
import com.rambler.beans.User;
import com.rambler.config.Response;
import com.rambler.config.TableResponse;
import com.rambler.service.QuestionService;
import com.rambler.utils.BasicUtil;
import com.rambler.utils.IDUtil;
import com.rambler.vo.QuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("question")
public class QuestionController extends BaseController {
    @Autowired
    private QuestionService questionService;

    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Response insert(HttpServletRequest request, Question question, String courseId) {
        User user = BasicUtil.getCurrentUser(request);
        if (user == null) {
            return Response.createErrorResponse("未登录, 操作失败");
        }
        if (questionService.getQuestionByUser(user.getId(), courseId) > 0) {
            return Response.createErrorResponse("您已经测试过了");
        }
        question.setUserId(user.getId());
        question.setCourseId(courseId);
        question.setId(IDUtil.uuid());
        question.setStatus(0);// 未批改为0
        questionService.add(question);
        return Response.createSuccessResponse(question);
    }

    @ResponseBody
    @RequestMapping(value = "list")
    public TableResponse getQuestionList(HttpServletRequest request) {
        User user = getSessionUser(request);
        if (user == null) {
            return TableResponse.createErrorResponse("未登陆, 无法查询");
        }
        List<QuestionVo> list = questionService.getQuestionList(user.getId());
        return TableResponse.createSuccessResponse("", list, list.size());
    }

    @ResponseBody
    @RequestMapping(value = "teacherList")
    public TableResponse getTeacherQuestionList(HttpServletRequest request) {
        User user = getSessionUser(request);
        if (user == null) {
            return TableResponse.createErrorResponse("未登陆, 无法查询");
        }
        List<QuestionVo> list = questionService.getTeacherQuestionList(user.getId());
        return TableResponse.createSuccessResponse("", list, list.size());
    }

    @ResponseBody
    @RequestMapping("get")
    public Response get(String id){
        Question question = questionService.getById(id);
        return Response.createSuccessResponse(question);
    }

    @RequestMapping("givemark")
    @ResponseBody
    public Response giveMark(String score,String id){
        int result = questionService.markQuestion(score,id);
        if(result > 0){
            return Response.createSuccessResponse("评分成功");
        }
        return Response.createErrorResponse("失败");
    }
}
