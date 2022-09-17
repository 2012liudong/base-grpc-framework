package com.zd.baseframework.common.spring;

import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.zd.baseframework.common.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @Title: com.shukun.data.config.RestTemplateConfig
 * @Description 用于创建http连接使用
 * @author liudong
 * @date 2022-07-14 3:59 p.m.
 */
@Slf4j
@Component
public class RestClient {
    public final static String REST_CLIENT_BEAN_NAME = "restfulClient";

    @Bean
    public RestTemplate restfulClient(@Qualifier("simpleClientHttpRequestFactory") ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(
                MediaType.TEXT_HTML,
                MediaType.TEXT_PLAIN));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        // Returns the timeout in milliseconds used when requesting a connection from the connection manager, 从连接池中获取连接的等待超时时间10min
        httpRequestFactory.setConnectionRequestTimeout(10 * 60 * 1000);
        // Determines the timeout in milliseconds until a connection is established，连接和服务器的建立时间5mins
        httpRequestFactory.setConnectTimeout(5 * 60 * 1000);
        // Defines the socket timeout (SO_TIMEOUT) in milliseconds, which is the timeout for waiting for data or, put differently, a maximum period inactivity between two consecutive data packets,通信时间，最大5mins
        httpRequestFactory.setReadTimeout(5 * 60 * 1000);
        buildHttpClient(httpRequestFactory);
        return httpRequestFactory;
    }

    private static void buildHttpClient(HttpComponentsClientHttpRequestFactory httpRequestFactory) {
        try {
            // 设定请求池最大请求数256，单个route最大请求数32
            HttpClient httpClient = HCB.custom().pool(256, 32).build();
            httpRequestFactory.setHttpClient(httpClient);
        } catch (HttpProcessException e) {
            log.error(e.getMessage(), e);
            throw new AppException(e);
        }
    }
}


