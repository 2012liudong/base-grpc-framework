package com.zd.baseframework.core.restful.model.translator;

import com.zd.baseframework.common.entity.convert.MapStructTransaltorUtil;
import com.zd.baseframework.common.entity.restful.PageParamReq;
import com.zd.baseframework.common.entity.service.PageQueryBo;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-18T13:43:45+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
public class CommonTranslatorImpl implements CommonTranslator {

    @Override
    public PageQueryBo pageReq2PageQueryBo(PageParamReq var1) {
        if ( var1 == null ) {
            return null;
        }

        PageQueryBo pageQueryBo = new PageQueryBo();

        if ( var1.getPageNum() != null ) {
            pageQueryBo.setPageNum( var1.getPageNum() );
        }
        if ( var1.getPageSize() != null ) {
            pageQueryBo.setPageSize( var1.getPageSize() );
        }
        if ( var1.getSortProperty() != null ) {
            pageQueryBo.setSortProperty( var1.getSortProperty() );
        }
        if ( var1.getSortType() != null ) {
            pageQueryBo.setSortType( var1.getSortType() );
        }
        Map<String, String> map = var1.getSort();
        if ( map != null ) {
            pageQueryBo.setSort( new HashMap<String, String>( map ) );
        }

        return pageQueryBo;
    }
}
