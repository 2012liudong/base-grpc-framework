package com.zd.baseframework.common.entity.dao;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
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
//        if (metaObject.hasGetter("cid")) {
//            // record creater id
//            this.setFieldValByName("cid", LoginUserUtil.getCurrentUserId(), metaObject);
//        }
//        if (metaObject.hasGetter("cname")) {
//            // record creater name
//            this.setFieldValByName("cname", LoginUserUtil.getCurrentUserName(), metaObject);
//        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasGetter("utime")) {
            Date nowTime = new Date();
            // record update time
            this.setFieldValByName("utime", nowTime, metaObject);
        }
//        if (metaObject.hasGetter("uid")) {
//            Date nowTime = new Date();
//            // record update user id
//            this.setFieldValByName("uid", LoginUserUtil.getCurrentUserId(), metaObject);
//        }
//        if (metaObject.hasGetter("uname")) {
//            Date nowTime = new Date();
//            // record update user name
//            this.setFieldValByName("uname", LoginUserUtil.getCurrentUserName(), metaObject);
//        }
    }
}