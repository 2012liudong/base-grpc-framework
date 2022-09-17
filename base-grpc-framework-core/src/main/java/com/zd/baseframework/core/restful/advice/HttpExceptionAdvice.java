package com.zd.baseframework.core.restful.advice;

import com.zd.baseframework.common.spring.advice.AbstractHttpExceptionAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice(value = {"com.zd.baseframework.core.restful"})
public class HttpExceptionAdvice extends AbstractHttpExceptionAdvice {
}
