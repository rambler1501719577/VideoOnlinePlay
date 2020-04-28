package com.rambler.beans;

import java.util.Date;

public class Course {
    private String id;

    private String teacherId;

    private String classifyId;

    private String name;

    private String description;

    private Date createTime;

    private String playSrc;

    private Integer requireLevel;

    private Integer studyTimes;

    private String coverImage;
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId == null ? null : classifyId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPlaySrc() {
        return playSrc;
    }

    public void setPlaySrc(String playSrc) {
        this.playSrc = playSrc == null ? null : playSrc.trim();
    }

    public Integer getRequireLevel() {
        return requireLevel;
    }

    public void setRequireLevel(Integer requireLevel) {
        this.requireLevel = requireLevel;
    }

    public Integer getStudyTimes() {
        return studyTimes;
    }

    public void setStudyTimes(Integer studyTimes) {
        this.studyTimes = studyTimes;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}