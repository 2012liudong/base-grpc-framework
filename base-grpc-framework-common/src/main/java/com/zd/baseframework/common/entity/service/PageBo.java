package com.zd.baseframework.common.entity.service;

import com.zd.baseframework.common.constant.Constants;
import lombok.Data;

import java.util.List;

/**
 * @author songpj
 * @Title: net.shukun.universe.core.cases.model.null.java
 * @Description for query result entity convert bo
 * @date 2022/5/10 16:43
 */
@Data
public class PageBo<T> {

    private Integer count = Constants.DEFAULT_PAGE_TOTAL;

    private Integer offset = Constants.DEFAULT_PAGE_TOTAL;

    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;

    private Integer pageNum= Constants.DEFAULT_PAGE_NUM;

    private List<T> data;
}
