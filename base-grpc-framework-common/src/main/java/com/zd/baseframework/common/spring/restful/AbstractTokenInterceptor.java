package com.zd.baseframework.common.spring.restful;

import cn.hutool.core.util.StrUtil;
import com.zd.baseframework.common.constant.Constants;
import com.zd.baseframework.common.constant.ResponseConst;
import com.zd.baseframework.common.entity.restful.LoginUser;
import com.zd.baseframework.common.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: com.zd.baseframework.common.spring.interceptor.AbstractTokenInterceptor
 * @Description token拦截器
 *  -- extends AbstractTokenInterceptor
 *  -- @Component
 * @author liudong
 * @date 2022-09-17 12:15 a.m.
 */
@Slf4j
public abstract class AbstractTokenInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = MDC.get(Constants.TOKEN);

        try{
            if(StrUtil.isEmpty(token)){
                log.error("Token is null, no login user");
                throw new AppException(ResponseConst.Msg.INVALID_USER);
            }

            LoginUser loginUser = loginUser();
            MDC.put(Constants.USER_PARAM_ID, loginUser.getId());
            MDC.put(Constants.USER_PARAM_USERNAME, loginUser.getUserName());
            return true;
        } catch (AppException e) {
            log.error("Token is invalid, login user isn't exsit..{"+MDC.get(Constants.TOKEN)+"}");
            throw new AppException(ResponseConst.Msg.INVALID_USER);
        }
    }

    protected abstract LoginUser loginUser();

}

/**
@Slf4j
@Component
public class MvcInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Autowired
    private AccessInterceptor accessInterceptor;

    *//**
     * 〈功能简述〉accessInterceptor要设置很多线程变量，所以要放在第一位。
     * NOTICE：afterCompletion中的clear方法
     *//*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessInterceptor).addPathPatterns("/api/v1/**");
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/api/v1/**");
    }
}
*/
