package com.zd.baseframework.common.spring.grpc.delegate;

import io.grpc.ForwardingServerCallListener;
import io.grpc.ServerCall;

public class DelegateCallListener< ReqT, RespT> extends ForwardingServerCallListener<ReqT> {

    private ServerCall<ReqT, RespT> serverCall;
    private final ServerCall.Listener<ReqT> delegate;

    public DelegateCallListener(ServerCall.Listener<ReqT> delegate) {
        this.delegate = delegate;
    }

    @Override
    protected ServerCall.Listener<ReqT> delegate() {
        return delegate;
    }

    @Override
    public void onMessage(ReqT message) {
        //TODO 接收消息，处理一些注入攻击等，还要处理跨线程传参问题
        super.onMessage(message);
    }

    public ServerCall<ReqT, RespT> getServerCall() {
        return serverCall;
    }

    public void setServerCall(ServerCall<ReqT, RespT> serverCall) {
        this.serverCall = serverCall;
    }
}
