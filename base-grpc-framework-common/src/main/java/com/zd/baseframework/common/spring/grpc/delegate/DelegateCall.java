package com.zd.baseframework.common.spring.grpc.delegate;

import cn.hutool.core.util.StrUtil;
import io.grpc.ForwardingServerCall;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DelegateCall <ReqT, RespT> extends ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>  {

    private Metadata metadata;

    public DelegateCall(ServerCall<ReqT, RespT> delegate) {
        super(delegate);
    }

    @Override
    public void sendMessage(RespT message) {
        StringBuilder delegateLog = new StringBuilder(CONST.TRACK_LOG_KEY.get());
        delegateLog.append(StrUtil.SPACE)
                .append("exec=").append(System.currentTimeMillis() - Long.parseLong(CONST.TRACK_INTIME_KEY.get()));

        super.sendMessage(message);
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

}

