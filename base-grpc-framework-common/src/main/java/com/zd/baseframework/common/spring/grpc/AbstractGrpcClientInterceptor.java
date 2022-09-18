package com.zd.baseframework.common.spring.grpc;

import com.zd.baseframework.common.constant.Constants;
import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
/**
 * @Title: com.zd.baseframework.common.spring.grpc.AbstractGrpcClientInterceptor
 * @Description 客户端拦截器
 *  -- extends AbstractGrpcClientInterceptor
 *  -- @Component, 有时会有冲突，子类可以不要这个标注
 *
 * @author liudong
 * @date 2022-09-18 2:21 p.m.
 */

@Slf4j
public abstract class AbstractGrpcClientInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(methodDescriptor, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                headers.put(Metadata.Key.of(tokenKey(), Metadata.ASCII_STRING_MARSHALLER), MDC.get(Constants.TOKEN));
                headers.put(Metadata.Key.of(Constants.TID, Metadata.ASCII_STRING_MARSHALLER), MDC.get(Constants.TID));
                super.start(responseListener, headers);
            }
        };
    }

    protected abstract String tokenKey();

}
