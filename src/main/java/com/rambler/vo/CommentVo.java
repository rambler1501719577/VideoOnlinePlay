package com.rambler.vo;

import com.rambler.beans.Comment;
import com.rambler.beans.User;
import java.text.SimpleDateFormat;

public class CommentVo {
    private String id;
    private String time;
    private String content;
    private String commentUserId;
    private String userId;
    private String name;
    private String header;

    public CommentVo(Comment comment, User user){
        this.id = comment.getId();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time = format.format(comment.getTime());
        this.content = comment.getContent();
        this.commentUserId = comment.getCommentUserId();
        this.userId = user.getId();
        this.name = user.getName();
        this.header = user.getHeader();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
