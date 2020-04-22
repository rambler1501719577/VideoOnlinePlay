package com.rambler.service;

import com.rambler.beans.Comment;
import com.rambler.dao.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> getCourseComment(String courseId){
        return commentMapper.getCommentByCourseId(courseId);
    }
}
