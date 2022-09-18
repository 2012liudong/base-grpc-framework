package com.zd.baseframework.core.grpc.interceptor;

import com.zd.baseframework.common.spring.ApperProperties;
import com.zd.baseframework.common.spring.grpc.AbstractGrpcClientInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.LOWEST_PRECEDENCE)
@Configuration(proxyBeanMethods = false)
public class GlobalClientInterceptor extends AbstractGrpcClientInterceptor {

    @Autowired
    private ApperProperties apperProperties;

    @Override
    protected String tokenKey() {
        return apperProperties.getTokenKey();
    }

}
