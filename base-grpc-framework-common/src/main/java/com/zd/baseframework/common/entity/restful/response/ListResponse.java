package com.zd.baseframework.common.entity.restful.response;

import com.zd.baseframework.common.constant.ResponseConst;
import lombok.Data;

import java.util.List;

@Data
public class ListResponse<T> extends BaseResponse<T> {

    /*数据的总条数*/
    private Integer total;

    public ListResponse() {
        super();
    }

    public ListResponse(Integer status, String message) {
        super(status, message);
    }

    public ListResponse(Integer status, String msg, T data) {
        super(status, msg, data);
    }

    public ListResponse(Integer status, String msg, T data, Integer total) {
        super(status, msg, data);
        this.total = Integer.valueOf(total == null ? 0 : total);
    }

    /*调用成功的方法*/
    public static <T> ListResponse<T> success() {
        return new ListResponse<>(ResponseConst.SUCCESS, ResponseConst.Msg.SUCCESS);
    }

    public static <T> ListResponse<T> success(List data) {
        int size = (data != null) ? data.size():0;
        return new ListResponse(ResponseConst.SUCCESS, ResponseConst.Msg.SUCCESS, data, size);
    }

    public static <T> ListResponse<T> success(List data, Integer total) {
        return new ListResponse(ResponseConst.SUCCESS, ResponseConst.Msg.SUCCESS, data, total);
    }
}
