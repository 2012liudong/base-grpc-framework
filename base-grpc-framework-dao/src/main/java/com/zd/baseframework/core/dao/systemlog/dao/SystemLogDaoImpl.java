package com.zd.baseframework.core.dao.systemlog.dao;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zd.baseframework.core.dao.systemlog.ISystemLogDao;
import com.zd.baseframework.core.dao.systemlog.entry.SystemLogEntity;
import com.zd.baseframework.core.dao.systemlog.entry.SystemLogQuery;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: com.zd.baseframework.core.dao.systemlog.dao.SystemLogDaoImpl
 * @Description do not suggest using try-catch
 * @author liudong
 * @date 2022/6/15 9:05 PM
 */
@Repository
@Primary
public class SystemLogDaoImpl extends ServiceImpl<SystemLogMapper, SystemLogEntity> implements ISystemLogDao {

    @Override
    public List<SystemLogEntity> listByCondition(SystemLogQuery query) {
        LambdaQueryWrapper<SystemLogEntity> queryWrapper = Wrappers.lambdaQuery();
        if(StrUtil.isNotEmpty(query.getCode())){
            queryWrapper.eq(SystemLogEntity::getCode, query.getCode());
        }
        if(StrUtil.isNotEmpty(query.getBizId())){
            queryWrapper.eq(SystemLogEntity::getBizId, query.getBizId());
        }
        return list(queryWrapper);
    }

    @Override
    public IPage<SystemLogEntity> pageSystemLog(IPage<SystemLogEntity> iPage, String bizId, String code) {
        return this.getBaseMapper().pageSystemLog(iPage, bizId, code);
    }

}
