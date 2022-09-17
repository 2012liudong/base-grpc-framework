package com.zd.baseframework.core.restful.interceptor;

import com.zd.baseframework.common.spring.ApperProperties;
import com.zd.baseframework.common.spring.restful.AbstractAccessInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AccessInterceptor extends AbstractAccessInterceptor {

    @Autowired
    private ApperProperties apperProperties;

    @Override
    protected String tokenKey() {
        return apperProperties.getTokenKey();
    }
}
