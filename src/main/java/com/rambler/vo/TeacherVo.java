package com.rambler.vo;

import com.rambler.beans.Course;
import com.rambler.beans.User;

import java.util.List;

public class TeacherVo {
    private String id;
    private String name;
    private String telephone;
    private String course;

    public TeacherVo(User user, List<Course> courses) {
        this.id = user.getId();
        this.name = user.getName();
        this.telephone = user.getTelephone();
        String courseStr = "";
        if (courses != null && courses.size() > 0) {
            for (Course course : courses) {
                courseStr += "《" + course.getName() + "》" + ",";
            }
            courseStr = courseStr.substring(0, courseStr.length() - 1);
        }
        this.course = courseStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
