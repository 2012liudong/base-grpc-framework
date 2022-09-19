package com.zd.baseframework.common.spring;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app-properties", ignoreUnknownFields = true)
public class ApperProperties {

    /*token keyName*/
    private String tokenKey = "TOKEN";

    /*URL to be intercepted, support regular*/
    private String httpApiPath = "/*";

}
