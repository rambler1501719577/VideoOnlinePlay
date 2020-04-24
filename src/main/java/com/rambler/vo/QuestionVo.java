package com.rambler.vo;

import com.rambler.beans.Question;

public class QuestionVo {
    private String id;

    private String course;

    private String question1;

    private String question2;

    private String question3;

    private String question4;

    private String question5;

    private String question6;

    private String question7;

    private String question8;

    private String question9;

    private String question10;

    private Integer score;

    private String username;

    public QuestionVo(Question question, String courseName) {
        this.course = courseName;
        this.id = question.getId();
        this.question1 = question.getQuestion1();
        this.question2 = question.getQuestion2();
        this.question3 = question.getQuestion3();
        this.question4 = question.getQuestion4();
        this.question5 = question.getQuestion5();
        this.question6 = question.getQuestion6();
        this.question7 = question.getQuestion7();
        this.question8 = question.getQuestion8();
        this.question9 = question.getQuestion9();
        this.question10 = question.getQuestion10();
        this.score = question.getScore();
    }

    public QuestionVo(Question question, String username,String courseName) {
        this.username = username;
        this.course = courseName;
        this.id = question.getId();
        this.question1 = question.getQuestion1();
        this.question2 = question.getQuestion2();
        this.question3 = question.getQuestion3();
        this.question4 = question.getQuestion4();
        this.question5 = question.getQuestion5();
        this.question6 = question.getQuestion6();
        this.question7 = question.getQuestion7();
        this.question8 = question.getQuestion8();
        this.question9 = question.getQuestion9();
        this.question10 = question.getQuestion10();
        this.score = question.getScore();
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

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public void setQuestion4(String question4) {
        this.question4 = question4;
    }

    public String getQuestion5() {
        return question5;
    }

    public void setQuestion5(String question5) {
        this.question5 = question5;
    }

    public String getQuestion6() {
        return question6;
    }

    public void setQuestion6(String question6) {
        this.question6 = question6;
    }

    public String getQuestion7() {
        return question7;
    }

    public void setQuestion7(String question7) {
        this.question7 = question7;
    }

    public String getQuestion8() {
        return question8;
    }

    public void setQuestion8(String question8) {
        this.question8 = question8;
    }

    public String getQuestion9() {
        return question9;
    }

    public void setQuestion9(String question9) {
        this.question9 = question9;
    }

    public String getQuestion10() {
        return question10;
    }

    public void setQuestion10(String question10) {
        this.question10 = question10;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
