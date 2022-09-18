package com.zd.baseframework.common.spring.grpc;

import com.zd.baseframework.common.spring.grpc.delegate.DelegateInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.core.annotation.Order;

/**
 * @Title: com.zd.baseframework.core.core.common.interceptor.GlobalServerInterceptorConfiguration
 * @Description  grpc服务端拦截器链设置文件，可以通过指定方法的org.springframework.core.annotation.Order注解来指定执行顺序，
 * 不过好像不起作用，需要按位置来写
 *  -- extends AbstractAccessInterceptor
 *  -- @Order(Ordered.LOWEST_PRECEDENCE)
 *  -- @Configuration(proxyBeanMethods = false)
 * @author liudong
 * @date 2022/1/13 4:40 PM
 */
public abstract class AbstractGrpcAccessInterceptor {

    @GrpcGlobalServerInterceptor
    @Order(value = 10000)
    DelegateInterceptor delegateInterceptor(){
        return new DelegateInterceptor(tokenKey());
    }

    protected abstract String tokenKey();
}
