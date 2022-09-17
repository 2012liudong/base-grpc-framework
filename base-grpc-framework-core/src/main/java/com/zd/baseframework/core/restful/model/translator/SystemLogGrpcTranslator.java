package com.zd.baseframework.core.restful.model.translator;

import com.zd.baseframework.common.entity.convert.MapStructMapper;
import com.zd.baseframework.common.entity.convert.MapStructTransaltorUtil;
import com.zd.baseframework.core.api.systemlog.ListSystemLogRequest;
import com.zd.baseframework.core.api.systemlog.PageSystemLogRequest;
import com.zd.baseframework.core.api.systemlog.SystemLogDto;
import com.zd.baseframework.core.restful.model.request.SystemLogQueryRequest;
import com.zd.baseframework.core.restful.model.vo.SystemLogVo;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * @Title: com.zd.baseframework.core.controller.translator.SystemLogTranslator
 * @Description http层与grpc层对象转换工具
 * @author liudong
 * @date 2022/6/15 8:52 PM
 */
@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        imports = {MapStructTransaltorUtil.class},
        uses = MapStructMapper.class)
public interface SystemLogGrpcTranslator {
    SystemLogGrpcTranslator INSTANCE = Mappers.getMapper(SystemLogGrpcTranslator.class);

    ListSystemLogRequest toDto(SystemLogQueryRequest var1);

    PageSystemLogRequest toPageDto(SystemLogQueryRequest var1);

    SystemLogVo toVo(SystemLogDto var1);
    List<SystemLogVo> toVo(List<SystemLogDto> var1);
}
