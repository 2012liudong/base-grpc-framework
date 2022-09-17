package com.zd.baseframework.core.core.systemlog.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zd.baseframework.common.entity.service.PageBo;
import com.zd.baseframework.common.entity.service.PageQueryBo;
import com.zd.baseframework.common.exception.AppException;
import com.zd.baseframework.common.util.LogGenerator;
import com.zd.baseframework.common.util.PageUtil;
import com.zd.baseframework.core.core.systemlog.ISystemLogServcie;
import com.zd.baseframework.core.core.systemlog.model.SystemLogBo;
import com.zd.baseframework.core.core.systemlog.model.SystemLogBoTranslator;
import com.zd.baseframework.core.core.systemlog.model.SystemLogQueryBo;
import com.zd.baseframework.core.dao.systemlog.ISystemLogDao;
import com.zd.baseframework.core.dao.systemlog.entry.SystemLogEntity;
import com.zd.baseframework.core.dao.systemlog.entry.SystemLogQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Primary
public class SystemLogServcieImpl implements ISystemLogServcie {

    @Autowired
    private ISystemLogDao iSystemLogDao;

    @Override
    public String createSystemLog(SystemLogBo systemLogBo) {
        String trackLog = LogGenerator.trackLog();
        log.info(trackLog
                + "systemLogContent=" + JSONUtil.toJsonStr(systemLogBo)
        );
        try{
            SystemLogEntity entity = SystemLogBoTranslator.INSTANCE.toEntry(systemLogBo);
            iSystemLogDao.save(entity);
            log.info(trackLog
                    + "uuid=" + entity.getId()
            );
            return entity.getId();

        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<SystemLogBo> listByCondition(SystemLogQueryBo systemLogQueryBo) {
        String trackLog = LogGenerator.trackLog();
        log.info(trackLog
                + "queryParam=" + JSONUtil.toJsonStr(systemLogQueryBo) );
        try{
            SystemLogQuery entity = SystemLogBoTranslator.INSTANCE.toEntry(systemLogQueryBo);

            List<SystemLogEntity> resut = iSystemLogDao.listByCondition(entity);

            log.info(trackLog
                    + "resultSize=" + CollUtil.size(resut) );

            return SystemLogBoTranslator.INSTANCE.toBo(resut);

        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public PageBo<SystemLogBo> pageSearch(PageQueryBo pageParam, String bizId, String code) {
        String trackLog = LogGenerator.trackLog();
        log.info(trackLog
                + "bizId=" + bizId
                + " code=" + code );
        try{
            //构建查询参数
            IPage<SystemLogEntity> iPage = PageUtil.convertBo2IpageForReq(pageParam);
            iPage = iSystemLogDao.pageSystemLog(iPage, bizId, code);

            log.info(trackLog
                    + "resultSize=" + CollUtil.size(iPage.getRecords()) );

            //处理返回结果
            PageBo<SystemLogBo> reuslt = PageUtil.convertIpage2BoForRes(iPage);
            List<SystemLogBo> databaseBos =  SystemLogBoTranslator.INSTANCE.toBo(iPage.getRecords());
            reuslt.setData(databaseBos);
            return reuslt;
        } catch (AppException e) {
            throw e;
        }
    }
}