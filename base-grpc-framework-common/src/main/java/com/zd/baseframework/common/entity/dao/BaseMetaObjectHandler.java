package com.zd.baseframework.common.entity.dao;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.zd.baseframework.common.constant.Constants;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BaseMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Date nowTime = new Date();
        if (metaObject.hasGetter("ctime")) {
            // record create time
            this.setFieldValByName("ctime", nowTime, metaObject);
        }
        if (metaObject.hasGetter("utime")) {
            // record last modify time
            this.setFieldValByName("utime", nowTime, metaObject);
        }
        if (metaObject.hasGetter("cid")) {
            // record creater id
            this.setFieldValByName("cid", MDC.get(Constants.USER_PARAM_ID), metaObject);
        }
        if (metaObject.hasGetter("cname")) {
            // record creater name
            this.setFieldValByName("cname", MDC.get(Constants.USER_PARAM_USERNAME), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasGetter("utime")) {
            Date nowTime = new Date();
            // 记录更新信息
            this.setFieldValByName("utime", nowTime, metaObject);
        }
    }
}