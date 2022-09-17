package com.zd.baseframework.common.spring.grpc.delegate;

import cn.hutool.core.util.StrUtil;
import com.zd.baseframework.common.util.UUIDUtil;
import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

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
 * @author liudong
 * @date 2022/1/13 4:44 PM
 */
@Slf4j
public class DelegateInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        long inTime = System.currentTimeMillis();

        String trackId = metadata.get(CONST.TRACKID_METADATA_KEY);
        if (StringUtils.isEmpty(trackId)){
            trackId = UUIDUtil.trackingId(System.nanoTime());
        }

        StringBuilder delegateLog = new StringBuilder();
        delegateLog.append("tid=").append(trackId)
//                .append(CONST.SPLIT_BLANK).append("appid=").append(TokenParser.appId())
                .append(" ip=").append(serverCall.getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR))
                .append(" uri=").append(serverCall.getMethodDescriptor().getFullMethodName())
                .append(" inTime=").append(inTime)
                .append(StrUtil.SPACE);

        //保存请求时间和相关日志到请求线程中，供后面拦截器打印用
        Context ctx = Context.current();
        ctx = ctx.withValue(CONST.TRACK_INTIME_KEY, String.valueOf(inTime));
        ctx = ctx.withValue(CONST.TRACK_LOG_KEY, delegateLog.toString());
        ctx = ctx.withValue(CONST.TRACK_LOG_UID_KEY, trackId);

        //log.info(delegateLog.toString());

        //下面设置的值必须为原始值，不能自定义的变量，保持参数的纯净
        DelegateCall<ReqT, RespT> serverCallDelegate = new DelegateCall<>(serverCall);
        DelegateCallListener<ReqT, RespT> delegateCallListener = new DelegateCallListener<>(serverCallHandler.startCall(serverCallDelegate, metadata));
        delegateCallListener.setServerCall(serverCall);

        return Contexts.interceptCall(ctx, serverCallDelegate, metadata, serverCallHandler);
    }

    private long genLogId(long param){
        long nowTime = System.currentTimeMillis();
        long logId = nowTime & 281474976710655L | (param >> 8 & 65535L) << 47;
        return logId;
    }
}
