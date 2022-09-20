package com.zd.baseframework.common.spring.grpc.server;

import cn.hutool.core.util.StrUtil;
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
                .append(Constants.TID_TITLE).append("=").append(MDC.get(Constants.TID))
                .append(StrUtil.SPACE).append(Constants.URI_TITLE).append("=").append(MDC.get(Constants.URI))
                .append(StrUtil.SPACE).append(Constants.EXEC_TITLE).append("=").append(System.currentTimeMillis() - Long.parseLong(MDC.get(Constants.INTIME)));
        log.info(delegateLog.toString());
        super.sendMessage(message);
    }
}