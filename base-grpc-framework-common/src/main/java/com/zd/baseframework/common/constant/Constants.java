package com.zd.baseframework.common.constant;

import cn.hutool.core.util.StrUtil;

/**
 * Created by liudong on 2017/5/26.
 */
public interface Constants {

    /*for string, see more in StrPool.java and CharPool.java*/
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


    /*interceptor: only use server module*/
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
