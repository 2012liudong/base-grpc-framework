package com.zd.baseframework.common.util;

import cn.hutool.extra.spring.SpringUtil;
import com.zd.baseframework.common.exception.AppException;
import com.zd.baseframework.common.spring.RestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author liudong
 * @date 2022-09-16 10:39 p.m.
 */
@Slf4j
public class HttpClientUtil {

    /**
     * 发送GET请求(form表单格式）获取返回数据
     */
    public static String getWithForm(String url, String params, String token) throws AppException {
        try {
            ResponseEntity<String> result = request(
                            HttpMethod.GET,
                            MediaType.APPLICATION_FORM_URLENCODED_VALUE,
                            url,
                            params,
                            token,
                            String.class);
            if (HttpStatus.OK == result.getStatusCode()) {
                return result.getBody();
            }
            throw new AppException("respCode=" + result.getStatusCode() + " respbody=" + result.getBody());
        } catch (RestClientException e) {
            throw new AppException(e.getMessage());
        }
    }

    public static String getWithJson(String url, String params, String token) throws AppException {
        try {
            ResponseEntity<String> result =
                    request(
                            HttpMethod.GET,
                            MediaType.APPLICATION_JSON_VALUE,
                            url,
                            params,
                            token,
                            String.class);
            if (HttpStatus.OK == result.getStatusCode()) {
                return result.getBody();
            }
            throw new AppException("respCode=" + result.getStatusCode() + " respbody=" + result.getBody());
        } catch (RestClientException e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * 发送POST请求获取json返回数据
     */
    public static String postWithJson(String url, String params, String token) throws AppException {
        try {
            ResponseEntity<String> result = request(
                    HttpMethod.POST,
                    MediaType.APPLICATION_JSON_VALUE,
                    url,
                    params,
                    token,
                    String.class);
            if (HttpStatus.OK == result.getStatusCode()) {
                return result.getBody();
            }
            throw new AppException("respCode=" + result.getStatusCode() + " respbody=" + result.getBody());
        } catch (RestClientException e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * 发起http请求
     */
    private static <T> ResponseEntity<T> request(
            HttpMethod httpMethod, String mediaType, String url, T params, String token, Class<T> response) throws RestClientException {
        if (mediaType == null) {
            mediaType = MediaType.APPLICATION_JSON_VALUE;
        }
        MultiValueMap<String, String> httpHeaders = new LinkedMultiValueMap<>();

        httpHeaders.put(HttpHeaders.CONTENT_TYPE, Collections.singletonList(mediaType));
        httpHeaders.put(HttpHeaders.AUTHORIZATION, Collections.singletonList(token));

        HttpEntity httpEntity = new HttpEntity(params, httpHeaders);

        RestTemplate restTemplate = SpringUtil.getBean(RestClient.REST_CLIENT_BEAN_NAME, RestTemplate.class);
        return restTemplate.exchange(url, httpMethod, httpEntity, response);
    }

}
