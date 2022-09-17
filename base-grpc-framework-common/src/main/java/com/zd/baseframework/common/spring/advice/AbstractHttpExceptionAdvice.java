package com.zd.baseframework.common.spring.advice;

import com.zd.baseframework.common.constant.Constants;
import com.zd.baseframework.common.entity.restful.response.BaseResponse;
import com.zd.baseframework.common.exception.AppException;
import com.zd.baseframework.common.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Title: com.zd.baseframework.common.spring.advice.AbstractHttpExceptionAdvice
 * @Description 异常拦截器
 *  -- extends AbstractHttpExceptionAdvice
 *  -- @ControllerAdvice(value = {"com.zd.baseframework.core.controller.core"})
 * @author liudong
 * @date 2022-09-17 12:23 a.m.
 */
@Slf4j
public abstract class AbstractHttpExceptionAdvice {

    /**
     * AppException, UserException当作已知类型错误处理
     */
    @ResponseStatus(code = HttpStatus.OK)
    @ExceptionHandler(value = {AppException.class, UserException.class})
    @ResponseBody
    public BaseResponse dealKnownException(Exception e) {
        StringBuilder errorLog = new StringBuilder()
                .append("tid=").append(MDC.get(Constants.TID))
                .append(MDC.get(Constants.URL))
                .append(" dealErrMsg=").append(e.getMessage());

        logUriAccessError(errorLog.toString(), e);
        if (e instanceof AppException) {
            AppException vmException = (AppException) e;
            if (vmException.getStatus() != null) {
                return BaseResponse.error(vmException.getStatus(), e.getMessage());
            } else {
                return BaseResponse.error(e.getMessage());
            }
        } else {
            return BaseResponse.error(e.getMessage());
        }
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse afterThrowingLog(Exception e) {
        StringBuilder errorLog = new StringBuilder()
                .append("tid=").append(MDC.get(Constants.TID))
                .append(MDC.get(Constants.URL))
                .append(" afterErrMsg=").append(e.getMessage());
        logUriAccessError(errorLog.toString(), e);
        return BaseResponse.error(e.getMessage());
    }

    private void logUriAccessError(String errorLog, Exception e){
        log.error(errorLog, e);
    }
}
