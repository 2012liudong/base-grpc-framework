package com.zd.baseframework.common.spring.grpc.delegate;

import com.zd.baseframework.common.constant.Constants;
import io.grpc.ForwardingServerCall;
import io.grpc.ServerCall;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
public class DelegateCall <ReqT, RespT> extends ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>  {

    public DelegateCall(ServerCall<ReqT, RespT> delegate) {
        super(delegate);
    }

    @Override
    public void sendMessage(RespT message) {
        StringBuilder delegateLog = new StringBuilder()
                .append("tid=").append(MDC.get(Constants.TID))
                .append(" uri=").append(MDC.get(Constants.URI))
                .append(" exec=").append(System.currentTimeMillis() - Long.parseLong(MDC.get(Constants.INTIME)));
        log.info(delegateLog.toString());
        super.sendMessage(message);
    }
}