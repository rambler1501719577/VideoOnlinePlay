package com.rambler.service;

import com.rambler.beans.Course;
import com.rambler.beans.Survey;
import com.rambler.beans.User;
import com.rambler.config.Response;
import com.rambler.config.TableResponse;
import com.rambler.dao.CourseMapper;
import com.rambler.dao.SurveyMapper;
import com.rambler.dao.UserMapper;
import com.rambler.vo.SurveyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    public void add(Survey survey) {
        surveyMapper.insert(survey);
    }

    public int getSurveySizeByUser(String userId, String courseId) {
        List<Survey> list = surveyMapper.selectByUser(userId, courseId);
        return list == null ? 0 : list.size();
    }

    public List<SurveyVo> getSurveyList(String teacherId) {
        List<SurveyVo> result = new ArrayList<>();
        List<Course> courseList = courseMapper.getTeacherCourse(teacherId);
        for (Course course : courseList) {
            List<Survey> temp = surveyMapper.getSurveyByCourseId(course.getId());
            for (Survey s : temp) {
                User user = userMapper.selectByPrimaryKey(s.getUserId());
                result.add(new SurveyVo(s.getId(), course.getName(), s.getTime(), user.getName()));
            }
        }
        return result;
    }

    public Survey get(String id) {
        return surveyMapper.selectByPrimaryKey(id);
    }

    public TableResponse getPageList(Integer page, Integer limit) {
        List<Survey> surveys = surveyMapper.getPageData((page - 1) * limit, limit);
        int length = surveyMapper.getAll().size();
        return TableResponse.createSuccessResponse("", surveys, length);
    }

    public Response delete(String id) {
        int result = surveyMapper.deleteByPrimaryKey(id);
        if (result > 0) {
            return Response.createSuccessResponse("删除成功");
        }
        return Response.createErrorResponse("删除失败");
    }
}
