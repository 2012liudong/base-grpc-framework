package com.zd.baseframework.common.spring.grpc.server;

import com.zd.baseframework.common.constant.Constants;
import io.grpc.Metadata;

public class CONST {

    /**Meta data parameter key*/
    public final static Metadata.Key<String> METADATA_KEY_TRACKID = Metadata.Key.of(Constants.TID, Metadata.ASCII_STRING_MARSHALLER);
    public final static Metadata.Key<String> METADATA_KEY_APPCODE = Metadata.Key.of(Constants.APPCODE, Metadata.ASCII_STRING_MARSHALLER);

    /**current thread context*/
//    public final static Context.Key<String> TRACK_LOG_URI_KEY = Context.key("trackLogUri");
//    public final static Context.Key<String> TRACK_LOG_INTIME_KEY = Context.key("trackLogInTimeKey");
//    public final static Context.Key<String> TRACK_LOG_KEY = Context.key("trackLogKey");
//    public final static Context.Key<String> TRACK_LOG_UID_KEY = Context.key("trackLogIdKey");

}
