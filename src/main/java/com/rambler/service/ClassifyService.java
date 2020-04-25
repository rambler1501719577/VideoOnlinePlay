package com.rambler.service;

import com.rambler.beans.Classify;
import com.rambler.config.TableResponse;
import com.rambler.dao.ClassifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyService {
    @Autowired
    private ClassifyMapper classifyMapper;

    public TableResponse getAllClassify(Integer page, Integer limit) {
        List<Classify> list = classifyMapper.selectAll();
        List<Classify> result = classifyMapper.selectList((page - 1) * limit, limit);
        return TableResponse.createSuccessResponse("",result,list.size());
    }

    public Classify getClassifyByName(String classifyName) {
        return classifyMapper.getByName(classifyName);
    }

    public int update(String id, String name) {
        Classify classify = new Classify();
        classify.setId(id);
        classify.setName(name);
        return classifyMapper.updateByPrimaryKey(classify);
    }

    public int delete(String id) {
        return classifyMapper.deleteByPrimaryKey(id);
    }
}
