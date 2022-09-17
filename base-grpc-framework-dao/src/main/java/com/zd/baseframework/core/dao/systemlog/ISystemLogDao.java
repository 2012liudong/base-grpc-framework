package com.zd.baseframework.core.dao.systemlog;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zd.baseframework.core.dao.systemlog.entry.SystemLogEntity;
import com.zd.baseframework.core.dao.systemlog.entry.SystemLogQuery;

import java.util.List;

public interface ISystemLogDao  extends IService<SystemLogEntity> {

    List<SystemLogEntity> listByCondition(SystemLogQuery query);

    IPage<SystemLogEntity> pageSystemLog(IPage<SystemLogEntity> iPage, String bizId, String code);
}
