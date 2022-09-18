package com.zd.baseframework.core.restful.model.translator;

import com.zd.baseframework.common.entity.convert.MapStructTransaltorUtil;
import com.zd.baseframework.core.core.systemlog.model.SystemLogBo;
import com.zd.baseframework.core.core.systemlog.model.SystemLogQueryBo;
import com.zd.baseframework.core.restful.model.request.SystemLogQueryRequest;
import com.zd.baseframework.core.restful.model.vo.SystemLogVo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-18T11:02:17+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
public class SystemLogRestTranslatorImpl implements SystemLogRestTranslator {

    @Override
    public SystemLogQueryBo toBo(SystemLogQueryRequest var1) {
        if ( var1 == null ) {
            return null;
        }

        SystemLogQueryBo systemLogQueryBo = new SystemLogQueryBo();

        if ( var1.getBizId() != null ) {
            systemLogQueryBo.setBizId( var1.getBizId() );
        }
        if ( var1.getCode() != null ) {
            systemLogQueryBo.setCode( var1.getCode() );
        }

        return systemLogQueryBo;
    }

    @Override
    public SystemLogVo toVo(SystemLogBo var) {
        if ( var == null ) {
            return null;
        }

        SystemLogVo systemLogVo = new SystemLogVo();

        if ( var.getId() != null ) {
            systemLogVo.setId( var.getId() );
        }
        if ( var.getCtime() != null ) {
            systemLogVo.setCtime( var.getCtime() );
        }
        if ( var.getUtime() != null ) {
            systemLogVo.setUtime( var.getUtime() );
        }
        if ( var.getBizId() != null ) {
            systemLogVo.setBizId( var.getBizId() );
        }
        if ( var.getUserId() != null ) {
            systemLogVo.setUserId( var.getUserId() );
        }
        if ( var.getTrackUid() != null ) {
            systemLogVo.setTrackUid( var.getTrackUid() );
        }
        if ( var.getCode() != null ) {
            systemLogVo.setCode( var.getCode() );
        }
        if ( var.getCustomCode() != null ) {
            systemLogVo.setCustomCode( var.getCustomCode() );
        }
        if ( var.getStatus() != null ) {
            systemLogVo.setStatus( var.getStatus() );
        }
        if ( var.getCname() != null ) {
            systemLogVo.setCname( var.getCname() );
        }
        if ( var.getCid() != null ) {
            systemLogVo.setCid( var.getCid() );
        }
        if ( var.getStatusName() != null ) {
            systemLogVo.setStatusName( var.getStatusName() );
        }

        return systemLogVo;
    }

    @Override
    public List<SystemLogVo> toVo(List<SystemLogBo> var1) {
        if ( var1 == null ) {
            return null;
        }

        List<SystemLogVo> list = new ArrayList<SystemLogVo>( var1.size() );
        for ( SystemLogBo systemLogBo : var1 ) {
            list.add( toVo( systemLogBo ) );
        }

        return list;
    }
}
