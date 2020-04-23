package com.rambler.service;

import com.rambler.beans.Survey;
import com.rambler.dao.SurveyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private SurveyMapper surveyMapper;

    public void add(Survey survey) {
        surveyMapper.insert(survey);
    }

    public int getSurveySizeByUser(String userId,String courseId) {
        List<Survey> list = surveyMapper.selectByUser(userId,courseId);
        return list == null ? 0 : list.size();
    }
}
