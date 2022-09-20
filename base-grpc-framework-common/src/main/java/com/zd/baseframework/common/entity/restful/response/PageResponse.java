package com.zd.baseframework.common.entity.restful.response;

import com.zd.baseframework.common.constant.ResponseConst;
import lombok.Data;

/**
 * @author liudong
 * @Title: com.zd.baseframework.common.entity.http.PageResponseEntity
 * @Description 分页响应对象
 * @date 2022/1/23 7:30 PM
 */
@Data
public class PageResponse<T> extends ListResponse<T> {

    /**record offset position for internal calculation*/
    private Integer offset;

    /**size of one page*/
    private Integer pageSize;

    /**number of pages*/
    private Integer currentPage;

    public PageResponse() {
        super();
    }

    public PageResponse(Integer status, String message) {
        super(status, message);
    }

    public PageResponse(Integer status, String msg, T data) {
        super(status, msg, data);
    }

    public PageResponse(Integer status, String msg, T data, Integer total, Integer offset, Integer pageSize, Integer currentPage) {
        super(status, msg, data, total);
        this.offset = offset;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public static <T> PageResponse<T> success() {
        return new PageResponse<>(ResponseConst.SUCCESS, ResponseConst.Msg.SUCCESS);
    }

    public static <T> PageResponse<T> success(T data, Integer total, Integer offset, Integer pageSize, Integer currentPage) {
        return new PageResponse<>(ResponseConst.SUCCESS, ResponseConst.Msg.SUCCESS, data,
                total, offset, pageSize, currentPage);
    }
}
