package com.zd.baseframework.core.grpc.model;

import com.zd.baseframework.common.entity.convert.MapStructMapper;
import com.zd.baseframework.common.entity.convert.MapStructTransaltorUtil;
import com.zd.baseframework.common.entity.service.PageQueryBo;
import com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest;
import com.zd.baseframework.core.api.systemlog.ListSystemLogRequest;
import com.zd.baseframework.core.api.systemlog.PageSystemLogRequest;
import com.zd.baseframework.core.api.systemlog.SystemLogDto;
import com.zd.baseframework.core.core.systemlog.model.SystemLogBo;
import com.zd.baseframework.core.core.systemlog.model.SystemLogQueryBo;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Title: com.zd.baseframework.core.grpc.model.SystemLogDtoTranslator
 * @Description proto and service convertor
 * @author liudong
 * @date 2022/6/15 8:59 PM
 */
@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        imports = {MapStructTransaltorUtil.class},
        uses = MapStructMapper.class)
public interface SystemLogDtoTranslator {

    SystemLogDtoTranslator INSTANCE = Mappers.getMapper(SystemLogDtoTranslator.class);

    SystemLogBo toBo(CreateSystemLogRequest var);

    /*query convert*/
    SystemLogQueryBo toBo(ListSystemLogRequest var);
    PageQueryBo toBo(PageSystemLogRequest var);

    /*query result convert*/
    SystemLogDto toDto(SystemLogBo var);
    List<SystemLogDto> toDto(List<SystemLogBo> var);
}