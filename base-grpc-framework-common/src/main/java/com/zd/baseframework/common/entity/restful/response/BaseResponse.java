package com.zd.baseframework.common.entity.restful.response;

import com.zd.baseframework.common.constant.ResponseConst;
import lombok.Data;

/**
 * @author liudong
 * @Title: com.zd.baseframework.common.entity.http.ResponseEntity
 * http status to see HttpStatus.java
 * @Description used for restful access response
 * @date 2022/1/23 7:00 PM
 */
@Data
public class BaseResponse<T> {
    /**response code*/
    private Integer status;

    /**response message*/
    private String msg;

    /**response data records*/
    private T data;

    public BaseResponse() {
        this(null, null, null);
    }

    public BaseResponse(Integer status, String msg) {
        this(status, msg, null);
    }

    public BaseResponse(Integer status, String msg, T data) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    /**success*/
    public static <T> BaseResponse<T> success() {
        return new BaseResponse<>(ResponseConst.SUCCESS, ResponseConst.Msg.SUCCESS);
    }

    public static <T> BaseResponse<T> success(T o) {
        return new BaseResponse<>(ResponseConst.SUCCESS, ResponseConst.Msg.SUCCESS, o);
    }

    /**fail*/
    public static <T> BaseResponse<T> error() {
        return new BaseResponse<>(ResponseConst.FAIL, ResponseConst.Msg.FAIL);
    }

    public static <T> BaseResponse<T> error(String msg) {
        return new BaseResponse<>(ResponseConst.FAIL, msg);
    }

    public static <T> BaseResponse<T> error(Integer status, String msg) {
        return new BaseResponse<>(status, msg);
    }
}
