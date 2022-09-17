package com.zd.baseframework.core.restful.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.zd.baseframework.common.entity.restful.BaseVo;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SystemLogVo extends BaseVo implements Serializable {

    private String bizId;

    private String userId;

    private String trackUid;

    private String code;

    private String customCode;

    private Integer status;

    private String cname;

    private String cid;

    /*文案属性*/
    private String statusName;

}
