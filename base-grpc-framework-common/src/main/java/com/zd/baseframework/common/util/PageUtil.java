package com.zd.baseframework.common.util;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zd.baseframework.common.constant.enumeration.AppEnumTranslatorUtil;
import com.zd.baseframework.common.entity.restful.response.PageResponse;
import com.zd.baseframework.common.entity.service.PageBo;
import com.zd.baseframework.common.entity.service.PageQueryBo;

import java.util.Map;

/**
 *
 * @author Lyra
 * @date 2017/6/22
 */
public class PageUtil {

    /**应用在controller层，把service生成的bo转换成PageResponse对象，因为在这里有个实体转换，所以需要在外面再进行数据转换
     * 请求参数处理：PageQueryBo pageQueryueryBo = CommonTranslator.INSTANCE.pageReq2PageQueryBo(pageRequest)
     */
    public static <T> PageResponse<T> convertBo2PageResponseForRes(PageBo pageBo){
        PageResponse<T> response = PageResponse.success();
        response.setTotal(pageBo.getCount());
        response.setCurrentPage(pageBo.getPageNum());
        response.setPageSize(pageBo.getPageSize());
        return response;
    }

    /**处理请求值：应用在service层，把请求的bo转换成Ipage对象，再给dao来调用，应用于有排序的情况*/
    public static <T> IPage<T> convertBo2IpageForReq(PageQueryBo pageParam){
        Page<T> iPage = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());

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

    /**处理返回值：应用在service层，把dao层查询到的分页实体转换成service对象，因为在这里有个实体转换，所以需要在外面再进行数据转换*/
    public static <T> PageBo<T> convertIpage2BoForRes(IPage ipage){
        PageBo<T> pageBo = new PageBo<>();
        pageBo.setCount( Math.toIntExact(ipage.getTotal()) );
        pageBo.setPageNum( Math.toIntExact(ipage.getCurrent()) );
        pageBo.setPageSize( Math.toIntExact(ipage.getSize()) );
        pageBo.setOffset( Math.toIntExact(ipage.offset()) );
        return pageBo;
    }

}
