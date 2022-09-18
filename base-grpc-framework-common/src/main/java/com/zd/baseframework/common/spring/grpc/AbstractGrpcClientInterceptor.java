package com.zd.baseframework.common.spring.grpc;

import com.zd.baseframework.common.constant.Constants;
import io.grpc.*;
import org.slf4j.MDC;

// TODO 客户端拦截器不生效
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
