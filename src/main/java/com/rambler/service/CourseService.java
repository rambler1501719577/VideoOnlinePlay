package com.rambler.service;

import com.rambler.beans.Course;
import com.rambler.beans.UserCourseApply;
import com.rambler.dao.CourseMapper;
import com.rambler.dao.UserCourseApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserCourseApplyMapper userCourseApplyMapper;

    public List<Course> getCourseByClassifyId(String classifyId) {
        return courseMapper.getByClassifyId(classifyId);
    }

    public Course getCourseById(String id){
        return courseMapper.selectByPrimaryKey(id);
    }

    public boolean attendCourse(String courseId,String userId){
        List<UserCourseApply> list = userCourseApplyMapper.getApplyByUser(userId,courseId);
        if(list.size()>0){
            return false;
        }
        UserCourseApply userCourseApply = new UserCourseApply();
        userCourseApply.setApplyTime(new Date());
        userCourseApply.setUserId(userId);
        userCourseApply.setCourseId(courseId);
        userCourseApplyMapper.insert(userCourseApply);
        return true;
    }

    public List<Course> getCourseByUserId(String userId){
        return courseMapper.getCourseByUser(userId);
    }
}
