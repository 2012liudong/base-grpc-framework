package com.zd.baseframework.common.spring.grpc.server;

import com.zd.baseframework.common.constant.Constants;
import io.grpc.Metadata;

/**
 * 拦截器常量
 * Created by liudong on 2017/5/26.
 */
public class CONST {

    /**元数据中的trackid的key值*/
    public final static Metadata.Key<String> METADATA_KEY_TRACKID = Metadata.Key.of(Constants.TID, Metadata.ASCII_STRING_MARSHALLER);
    public final static Metadata.Key<String> METADATA_KEY_APPCODE = Metadata.Key.of(Constants.APPCODE, Metadata.ASCII_STRING_MARSHALLER);

    /**保存到当前线程的上下文中*/
//    public final static Context.Key<String> TRACK_LOG_URI_KEY = Context.key("trackLogUri");
//    public final static Context.Key<String> TRACK_LOG_INTIME_KEY = Context.key("trackLogInTimeKey");
//    public final static Context.Key<String> TRACK_LOG_KEY = Context.key("trackLogKey");
//    public final static Context.Key<String> TRACK_LOG_UID_KEY = Context.key("trackLogIdKey");

}
