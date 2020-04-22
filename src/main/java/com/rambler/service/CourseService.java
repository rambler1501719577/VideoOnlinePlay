package com.rambler.service;

import com.rambler.beans.Course;
import com.rambler.dao.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public List<Course> getCourseByClassifyId(String classifyId) {
        return courseMapper.getByClassifyId(classifyId);
    }

    public Course getCourseById(String id){
        return courseMapper.selectByPrimaryKey(id);
    }
}
