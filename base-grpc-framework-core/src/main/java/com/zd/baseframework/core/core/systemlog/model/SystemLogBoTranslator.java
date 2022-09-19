package com.zd.baseframework.core.core.systemlog.model;

import com.zd.baseframework.common.constant.enumeration.AppEnumTranslatorUtil;
import com.zd.baseframework.common.entity.convert.MapStructMapper;
import com.zd.baseframework.common.entity.convert.MapStructTransaltorUtil;
import com.zd.baseframework.core.dao.systemlog.entry.SystemLogEntity;
import com.zd.baseframework.core.dao.systemlog.entry.SystemLogQuery;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Title: com.zd.baseframework.core.core.systemlog.model.SystemLogModelTranslator
 * @Description dao and service convertor
 * @author liudong
 * @date 2022/6/15 9:02 PM
 */
@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        imports = {MapStructTransaltorUtil.class, AppEnumTranslatorUtil.class},
        uses = MapStructMapper.class)
public interface SystemLogBoTranslator {
    SystemLogBoTranslator INSTANCE = Mappers.getMapper(SystemLogBoTranslator.class);

    SystemLogQuery toEntry(SystemLogQueryBo var1);
    SystemLogEntity toEntry(SystemLogBo var1);

    @Mapping(target = "statusName" , expression = "java(AppEnumTranslatorUtil.getStatus(var1.getStatus()))" )
    SystemLogBo toBo(SystemLogEntity var1);
    List<SystemLogBo> toBo(List<SystemLogEntity> var1);
}
