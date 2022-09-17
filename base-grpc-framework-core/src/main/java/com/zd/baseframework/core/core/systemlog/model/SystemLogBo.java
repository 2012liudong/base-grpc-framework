package com.zd.baseframework.core.core.systemlog.model;

import com.zd.baseframework.common.entity.service.BaseBo;
import lombok.Data;

@Data
public class SystemLogBo extends BaseBo {

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
