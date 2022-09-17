package com.zd.baseframework.core.core.systemlog;

import com.zd.baseframework.common.entity.service.PageBo;
import com.zd.baseframework.common.entity.service.PageQueryBo;
import com.zd.baseframework.core.core.systemlog.model.SystemLogBo;
import com.zd.baseframework.core.core.systemlog.model.SystemLogQueryBo;

import java.util.List;

public interface ISystemLogServcie {

    String createSystemLog(SystemLogBo systemLogBo);

    List<SystemLogBo> listByCondition(SystemLogQueryBo systemLogQueryBo);

    PageBo<SystemLogBo> pageSearch(PageQueryBo pageParam, String bizId, String code);
}
