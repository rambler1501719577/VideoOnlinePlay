package com.rambler.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SurveyVo {
    private String id;
    private String course;
    private String time;
    private String username;

    public SurveyVo(String id, String course, Date time,String username) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time = format.format(time);
        this.id = id;
        this.course = course;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
