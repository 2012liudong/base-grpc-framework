package com.zd.baseframework.core.dao.systemlog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zd.baseframework.core.dao.systemlog.entry.SystemLogEntity;
import org.apache.ibatis.annotations.Param;

public interface SystemLogMapper  extends BaseMapper<SystemLogEntity> {

    IPage<SystemLogEntity> pageSystemLog(IPage<SystemLogEntity> iPage,
                                         @Param("bizId") String bizId,
                                         @Param("code") String code);
}
