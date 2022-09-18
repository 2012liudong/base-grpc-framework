package com.zd.baseframework.core.grpc.model;

import com.zd.baseframework.common.entity.convert.MapStructMapper;
import com.zd.baseframework.common.entity.convert.MapStructTransaltorUtil;
import com.zd.baseframework.common.entity.service.PageQueryBo;
import com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest;
import com.zd.baseframework.core.api.systemlog.ListSystemLogRequest;
import com.zd.baseframework.core.api.systemlog.PageSystemLogRequest;
import com.zd.baseframework.core.api.systemlog.SystemLogDto;
import com.zd.baseframework.core.api.systemlog.SystemLogDto.Builder;
import com.zd.baseframework.core.core.systemlog.model.SystemLogBo;
import com.zd.baseframework.core.core.systemlog.model.SystemLogQueryBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-18T11:02:17+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
public class SystemLogDtoTranslatorImpl implements SystemLogDtoTranslator {

    @Override
    public SystemLogBo toBo(CreateSystemLogRequest var) {
        if ( var == null ) {
            return null;
        }

        SystemLogBo systemLogBo = new SystemLogBo();

        if ( var.hasBizId() ) {
            systemLogBo.setBizId( MapStructMapper.stringValueToString( var.getBizId() ) );
        }
        if ( var.hasUserId() ) {
            systemLogBo.setUserId( MapStructMapper.stringValueToString( var.getUserId() ) );
        }
        if ( var.hasCode() ) {
            systemLogBo.setCode( MapStructMapper.stringValueToString( var.getCode() ) );
        }
        if ( var.hasCustomCode() ) {
            systemLogBo.setCustomCode( MapStructMapper.stringValueToString( var.getCustomCode() ) );
        }

        return systemLogBo;
    }

    @Override
    public SystemLogQueryBo toBo(ListSystemLogRequest var) {
        if ( var == null ) {
            return null;
        }

        SystemLogQueryBo systemLogQueryBo = new SystemLogQueryBo();

        if ( var.hasBizId() ) {
            systemLogQueryBo.setBizId( MapStructMapper.stringValueToString( var.getBizId() ) );
        }
        if ( var.hasCode() ) {
            systemLogQueryBo.setCode( MapStructMapper.stringValueToString( var.getCode() ) );
        }

        return systemLogQueryBo;
    }

    @Override
    public PageQueryBo toBo(PageSystemLogRequest var) {
        if ( var == null ) {
            return null;
        }

        PageQueryBo pageQueryBo = new PageQueryBo();

        if ( var.hasPageNum() ) {
            pageQueryBo.setPageNum( MapStructMapper.int32ToInteger( var.getPageNum() ) );
        }
        if ( var.hasPageSize() ) {
            pageQueryBo.setPageSize( MapStructMapper.int32ToInteger( var.getPageSize() ) );
        }
        if ( var.hasSortProperty() ) {
            pageQueryBo.setSortProperty( MapStructMapper.stringValueToString( var.getSortProperty() ) );
        }
        if ( var.hasSortType() ) {
            pageQueryBo.setSortType( MapStructMapper.stringValueToString( var.getSortType() ) );
        }

        return pageQueryBo;
    }

    @Override
    public SystemLogDto toDto(SystemLogBo var) {
        if ( var == null ) {
            return null;
        }

        Builder systemLogDto = SystemLogDto.newBuilder();

        if ( var.getId() != null ) {
            systemLogDto.setId( var.getId() );
        }
        if ( var.getBizId() != null ) {
            systemLogDto.setBizId( var.getBizId() );
        }
        if ( var.getUserId() != null ) {
            systemLogDto.setUserId( var.getUserId() );
        }
        if ( var.getTrackUid() != null ) {
            systemLogDto.setTrackUid( var.getTrackUid() );
        }
        if ( var.getCode() != null ) {
            systemLogDto.setCode( var.getCode() );
        }
        if ( var.getCustomCode() != null ) {
            systemLogDto.setCustomCode( var.getCustomCode() );
        }
        if ( var.getCtime() != null ) {
            systemLogDto.setCtime( MapStructMapper.localDateTimetoGoogleTimestamp( var.getCtime() ) );
        }
        if ( var.getUtime() != null ) {
            systemLogDto.setUtime( MapStructMapper.localDateTimetoGoogleTimestamp( var.getUtime() ) );
        }
        if ( var.getCid() != null ) {
            systemLogDto.setCid( var.getCid() );
        }
        if ( var.getCname() != null ) {
            systemLogDto.setCname( var.getCname() );
        }
        if ( var.getStatusName() != null ) {
            systemLogDto.setStatusName( var.getStatusName() );
        }

        return systemLogDto.build();
    }

    @Override
    public List<SystemLogDto> toDto(List<SystemLogBo> var) {
        if ( var == null ) {
            return null;
        }

        List<SystemLogDto> list = new ArrayList<SystemLogDto>( var.size() );
        for ( SystemLogBo systemLogBo : var ) {
            list.add( toDto( systemLogBo ) );
        }

        return list;
    }
}
