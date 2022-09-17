package com.zd.baseframework.common.entity.restful;

import com.zd.baseframework.common.constant.Constants;
import com.zd.baseframework.common.constant.enumeration.AppEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* extends PageParamReq*/
@Data
public class PageParamReq implements Serializable {

    private Integer pageNum = Constants.DEFAULT_PAGE_NUM;

    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;

    private String sortProperty;

    private String sortType = AppEnum.DataSort.DESC.getText();

    /*key=sortProperties, value=asc||desc（to see AppEnum.DataSort*/
    private Map<String, String> sort = new HashMap<>();

}
