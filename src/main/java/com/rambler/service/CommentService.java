package com.rambler.service;

import com.rambler.beans.Comment;
import com.rambler.beans.CourseComment;
import com.rambler.beans.User;
import com.rambler.dao.CommentMapper;
import com.rambler.dao.CourseCommentMapper;
import com.rambler.utils.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private CourseCommentMapper courseCommentMapper;

    public List<Comment> getCourseComment(String courseId){
        return commentMapper.getCommentByCourseId(courseId);
    }

    public Comment addComment(User user,String content,String courseId){
        String id = IDUtil.uuid();
        // 维护评价表
        Comment comment = new Comment();
        comment.setId(id);
        comment.setTime(new Date());
        comment.setContent(content);
        comment.setCommentUserId(user.getId());
        commentMapper.insert(comment);
        // 维护课程-评价表
        CourseComment courseComment = new CourseComment();
        courseComment.setCourseId(courseId);
        courseComment.setCommentId(id);
        courseCommentMapper.insert(courseComment);
        return comment;
    }

    public Comment test(){
        return null;
    }
}
