package com.zd.baseframework.common.exception;

/**
 * @author liudong
 * @Title: AppException
 * @Description base business exception
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
