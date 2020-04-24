package com.rambler.config;

/**
 * 对外统一的出口进行封装
 *
 * @author rambler
 * @since 2019-09-13 23:23
 */
public class TableResponse<T> {
    /* 状态码 */
    private Integer code;
    /* 提示消息 */
    private String msg;
    /* 总记录数 */
    public int count;
    /* 具体返回的数据 */
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private TableResponse(Integer code, String message, int count, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
        this.count = count;
    }

    /**
     * 返回成功Response对象
     *
     * @param successMessage 成功提示信息
     * @param data           需要返回的数据
     * @return 成功信息
     */
    public static <T> TableResponse<T> createSuccessResponse(String successMessage, T data, int total) {
        return new TableResponse<>(0, successMessage, total, data);
    }

    public static <T> TableResponse<T> createErrorResponse(String message) {
        return new TableResponse<>(1, message, 0, null);
    }
}
