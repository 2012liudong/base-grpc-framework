package com.zd.baseframework.common.spring.grpc;

import cn.hutool.core.util.StrUtil;
import com.zd.baseframework.common.constant.Constants;
import com.zd.baseframework.common.spring.grpc.server.CONST;
import com.zd.baseframework.common.spring.grpc.server.DelegateCall;
import com.zd.baseframework.common.spring.grpc.server.DelegateCallListener;
import com.zd.baseframework.common.util.UUIDUtil;
import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

/**
 * @Title: com.zd.baseframework.core.core.common.interceptor.delegate.AbstractGrpcAccessInterceptor
 * @Description AccessInterceptor
 *  -- extends AbstractGrpcAccessInterceptor
 *  -- @Component ,subclasses don't have to use this annocation
 *
 * Tracklog format：
 * tid=8633542882073873365 app=app ip=0:0:0:0:0:0:0:1 uri=/systemlog/v1/list_systemlog controller=com.zd.baseframework.core.controller.core.SystemLogController#listSystemLog(SystemLogQueryRequest) inTime=1658916277205
 * tid=7532975723136214833 exec=31284
 *
 * >tid：trackid,Used to trace stack requests
 * >appid：client app id
 * >ip：client ip
 * >uri：request uri
 * >param：request parameter
 * >inTime：time of begin process
 * >exec：total time of request
 *
 *
 * The interceptor process order：
 * DelegateInterceptor.interceptCall().start
 * DelegateCall.request()
 * DelegateInterceptor.interceptCall().end
 * DelegateCallListener.onMessage()
 *
 * DelegateCall.sendHeaders()
 * DelegateCall.sendMessage()
 *
 * DelegateCall.close()
 * DelegateCallListener.onComplete()
 *
 * @author liudong
 * @date 2022/1/13 4:44 PM
 */
@Slf4j
public abstract class AbstractGrpcAccessInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        long inTime = System.currentTimeMillis();
        String ip =      StrUtil.emptyToDefault(serverCall.getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR).toString(), "");
        String trackId = StrUtil.emptyToDefault(metadata.get(CONST.METADATA_KEY_TRACKID), "");
        String appCode = StrUtil.emptyToDefault(metadata.get(CONST.METADATA_KEY_APPCODE), Constants.DEFAULT_APP_NAME);
        String token =   StrUtil.emptyToDefault(metadata.get(Metadata.Key.of(tokenKey(), Metadata.ASCII_STRING_MARSHALLER)), "");
        String uri =     serverCall.getMethodDescriptor().getFullMethodName();
        if (StrUtil.isEmpty(trackId)){
            trackId = UUIDUtil.trackingId(System.nanoTime());
        }

        MDC.put(Constants.TID, trackId);
        MDC.put(Constants.IP, ip);
        MDC.put(Constants.INTIME, StrUtil.toString(inTime));
        MDC.put(Constants.APPCODE, appCode);
        MDC.put(Constants.TOKEN, token);
        MDC.put(Constants.URI, uri);

//        Save the request time and related logs to the request thread for later interceptors to print, which is equivalent to MDC
//        Context ctx = Context.current();
//        ctx = ctx.withValue(CONST.TRACK_LOG_URI_KEY, uri);
//        ctx = ctx.withValue(CONST.TRACK_LOG_UID_KEY, trackId);
//        ctx = ctx.withValue(CONST.TRACK_LOG_INTIME_KEY, String.valueOf(inTime));
//        ctx = ctx.withValue(CONST.TRACK_LOG_KEY, delegateLog.toString());

        DelegateCall<ReqT, RespT> serverCallDelegate = new DelegateCall<>(serverCall);
        DelegateCallListener<ReqT, RespT> delegateCallListener = new DelegateCallListener<>(serverCallHandler.startCall(serverCallDelegate, metadata));
        return delegateCallListener;
//        return Contexts.interceptCall(ctx, serverCallDelegate, metadata, serverCallHandler);
    }

    protected abstract String tokenKey();
}
