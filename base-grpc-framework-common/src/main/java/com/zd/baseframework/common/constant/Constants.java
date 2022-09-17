package com.zd.baseframework.common.constant;

import cn.hutool.core.util.StrUtil;

/**
 * 存放与业务无关的一些常量
 * Created by liudong on 2017/5/26.
 */
public interface Constants {

    /*用于拼接字符串，斜线。 更多可查看 StrPool.java 和CharPool.java*/
    String PATH_SEPERATE = StrUtil.SLASH;

    String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    String YYYY_MM_DD = "yyyy-MM-dd";
    String HH_MM_SS = "HH:mm:ss";
    String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    String YYYYMMDD = "yyyyMMdd";
    String HHMMSS = "HHmmss";
    long DAY_OF_TIMEMILLIS = 86400000;

    String CONTENT_TYPE_DOWNLOAD = "application/x-download";
    String CONTENT_TYPE_JSON = "application/json";
    String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    String CONTENT_TYPE_STREAM = "application/octet-stream";

    int DEFAULT_PAGE_SIZE = 50;
    int DEFAULT_PAGE_NUM = 1;


    /*interceptor相关, 系统内部使用的变量名*/
    String DEFAULT_APP_NAME = "noset";

    String TID = "TID";
    String IP = "IP";
    String SESSIONID = "SESSIONID";
    String INTIME = "INTIME";
    String URI = "URI";
    String APPCODE = "APPCODE";
    String TOKEN = "TOKEN";
    String USERAGENT = "USERAGENT";
    String URL = "URL";

    String USER_PARAM_ID = "USERID";
    String USER_PARAM_USERNAME = "USERNAME"; //中文名称

}
