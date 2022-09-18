package com.zd.baseframework.common.spring.grpc.delegate;

import cn.hutool.core.util.StrUtil;
import com.zd.baseframework.common.constant.Constants;
import com.zd.baseframework.common.util.UUIDUtil;
import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

/**
 * @Title: com.zd.baseframework.core.core.common.interceptor.delegate.DelegateInterceptor
 * @Description 访问日志拦截器，此拦截器只打印日志并不做真正拦截，只输出原始参数。在
 * 在DelegateInterceptor和DelegateCall中分别输出：请求日志，格式如下：
 * tid=7537479305976007099 appid=Bearer ip=/127.0.0.1:64446 uri=universe.core.cases.ICaseService/GetCaseByCaseNum inTime=1642129705403
 * tid=7537479305976007099 appid=Bearer ip=/127.0.0.1:64446 uri=universe.core.cases.ICaseService/GetCaseByCaseNum inTime=1642129705403 exec=290
 *
 * >tid：trackid,且于跟踪栈请求
 * >appid：接入应用的id
 * >ip：访问端的ip地址和端口号
 * >uri：客户端此次访问的uri
 * >param：请求的原始参数
 * >inTime：接收到请求的timestamp
 * >exec：此次请求的执行总时间
 *
 * 拦截器执行顺序：
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
public class DelegateInterceptor implements ServerInterceptor {

    private String tokenName = "TOKEN";
    public DelegateInterceptor(String tokenName){
        this.tokenName = tokenName;
    }

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        long inTime = System.currentTimeMillis();

        String ip =      StrUtil.emptyToDefault(serverCall.getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR).toString(), "");
        String trackId = StrUtil.emptyToDefault(metadata.get(CONST.METADATA_KEY_TRACKID), "");
        String appCode = StrUtil.emptyToDefault(metadata.get(CONST.METADATA_KEY_APPCODE), Constants.DEFAULT_APP_NAME);
        String token =   StrUtil.emptyToDefault(metadata.get(tokenKey()), "");
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

        //保存请求时间和相关日志到请求线程中，供后面拦截器打印用，与MDC是等价的
//        Context ctx = Context.current();
//        ctx = ctx.withValue(CONST.TRACK_LOG_URI_KEY, uri);
//        ctx = ctx.withValue(CONST.TRACK_LOG_UID_KEY, trackId);
//        ctx = ctx.withValue(CONST.TRACK_LOG_INTIME_KEY, String.valueOf(inTime));
//        ctx = ctx.withValue(CONST.TRACK_LOG_KEY, delegateLog.toString());

        //下面设置的值必须为原始值，不能自定义的变量，保持参数的纯净
        DelegateCall<ReqT, RespT> serverCallDelegate = new DelegateCall<>(serverCall);
        DelegateCallListener<ReqT, RespT> delegateCallListener = new DelegateCallListener<>(serverCallHandler.startCall(serverCallDelegate, metadata));
        return delegateCallListener;
//        return Contexts.interceptCall(ctx, serverCallDelegate, metadata, serverCallHandler);
    }

    private Metadata.Key<String> tokenKey(){
        return Metadata.Key.of(Constants.APPCODE, Metadata.ASCII_STRING_MARSHALLER);
    }
}
