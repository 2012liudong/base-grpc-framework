package com.zd.baseframework.core.grpc.interceptor;

import com.zd.baseframework.common.spring.ApperProperties;
import com.zd.baseframework.common.spring.grpc.AbstractGrpcAccessInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Title: com.zd.baseframework.core.grpc.interceptor.GlobalServerInterceptorConfiguration
 * @Description
 * @author liudong
 * @date 2022/1/13 4:40 PM
 */
@Slf4j
public class GlobalServerInterceptor extends AbstractGrpcAccessInterceptor {

    @Autowired
    private ApperProperties apperProperties;

    @Override
    protected String tokenKey() {
        return apperProperties.getTokenKey();
    }

}
