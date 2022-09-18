package com.zd.baseframework.core.grpc.interceptor;

import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.LOWEST_PRECEDENCE)
@Configuration(proxyBeanMethods = false)
public class GloablInterceptorRegister {

    @GrpcGlobalServerInterceptor
    @Order(value = 10000)
    GlobalServerInterceptor grpcAccessInterceptor() {
        return new GlobalServerInterceptor();
    }

    @GrpcGlobalServerInterceptor
    @Order(value = 20000)
    GrpcTokenInterceptor grpcTokenInterceptor() {
        return new GrpcTokenInterceptor();
    }

    @GrpcGlobalClientInterceptor
    @Order(value = 30000)
    GlobalClientInterceptor cClientInterceptor() {
        return new GlobalClientInterceptor();
    }
}
