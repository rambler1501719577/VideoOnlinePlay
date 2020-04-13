package com.rambler.config;

/**
 * @author rambler
 * @since 2020-02-02 17:11
 */
public class Variable {
    /* 成功状态码 */
    public static final Integer SUCCESS = 200;
    /* 失败状态码 */
    public static final Integer ERROR = 201;
    /* 找不到 */
    public static final Integer NOT_FOUND = 404;
    /* 服务器处理错误, 如参数错误 */
    public static final Integer SERVER_ERROR = 500;

    /* 用户部分 */
    public static final String CURRENT_USER = "user";
    public static final Integer STATUS_NORMAL = 0;
    public static final Integer STATUS_DELETED = 1;
    public static final Integer STATUS_OTHER = 2;

    public static final String TEACHER_ROIE_ID = "608d103440ed4e4281e7f9b6332c80bf";
}
