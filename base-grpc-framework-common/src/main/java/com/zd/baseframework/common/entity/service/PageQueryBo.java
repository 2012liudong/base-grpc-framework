package com.zd.baseframework.common.entity.service;

import com.zd.baseframework.common.constant.Constants;
import com.zd.baseframework.common.constant.enumeration.AppEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PageQueryBo {

    private Integer pageNum = Constants.DEFAULT_PAGE_NUM;

    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;

    private String sortProperty;

    private String sortType = AppEnum.DataSort.DESC.getText();

    private Map<String, String> sort = new HashMap<>();
}
