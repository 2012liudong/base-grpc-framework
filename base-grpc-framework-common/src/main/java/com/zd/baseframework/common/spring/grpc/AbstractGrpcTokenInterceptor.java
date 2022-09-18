package com.zd.baseframework.common.spring.grpc;

import cn.hutool.core.util.StrUtil;
import com.zd.baseframework.common.constant.Constants;
import com.zd.baseframework.common.constant.ResponseConst;
import com.zd.baseframework.common.entity.restful.LoginUser;
import com.zd.baseframework.common.exception.AppException;
import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

/**
 * @Title: com.zd.baseframework.common.spring.grpc.AbstractGrpcTokenInterceptor
 * @Description token拦截器
 *  -- extends AbstractGrpcTokenInterceptor
 *  -- @Component, 有时会有冲突，子类可以不要这个标
 * @author liudong
 * @date 2022-09-18 2:21 p.m.
 */
@Slf4j
public abstract class AbstractGrpcTokenInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        String token = MDC.get(Constants.TOKEN);
        try{
            if(StrUtil.isEmpty(token)){
                log.warn("Token is null, no login user");
            }

            LoginUser loginUser = loginUser();
            MDC.put(Constants.USER_PARAM_ID, loginUser.getId());
            MDC.put(Constants.USER_PARAM_USERNAME, loginUser.getUserName());
        } catch (AppException e) {
            log.error("Token is invalid, login user isn't exsit..{"+MDC.get(Constants.TOKEN)+"}");
            throw new AppException(ResponseConst.Msg.INVALID_USER);
        }
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(next.startCall(call, headers)) {

        };
    }

    protected abstract LoginUser loginUser();
}


/**
 * @Title: com.zd.baseframework.core.core.common.interceptor.GlobalServerInterceptorConfiguration
 * @Description grpc服务端拦截器链设置文件，可以通过指定方法的org.springframework.core.annotation.Order注解来指定执行顺序，
 * 不过好像不起作用，需要按位置来写，同时需要注意方法名称不能重复
 * -- extends AbstractAccessInterceptor
 * -- @Order(Ordered.LOWEST_PRECEDENCE)
 * -- @Configuration(proxyBeanMethods = false)
 * @author liudong
 * @date 2022/1/13 4:40 PM
 */

/*
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
*/
