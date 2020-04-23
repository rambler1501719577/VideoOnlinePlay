package com.rambler.service;

import com.rambler.beans.Question;
import com.rambler.dao.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    public void add(Question question) {
        questionMapper.insert(question);
    }

    public int getQuestionByUser(String userId,String courseId) {
        List<Question> list = questionMapper.getQuestionByUserId(userId,courseId);
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
