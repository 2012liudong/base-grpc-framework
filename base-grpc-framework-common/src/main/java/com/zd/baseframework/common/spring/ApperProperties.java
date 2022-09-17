package com.zd.baseframework.common.spring;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app-properties", ignoreUnknownFields = true)
public class ApperProperties {

    /*页面传递的token的keyName*/
    private String tokenKey = "TOKEN";

    /*需拦截的URL地址，支持正则*/
    private String httpApiPath = "/*";

}
