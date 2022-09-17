package com.zd.baseframework.core.grpc.interceptor;

import com.zd.baseframework.common.spring.grpc.AbstractGrpcAccessInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Title: com.zd.baseframework.core.grpc.interceptor.GlobalServerInterceptorConfiguration
 * @Description  grpc服务端拦截器链设置文件，可以通过指定方法的org.springframework.core.annotation.Order注解来指定执行顺序，
 * 不过好像不起作用，需要按位置来写
 * @author liudong
 * @date 2022/1/13 4:40 PM
 */
@Order(Ordered.LOWEST_PRECEDENCE)
@Configuration(proxyBeanMethods = false)
public class GlobalServerInterceptor extends AbstractGrpcAccessInterceptor {

//    @GrpcGlobalServerInterceptor
//    @Order(value = 10000)
//    DelegateInterceptor delegateInterceptor(){
//        return new DelegateInterceptor();
//    }

}
