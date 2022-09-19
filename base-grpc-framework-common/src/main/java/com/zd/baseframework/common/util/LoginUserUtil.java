package com.zd.baseframework.common.util;


import com.zd.baseframework.common.constant.Constants;
import org.slf4j.MDC;

/**
 * @Title: com.zd.baseframework.common.util.LoginUserUtil
 * @Description
 * @author liudong
 * @date 2022-07-28 12:11 a.m.
 */
public class LoginUserUtil {

    public static String getCurrentUserId(){
        return MDC.get(Constants.USER_PARAM_ID);
    }

    public static String getCurrentUserName(){
        return MDC.get(Constants.USER_PARAM_USERNAME);
    }

    public static String getCurrentUserToken(){
        return MDC.get(Constants.TOKEN);
    }

}
