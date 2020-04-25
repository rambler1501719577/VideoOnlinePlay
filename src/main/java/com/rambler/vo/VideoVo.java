package com.rambler.vo;

import com.rambler.beans.Course;

public class VideoVo {
    private String id;
    private String name;
    private String src;
    private String auth;

    public VideoVo(Course course,String username){
        this.id = course.getId();
        this.name = course.getName();
        this.src = course.getPlaySrc();
        this.auth = username;
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

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
