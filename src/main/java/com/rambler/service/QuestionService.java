package com.rambler.service;

import com.rambler.beans.Course;
import com.rambler.beans.Question;
import com.rambler.beans.User;
import com.rambler.dao.CourseMapper;
import com.rambler.dao.QuestionMapper;
import com.rambler.dao.UserMapper;
import com.rambler.vo.QuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    public void add(Question question) {
        questionMapper.insert(question);
    }

    public int getQuestionByUser(String userId, String courseId) {
        List<Question> list = questionMapper.getQuestionByUserId(userId, courseId);
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<QuestionVo> getQuestionList(String userId) {
        List<QuestionVo> result = new ArrayList<>();
        List<Question> list = questionMapper.getQuestionListByUser(userId);
        for (Question question : list) {
            Course course = courseMapper.selectByPrimaryKey(question.getCourseId());
            result.add(new QuestionVo(question, course.getName()));
        }
        return result;
    }

    public List<QuestionVo> getTeacherQuestionList(String userId) {
        List<QuestionVo> res = new ArrayList<>();
        // 获取当前老师教的课
        List<Course> courseList = courseMapper.getTeacherCourse(userId);
        for (Course course : courseList) {
            // 通过课程查询当前课程所有的测试答案
            List<Question> questionList = questionMapper.getQuestionByCourseId(course.getId());
            for (Question question : questionList) {
                User user = userMapper.selectByPrimaryKey(question.getUserId());
                res.add(new QuestionVo(question, user.getName(), course.getName()));
            }
        }
        return res;
    }

    public Question getById(String id) {
        return questionMapper.selectByPrimaryKey(id);
    }

    public int markQuestion(String score, String id) {
        Question q = new Question();
        q.setId(id);
        q.setStatus(1);
        q.setScore(Integer.parseInt(score));
        return questionMapper.updateByPrimaryKeySelective(q);
    }
}
