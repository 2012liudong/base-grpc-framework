package com.zd.baseframework.common.spring.grpc.delegate;

import cn.hutool.core.util.StrUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import com.zd.baseframework.common.constant.Constants;
import io.grpc.ForwardingServerCallListener;
import io.grpc.ServerCall;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
public class DelegateCallListener< ReqT, RespT> extends ForwardingServerCallListener<ReqT> {

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
        String param = null;
        try {
            param = JsonFormat.printer().omittingInsignificantWhitespace().print((MessageOrBuilder) message);
        } catch (InvalidProtocolBufferException e) {
            log.warn("ReqT message convert error");
        }
        String url = new StringBuilder()
                .append(" uri=").append(MDC.get(Constants.URI))
                .append(" param=").append(param)
                .toString();
        MDC.put(Constants.URL, url);

        StringBuilder delegateLog = new StringBuilder()
                .append("tid=").append(MDC.get(Constants.TID))
                .append(" appid=").append(MDC.get(Constants.APPCODE))
                .append(" token=").append(MDC.get(Constants.TOKEN))
                .append(" ip=").append(MDC.get(Constants.IP))
                .append(url)
                .append(" inTime=").append(MDC.get(Constants.INTIME))
                .append(StrUtil.SPACE);
        log.info(delegateLog.toString());

        super.onMessage(message);
    }

}
