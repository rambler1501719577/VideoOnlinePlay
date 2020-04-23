package com.rambler.controller;

import com.rambler.beans.Comment;
import com.rambler.beans.User;
import com.rambler.config.Response;
import com.rambler.service.CommentService;
import com.rambler.service.UserService;
import com.rambler.utils.BasicUtil;
import com.rambler.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Response createComment(HttpServletRequest request, String content, String courseId) {
        User user = BasicUtil.getCurrentUser(request);
        if (user != null && user.getId() != null) {
            Comment comment = commentService.addComment(user, content, courseId);
            return Response.createSuccessResponse(comment);
        } else {
            return Response.createErrorResponse("用户未登录");
        }
    }
}
