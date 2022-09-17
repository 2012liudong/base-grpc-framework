package com.zd.baseframework.common.util;

import cn.hutool.core.util.StrUtil;
import com.zd.baseframework.common.exception.AppException;

/**
 * @Title: com.zd.baseframework.common.util.AppAssertUtil
 * @Description 业务断言
 * @author liudong
 * @date 2022-09-16 10:34 p.m.
 */
public final class AssertUtil {

    public static void isTrue(boolean expression, String message) {
        if (expression) {
            return;
        }
        throw new AppException(message);
    }

    public static void iTrue(boolean expression, Integer code,String message) {
        if (expression) {
            return;
        }
        throw new AppException(code, message);
    }

    public static void isFalse(boolean expression, String message) {
        if (expression) {
            throw new AppException(message);
        }
    }

    public static void isFalse(boolean expression, Integer code,String message) {
        if (expression) {
            throw new AppException(code,message);
        }
    }

    public static void isEmpty(String object, String message) {
        if (StrUtil.isEmpty(object)) {
            throw new AppException(message);
        }
    }
}
