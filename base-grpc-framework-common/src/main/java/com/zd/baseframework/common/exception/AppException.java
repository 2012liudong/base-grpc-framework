package com.zd.baseframework.common.exception;

/**
 * @author liudong
 * @Title: AppException
 * @Description 基础异常类，用于处理普通业务上的异常，直接抛送即可，定义不同的异常类主要是用于区别异常的类型
 * @date 2022/1/17 4:52 PM
 */
public class AppException extends RuntimeException {

    private static final long serialVersionUID = 2035762217851684358L;

    private Integer status;

    public AppException() {
        super();
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public AppException(Throwable throwable) {
        super(throwable);
    }

    public AppException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

}
