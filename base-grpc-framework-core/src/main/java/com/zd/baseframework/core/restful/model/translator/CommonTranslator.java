package com.zd.baseframework.core.restful.model.translator;

import com.zd.baseframework.common.entity.convert.MapStructMapper;
import com.zd.baseframework.common.entity.convert.MapStructTransaltorUtil;
import com.zd.baseframework.common.entity.restful.PageParamReq;
import com.zd.baseframework.common.entity.service.PageQueryBo;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

/**
 * @Title: com.zd.baseframework.core.restful.model.translator.CommonTranslator
 * @Description common convertor，between request object and service object
 * @author liudong
 * @date 2022-07-21 11:15 a.m.
 */
@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        imports = {MapStructTransaltorUtil.class},
        uses = MapStructMapper.class)
public interface CommonTranslator {

    CommonTranslator INSTANCE = Mappers.getMapper(CommonTranslator.class);

    PageQueryBo pageReq2PageQueryBo(PageParamReq var1);

}
