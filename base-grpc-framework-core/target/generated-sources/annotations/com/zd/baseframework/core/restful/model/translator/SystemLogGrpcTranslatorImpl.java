package com.zd.baseframework.core.restful.model.translator;

import com.zd.baseframework.common.entity.convert.MapStructMapper;
import com.zd.baseframework.common.entity.convert.MapStructTransaltorUtil;
import com.zd.baseframework.core.api.systemlog.ListSystemLogRequest;
import com.zd.baseframework.core.api.systemlog.ListSystemLogRequest.Builder;
import com.zd.baseframework.core.api.systemlog.PageSystemLogRequest;
import com.zd.baseframework.core.api.systemlog.SystemLogDto;
import com.zd.baseframework.core.restful.model.request.SystemLogQueryRequest;
import com.zd.baseframework.core.restful.model.vo.SystemLogVo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-18T11:02:17+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
public class SystemLogGrpcTranslatorImpl implements SystemLogGrpcTranslator {

    @Override
    public ListSystemLogRequest toDto(SystemLogQueryRequest var1) {
        if ( var1 == null ) {
            return null;
        }

        Builder listSystemLogRequest = ListSystemLogRequest.newBuilder();

        if ( var1.getBizId() != null ) {
            listSystemLogRequest.setBizId( MapStructMapper.javaStringToStringValue( var1.getBizId() ) );
        }
        if ( var1.getCode() != null ) {
            listSystemLogRequest.setCode( MapStructMapper.javaStringToStringValue( var1.getCode() ) );
        }

        return listSystemLogRequest.build();
    }

    @Override
    public PageSystemLogRequest toPageDto(SystemLogQueryRequest var1) {
        if ( var1 == null ) {
            return null;
        }

        com.zd.baseframework.core.api.systemlog.PageSystemLogRequest.Builder pageSystemLogRequest = PageSystemLogRequest.newBuilder();

        if ( var1.getPageNum() != null ) {
            pageSystemLogRequest.setPageNum( MapStructMapper.integerToInt32( var1.getPageNum() ) );
        }
        if ( var1.getPageSize() != null ) {
            pageSystemLogRequest.setPageSize( MapStructMapper.integerToInt32( var1.getPageSize() ) );
        }
        if ( var1.getSortProperty() != null ) {
            pageSystemLogRequest.setSortProperty( MapStructMapper.javaStringToStringValue( var1.getSortProperty() ) );
        }
        if ( var1.getSortType() != null ) {
            pageSystemLogRequest.setSortType( MapStructMapper.javaStringToStringValue( var1.getSortType() ) );
        }
        if ( var1.getBizId() != null ) {
            pageSystemLogRequest.setBizId( MapStructMapper.javaStringToStringValue( var1.getBizId() ) );
        }
        if ( var1.getCode() != null ) {
            pageSystemLogRequest.setCode( MapStructMapper.javaStringToStringValue( var1.getCode() ) );
        }

        return pageSystemLogRequest.build();
    }

    @Override
    public SystemLogVo toVo(SystemLogDto var1) {
        if ( var1 == null ) {
            return null;
        }

        SystemLogVo systemLogVo = new SystemLogVo();

        if ( var1.getId() != null ) {
            systemLogVo.setId( var1.getId() );
        }
        if ( var1.hasCtime() ) {
            systemLogVo.setCtime( MapStructMapper.googleTimestampToLocalDateTime( var1.getCtime() ) );
        }
        if ( var1.hasUtime() ) {
            systemLogVo.setUtime( MapStructMapper.googleTimestampToLocalDateTime( var1.getUtime() ) );
        }
        if ( var1.getBizId() != null ) {
            systemLogVo.setBizId( var1.getBizId() );
        }
        if ( var1.getUserId() != null ) {
            systemLogVo.setUserId( var1.getUserId() );
        }
        if ( var1.getTrackUid() != null ) {
            systemLogVo.setTrackUid( var1.getTrackUid() );
        }
        if ( var1.getCode() != null ) {
            systemLogVo.setCode( var1.getCode() );
        }
        if ( var1.getCustomCode() != null ) {
            systemLogVo.setCustomCode( var1.getCustomCode() );
        }
        if ( var1.getCname() != null ) {
            systemLogVo.setCname( var1.getCname() );
        }
        if ( var1.getCid() != null ) {
            systemLogVo.setCid( var1.getCid() );
        }
        if ( var1.getStatusName() != null ) {
            systemLogVo.setStatusName( var1.getStatusName() );
        }

        return systemLogVo;
    }

    @Override
    public List<SystemLogVo> toVo(List<SystemLogDto> var1) {
        if ( var1 == null ) {
            return null;
        }

        List<SystemLogVo> list = new ArrayList<SystemLogVo>( var1.size() );
        for ( SystemLogDto systemLogDto : var1 ) {
            list.add( toVo( systemLogDto ) );
        }

        return list;
    }
}
