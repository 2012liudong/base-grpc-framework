package com.zd.baseframework.common.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zd.baseframework.common.constant.Constants;
import com.zd.baseframework.common.constant.enumeration.AppEnumTranslatorUtil;
import com.zd.baseframework.common.entity.restful.PageParamReq;
import com.zd.baseframework.common.entity.restful.response.PageResponse;
import com.zd.baseframework.common.entity.service.PageBo;
import com.zd.baseframework.common.entity.service.PageQueryBo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: com.zd.baseframework.common.util.PageUtil
 * @Description warp mybatis Pagination, demo code
 * - Contoller
 *    -Definition : SystemLogQueryRequest extends PageParamReq
 *      public PageResponse<List<SystemLogVo>> page(@RequestBody SystemLogQueryRequest pageRequest){
 *          //build request parameter
 *          PageQueryBo pageParam = PageUtil.buildServiceRequestParameter(pageRequest);
 *          //send request
 *          PageBo<SystemLogBo> pageBo = iSystemLogServcie.pageSearch(pageParam);
 *          List<SystemLogVo> systemLogVos = SystemLogRestTranslator.INSTANCE.toVo(pageBo.getData());
 *          //handle response
 *          PageResponse<List<SystemLogVo>> response = PageUtil.handleResponseToRestful(pageBo, systemLogVos);
 *      }
 * - ServiceImpl
 *     -Definition ： PageBo<SystemLogBo> pageSearch(PageQueryBo pageParam)
 *      public PageBo<SystemLogBo> pageSearch(PageQueryBo pageParam) {
 *          //build request parameter
 *          IPage<SystemLogEntity> iPage = PageUtil.buildIpageRequestParameter(pageParam);
 *          //send request
 *          iPage = iSystemLogDao.pageSystemLog(iPage);
 *          List<SystemLogBo> systemLogBos =  SystemLogBoTranslator.INSTANCE.toBo(iPage.getRecords());
 *          //handle response
 *          PageBo<SystemLogBo> reuslt = PageUtil.handleResponseToService(iPage, systemLogBos);
 *      }
 *
 * @author liudong
 * @date 2022-09-20 3:17 p.m.
 */
public class PageUtil {

    /**Apply for controller，convert service response(PageBo) to restful response(PageResponse)
     * Use it like:
     * -PageQueryBo pageQueryueryBo = CommonTranslator.INSTANCE.pageReq2PageQueryBo(pageRequest)
     * -PageResponse<List<SystemLogVo>> response = PageUtil.convertBo2PageResponseForRes(pageBo)
     */
    public static <T> PageResponse<T> handleResponseToRestful(PageBo pageBo, T serviceResponseData){
        PageResponse<T> response = PageResponse.success();
        response.setTotal(pageBo.getCount());
        response.setOffset(pageBo.getOffset());
        response.setCurrentPage(pageBo.getPageNum());
        response.setPageSize(pageBo.getPageSize());
        response.setData(serviceResponseData);
        return response;
    }

    /**Apply for service，convert service model to mybatis request parameter Ipage*/
    public static <T> IPage<T> buildIpageRequestParameter(PageQueryBo pageParam){
        Page<T> iPage = new Page<>(Constants.DEFAULT_PAGE_NUM, Constants.DEFAULT_PAGE_SIZE);
        if( pageParam==null ){
            return iPage;
        }

        iPage.setCurrent(pageParam.getPageNum());
        iPage.setSize(pageParam.getPageSize());

        if(StrUtil.isNotEmpty(pageParam.getSortProperty()) && StrUtil.isNotEmpty(pageParam.getSortType())){
            int sortType = AppEnumTranslatorUtil.getDataSort(pageParam.getSortType());
            OrderItem item = new OrderItem(pageParam.getSortProperty(), BooleanUtil.toBoolean(String.valueOf(sortType)));
            iPage.addOrder(item);
        }
        for(Map.Entry<String, String> entry : pageParam.getSort().entrySet()){
            int sortType = AppEnumTranslatorUtil.getDataSort(entry.getValue());
            OrderItem item = new OrderItem(entry.getValue(), BooleanUtil.toBoolean(String.valueOf(sortType)));
            iPage.addOrder(item);
        }
        return iPage;
    }

    /**Apply for service，convert mybatis response model to service PageBo*/
    public static <T> PageBo<T> handleResponseToService(IPage ipage, List<T> daoResponseData){
        PageBo<T> pageBo = new PageBo<>();
        pageBo.setCount( Math.toIntExact(ipage.getTotal()) );
        pageBo.setOffset( Math.toIntExact(ipage.offset()) );
        pageBo.setPageNum( Math.toIntExact(ipage.getCurrent()) );
        pageBo.setPageSize( Math.toIntExact(ipage.getSize()) );
        pageBo.setData(daoResponseData);
        return pageBo;
    }

    public static PageQueryBo buildServiceRequestParameter(PageParamReq paramReq) {
        PageQueryBo pageQueryBo = new PageQueryBo();
        if ( paramReq == null ) {
            return pageQueryBo;
        }

        pageQueryBo.setPageNum( paramReq.getPageNum() );
        pageQueryBo.setPageSize( paramReq.getPageSize() );

        if ( StrUtil.isNotEmpty(paramReq.getSortProperty()) ) {
            pageQueryBo.setSortProperty( paramReq.getSortProperty() );
        }
        if ( StrUtil.isNotEmpty(paramReq.getSortType() ) ) {
            pageQueryBo.setSortType( paramReq.getSortType() );
        }
        if (CollUtil.isNotEmpty( paramReq.getSorts() )) {
            pageQueryBo.setSort( new HashMap( paramReq.getSorts() ) );
        }
        return pageQueryBo;
    }

}
