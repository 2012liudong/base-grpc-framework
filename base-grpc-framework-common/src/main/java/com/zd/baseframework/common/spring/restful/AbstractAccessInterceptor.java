package com.zd.baseframework.common.spring.restful;

import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.zd.baseframework.common.constant.Constants;
import com.zd.baseframework.common.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: com.shukun.data.app.interceptor.AccessLogInterceptor
 * @Description AccessInterceptor
 *  -- extends AbstractGrpcAccessInterceptor
 *  -- @Component ,subclasses don't have to use this annocation
 *
 * Tracklog format：
 * tid=8633542882073873365 app=app ip=0:0:0:0:0:0:0:1 uri=/systemlog/v1/list_systemlog controller=com.zd.baseframework.core.controller.core.SystemLogController#listSystemLog(SystemLogQueryRequest) inTime=1658916277205
 * tid=7532975723136214833 exec=31284
 *
 * >tid：trackid,Used to trace stack requests
 * >appid：client app id
 * >ip：client ip
 * >uri：request uri
 * >param：request parameter
 * >inTime：time of begin process
 * >exec：total time of request
 *
 * @author liudong
 * @date 2022/1/13 4:44 PM
 */

@Slf4j
public abstract class AbstractAccessInterceptor implements HandlerInterceptor {

    private final static String X_FORWARDED_FOR = "x-forwarded-for";
    private final static String PROXY_CLIENT_IP = "Proxy-Client-IP";
    private final static String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long   inTime =   System.currentTimeMillis();
        String ip1 = StrUtil.emptyToDefault(request.getHeader(X_FORWARDED_FOR), "");
        String ip2 = StrUtil.emptyToDefault(request.getHeader(PROXY_CLIENT_IP), "");
        String ip3 = StrUtil.emptyToDefault(request.getHeader(WL_PROXY_CLIENT_IP), "");
        String ip4 = StrUtil.emptyToDefault(request.getRemoteAddr(), "");

        String ip =       StrUtil.format("{}{}{}{}", ip1, ip2, ip3, ip4);
        String sesionId = StrUtil.emptyToDefault(request.getRequestedSessionId(), "");
        String trackId =  StrUtil.emptyToDefault(request.getHeader(Constants.TID), "");
        String appCode =  StrUtil.emptyToDefault(request.getHeader(Constants.APPCODE), Constants.DEFAULT_APP_NAME);
        String token =    StrUtil.emptyToDefault(request.getHeader(tokenKey()), "");
        String agent =    StrUtil.emptyToDefault(request.getHeader(Constants.USERAGENT), "");
        String uri =      request.getRequestURI();

        if (StrUtil.isEmpty(trackId)){
            trackId = UUIDUtil.trackingId(System.nanoTime());
        }
        MDC.put(Constants.TID, trackId);
        MDC.put(Constants.IP, ip);
        MDC.put(Constants.SESSIONID, sesionId);
        MDC.put(Constants.INTIME, StrUtil.toString(inTime));
        MDC.put(Constants.APPCODE, appCode);
        MDC.put(Constants.TOKEN, token);
        MDC.put(Constants.USERAGENT, agent);
        MDC.put(Constants.URI, uri);

        HandlerMethod handlerMethod = (HandlerMethod)handler;

        String method = handlerMethod.getBeanType().getName() + StrPool.DOT + handlerMethod.getMethod().getName();
        String param = JSONUtil.toJsonStr(request.getParameterMap());

        String url = new StringBuilder()
                .append(" uri=").append(uri)
                .append(" param=").append(param)
                .append(" method=").append(method)
                .toString();

        MDC.put(Constants.URL, url);

        StringBuilder accessLog = new StringBuilder()
                .append("tid=").append(trackId)
                .append(" appid=").append(appCode)
                .append(" token=").append(token)
                .append(" ip=").append(ip)
                .append(url)
                .append(" inTime=").append(inTime)
                .append(StrUtil.SPACE);

        logUriAccess(accessLog.toString());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        MDC.clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        StringBuilder processLog = new StringBuilder()
                .append("tid=").append(MDC.get(Constants.TID))
                .append(StrUtil.SPACE).append("uri=").append(request.getRequestURI())
                .append(StrUtil.SPACE).append("exec=").append(System.currentTimeMillis() - Long.parseLong(MDC.get(Constants.INTIME)));
        logUriAccess(processLog.toString());

        MDC.clear();
    }

    private void logUriAccess(String accessLog){
        log.info(accessLog);
    }

    protected abstract String tokenKey();
}
