package com.zd.baseframework.common.spring.grpc.delegate;

import io.grpc.Context;
import io.grpc.Metadata;

/**
 * 日志常量
 * Created by liudong on 2017/5/26.
 */
public class CONST {

    /**元数据中的trackid的key值*/
    public final static Metadata.Key<String> TRACKID_METADATA_KEY = Metadata.Key.of("tid", Metadata.ASCII_STRING_MARSHALLER);

    /**保存到当前线程的上下文中*/
    public final static Context.Key<String> TRACK_INTIME_KEY = Context.key("universe_trackInTimeKey");

    public final static Context.Key<String> TRACK_LOG_KEY = Context.key("universe_trackLogKey");

    public final static Context.Key<String> TRACK_LOG_UID_KEY = Context.key("universe_trackLogIdKey");

}
