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

    /*偏移位置，用于内部计算*/
    private Integer offset;
    /*每页多少条*/
    private Integer pageSize;
    /*当前第几页*/
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

    /**这个构建函数是为了适应mybatis插件的特殊参数类型， 在mybatis中属性对应关系如下：
     *  Math.toIntExact(total) // IPage.getTotal()
     *  Math.toIntExact(offset) // IPage.offset()
     *  Math.toIntExact(pageSize) // IPage.getSize()
     *  Math.toIntExact(currentPage)); // IPage.getCurrent()
     * */
    public PageResponse(Integer status, String msg, T data, Long total, Long offset, Long pageSize, Long currentPage) {
        this(status, msg, data
                , Math.toIntExact(total)
                , Math.toIntExact(offset)
                , Math.toIntExact(pageSize)
                , Math.toIntExact(currentPage));
    }

    public static <T> PageResponse<T> success() {
        return new PageResponse<>(ResponseConst.SUCCESS, ResponseConst.Msg.SUCCESS);
    }
}
