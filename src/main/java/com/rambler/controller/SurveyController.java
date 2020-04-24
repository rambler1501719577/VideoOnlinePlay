package com.rambler.controller;

import com.rambler.beans.Survey;
import com.rambler.beans.User;
import com.rambler.config.Response;
import com.rambler.service.SurveyService;
import com.rambler.utils.BasicUtil;
import com.rambler.utils.IDUtil;
import com.rambler.vo.SurveyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("survey")
public class SurveyController extends BaseController {

    @Autowired
    private SurveyService surveyService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Response insert(HttpServletRequest request, Survey survey, String courseId) {
        User user = BasicUtil.getCurrentUser(request);
        if (user == null) {
            return Response.createErrorResponse("未登录, 提交失败");
        }
        if (surveyService.getSurveySizeByUser(user.getId(), courseId) > 0) {
            return Response.createErrorResponse("您已经提交过了!!");
        }
        survey.setCourseId(courseId);
        survey.setUserId(user.getId());
        survey.setTime(new Date());
        survey.setId(IDUtil.uuid());
        surveyService.add(survey);
        return Response.createSuccessResponse(survey);
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public Response insert(HttpServletRequest request) {
        User user = getSessionUser(request);
        if (user == null) {
            return Response.createErrorResponse("获取评价错误");
        }
        List<SurveyVo> list = surveyService.getSurveyList(user.getId());
        return Response.createSuccessResponse(list);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public Response get(String id) {
        Survey survey =  surveyService.get(id);
        return Response.createSuccessResponse(survey);
    }
}
