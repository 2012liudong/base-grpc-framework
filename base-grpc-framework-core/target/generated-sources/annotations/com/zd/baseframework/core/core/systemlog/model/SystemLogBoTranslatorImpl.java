package com.zd.baseframework.core.core.systemlog.model;

import com.zd.baseframework.common.constant.enumeration.AppEnumTranslatorUtil;
import com.zd.baseframework.common.entity.convert.MapStructMapper;
import com.zd.baseframework.common.entity.convert.MapStructTransaltorUtil;
import com.zd.baseframework.core.dao.systemlog.entry.SystemLogEntity;
import com.zd.baseframework.core.dao.systemlog.entry.SystemLogQuery;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-18T13:43:45+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
public class SystemLogBoTranslatorImpl implements SystemLogBoTranslator {

    @Override
    public SystemLogQuery toEntry(SystemLogQueryBo var1) {
        if ( var1 == null ) {
            return null;
        }

        SystemLogQuery systemLogQuery = new SystemLogQuery();

        if ( var1.getBizId() != null ) {
            systemLogQuery.setBizId( var1.getBizId() );
        }
        if ( var1.getCode() != null ) {
            systemLogQuery.setCode( var1.getCode() );
        }

        return systemLogQuery;
    }

    @Override
    public SystemLogEntity toEntry(SystemLogBo var1) {
        if ( var1 == null ) {
            return null;
        }

        SystemLogEntity systemLogEntity = new SystemLogEntity();

        if ( var1.getId() != null ) {
            systemLogEntity.setId( var1.getId() );
        }
        if ( var1.getCtime() != null ) {
            systemLogEntity.setCtime( MapStructMapper.localDateTimeToDate( var1.getCtime() ) );
        }
        if ( var1.getUtime() != null ) {
            systemLogEntity.setUtime( MapStructMapper.localDateTimeToDate( var1.getUtime() ) );
        }
        if ( var1.getBizId() != null ) {
            systemLogEntity.setBizId( var1.getBizId() );
        }
        if ( var1.getUserId() != null ) {
            systemLogEntity.setUserId( var1.getUserId() );
        }
        if ( var1.getTrackUid() != null ) {
            systemLogEntity.setTrackUid( var1.getTrackUid() );
        }
        if ( var1.getCode() != null ) {
            systemLogEntity.setCode( var1.getCode() );
        }
        if ( var1.getCustomCode() != null ) {
            systemLogEntity.setCustomCode( var1.getCustomCode() );
        }
        if ( var1.getStatus() != null ) {
            systemLogEntity.setStatus( var1.getStatus() );
        }
        if ( var1.getCid() != null ) {
            systemLogEntity.setCid( var1.getCid() );
        }
        if ( var1.getCname() != null ) {
            systemLogEntity.setCname( var1.getCname() );
        }

        return systemLogEntity;
    }

    @Override
    public SystemLogBo toBo(SystemLogEntity var1) {
        if ( var1 == null ) {
            return null;
        }

        SystemLogBo systemLogBo = new SystemLogBo();

        if ( var1.getId() != null ) {
            systemLogBo.setId( var1.getId() );
        }
        if ( var1.getCtime() != null ) {
            systemLogBo.setCtime( MapStructMapper.dateToLocalDate( var1.getCtime() ) );
        }
        if ( var1.getUtime() != null ) {
            systemLogBo.setUtime( MapStructMapper.dateToLocalDate( var1.getUtime() ) );
        }
        if ( var1.getBizId() != null ) {
            systemLogBo.setBizId( var1.getBizId() );
        }
        if ( var1.getUserId() != null ) {
            systemLogBo.setUserId( var1.getUserId() );
        }
        if ( var1.getTrackUid() != null ) {
            systemLogBo.setTrackUid( var1.getTrackUid() );
        }
        if ( var1.getCode() != null ) {
            systemLogBo.setCode( var1.getCode() );
        }
        if ( var1.getCustomCode() != null ) {
            systemLogBo.setCustomCode( var1.getCustomCode() );
        }
        if ( var1.getStatus() != null ) {
            systemLogBo.setStatus( var1.getStatus() );
        }
        if ( var1.getCname() != null ) {
            systemLogBo.setCname( var1.getCname() );
        }
        if ( var1.getCid() != null ) {
            systemLogBo.setCid( var1.getCid() );
        }

        systemLogBo.setStatusName( AppEnumTranslatorUtil.getStatus(var1.getStatus()) );

        return systemLogBo;
    }

    @Override
    public List<SystemLogBo> toBo(List<SystemLogEntity> var1) {
        if ( var1 == null ) {
            return null;
        }

        List<SystemLogBo> list = new ArrayList<SystemLogBo>( var1.size() );
        for ( SystemLogEntity systemLogEntity : var1 ) {
            list.add( toBo( systemLogEntity ) );
        }

        return list;
    }
}
