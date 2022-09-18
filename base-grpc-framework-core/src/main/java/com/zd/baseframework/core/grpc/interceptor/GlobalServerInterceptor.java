package com.zd.baseframework.core.grpc.interceptor;

import com.zd.baseframework.common.spring.ApperProperties;
import com.zd.baseframework.common.spring.grpc.AbstractGrpcAccessInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Title: com.zd.baseframework.core.grpc.interceptor.GlobalServerInterceptorConfiguration
 * @Description  grpc服务端拦截器链设置文件，可以通过指定方法的org.springframework.core.annotation.Order注解来指定执行顺序，
 * 不过好像不起作用，需要按位置来写
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
