package com.rambler.controller;

import com.rambler.beans.Comment;
import com.rambler.beans.User;
import com.rambler.config.Response;
import com.rambler.service.CommentService;
import com.rambler.service.UserService;
import com.rambler.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    @ResponseBody
    public Response getCommentByCourseId(String courseId) {
        List<Comment> commentList = commentService.getCourseComment(courseId);
        List<CommentVo> list = new ArrayList<>();
        for (Comment comment : commentList) {
            User user = userService.getUserById(comment.getCommentUserId());
            CommentVo vo = new CommentVo(comment, user);
            list.add(vo);
        }
        return Response.createSuccessResponse(list);
    }

}
