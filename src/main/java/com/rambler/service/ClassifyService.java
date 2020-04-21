package com.rambler.service;

import com.rambler.beans.Classify;
import com.rambler.dao.ClassifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyService {
    @Autowired
    private ClassifyMapper classifyMapper;

    public List<Classify> getAllClassify(){
        return classifyMapper.selectList();
    }

    public Classify getClassifyByName(String classifyName){
        return classifyMapper.getByName(classifyName);
    }
}
