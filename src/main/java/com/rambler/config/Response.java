package com.rambler.config;


/**
 * 对外统一的出口进行封装
 *
 * @author rambler
 * @since 2019-09-13 23:23
 */
public class Response<T> {
    /* 状态码 */
    private Integer code;
    /* 提示消息 */
    private String message;
    /* 具体返回的数据 */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private Response(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private Response(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    /**
     * 返回成功Response对象
     *
     * @param successMessage 成功提示信息
     * @param data           需要返回的数据
     * @return 成功信息
     */
    public static <T> Response<T> createSuccessResponse(String successMessage, T data) {
        return new Response<>(Variable.SUCCESS, successMessage, data);
    }

    /**
     * 只返回成功消息, 默认成功状态码
     *
     * @param successMessage 成功消息
     * @return Response对象
     */
    public static <T> Response createSuccessResponse(String successMessage) {
        return new Response<>(Variable.SUCCESS, successMessage);
    }

    /**
     * 只返回成功消息, 默认成功状态码
     *
     * @param data 返回的数据
     * @return Response对象
     */
    public static <T> Response createSuccessResponse(T data) {
        return new Response<>(Variable.SUCCESS, "成功", data);
    }

    /**
     * 返回错误Response对象
     *
     * @param errorMessage 错误信息
     * @return 错误信息
     */
    public static <T> Response createErrorResponse(String errorMessage) {
        return new Response<>(Variable.ERROR, errorMessage);
    }
}
