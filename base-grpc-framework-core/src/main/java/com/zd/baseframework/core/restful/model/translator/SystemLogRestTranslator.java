package com.zd.baseframework.core.restful.model.translator;

import com.zd.baseframework.common.entity.convert.MapStructMapper;
import com.zd.baseframework.common.entity.convert.MapStructTransaltorUtil;
import com.zd.baseframework.core.core.systemlog.model.SystemLogBo;
import com.zd.baseframework.core.core.systemlog.model.SystemLogQueryBo;
import com.zd.baseframework.core.restful.model.request.SystemLogQueryRequest;
import com.zd.baseframework.core.restful.model.vo.SystemLogVo;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * @Title: com.zd.baseframework.core.controller.translator.SystemLogTranslator
 * @Description service and restful convertor
 * @author liudong
 * @date 2022/6/15 8:52 PM
 */
@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        imports = {MapStructTransaltorUtil.class},
        uses = MapStructMapper.class)
public interface SystemLogRestTranslator {
    SystemLogRestTranslator INSTANCE = Mappers.getMapper(SystemLogRestTranslator.class);

    // query convert
    SystemLogQueryBo toBo(SystemLogQueryRequest var1);

    // query result convert
    SystemLogVo toVo(SystemLogBo var);
    List<SystemLogVo> toVo(List<SystemLogBo> var1);

}
