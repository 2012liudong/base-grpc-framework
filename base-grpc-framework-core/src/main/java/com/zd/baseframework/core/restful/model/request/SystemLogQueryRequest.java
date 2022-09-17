package com.zd.baseframework.core.restful.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.zd.baseframework.common.entity.restful.PageParamReq;
import lombok.Data;

import java.io.Serializable;

/**
 * @Title: com.zd.baseframework.core.controller.request.SystemLogRequest
 * @Description 查询请求参数包装对象
 * @author liudong
 * @date 2022/6/14 1:54 PM
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SystemLogQueryRequest extends PageParamReq implements Serializable {

    private String bizId;

    private String code;

}