package com.rambler.service;

import com.rambler.beans.Course;
import com.rambler.beans.User;
import com.rambler.beans.UserCourseApply;
import com.rambler.config.TableResponse;
import com.rambler.dao.CourseMapper;
import com.rambler.dao.UserCourseApplyMapper;
import com.rambler.dao.UserMapper;
import com.rambler.vo.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserCourseApplyMapper userCourseApplyMapper;

    @Autowired
    private UserMapper userMapper;

    public List<Course> getCourseByClassifyId(String classifyId) {
        return courseMapper.getByClassifyId(classifyId);
    }

    public Course getCourseById(String id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    public boolean attendCourse(String courseId, String userId) {
        List<UserCourseApply> list = userCourseApplyMapper.getApplyByUser(userId, courseId);
        if (list.size() > 0) {
            return false;
        }
        Course course = courseMapper.selectByPrimaryKey(courseId);
        course.setStudyTimes(course.getStudyTimes() + 1);
        courseMapper.updateByPrimaryKey(course);
        UserCourseApply userCourseApply = new UserCourseApply();
        userCourseApply.setApplyTime(new Date());
        userCourseApply.setUserId(userId);
        userCourseApply.setCourseId(courseId);
        userCourseApplyMapper.insert(userCourseApply);
        return true;
    }

    public List<Course> getCourseByUserId(String userId) {
        return courseMapper.getCourseByUser(userId);
    }

    public List<Course> getCourseList(){
        return courseMapper.selectAll();
    }

    public TableResponse getVideoList(Integer page, Integer limit) {
        List<Course> all = courseMapper.selectAll();
        List<VideoVo> result = new ArrayList<>();
        List<Course> list = courseMapper.selectList((page - 1) * limit, limit);
        for (Course course : list) {
            User user = userMapper.selectByPrimaryKey(course.getTeacherId());
            result.add(new VideoVo(course, user.getName()));
        }
        return TableResponse.createSuccessResponse("",result,all.size());
    }

    public int removeVideo(String id){
        Course course = courseMapper.selectByPrimaryKey(id);
        course.setPlaySrc("");
        return courseMapper.updateByPrimaryKey(course);
    }
}
