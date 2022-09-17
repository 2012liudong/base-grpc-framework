package com.zd.baseframework.common.constant.enumeration;

import cn.hutool.core.util.StrUtil;

import java.util.Locale;

/**
 * @author liudong
 * @Title: com.zd.baseframework.common.constants.enumeration.AppEnumTranslatorUtil
 * @Description 和业务相关的mapstrct工具类，此类不能随便移位置，因为多数转换的代码是写死在字符串中的，这个工具类代理了AppEnumInitializer.java中
 * 的枚举值的获取方法，当入参为字符串时不区分大小写，在translator接口类中，采用imports={AppEnumTranslatorUtil.class}方式引入，详细的代理了如下：
 *      --SystemOperatorUser：系统用户
 * @date 2022/1/28 2:30 PM
 */
public class AppEnumTranslatorUtil {

    /**
     * <Enable>
     */
    public static AppEnum.Enable getEnable(String text, Integer code) {
        if ( StrUtil.isNotEmpty(text) ) {
            return Enum.valueOf(AppEnum.Enable.class, text.toUpperCase(Locale.ROOT));
        }
        return AppEnumInitializer.enableCodeMap.get(code);
    }

    public static Integer getEnable(String text) {
        AppEnum.Enable bo = AppEnumTranslatorUtil.getEnable(text, null);
        return bo==null ? null : bo.getCode();
    }

    public static String getEnable(Integer code) {
        AppEnum.Enable bo = AppEnumTranslatorUtil.getEnable(null, code);
        return bo==null ? null : bo.getText();
    }

    /**
     * <SystemOperatorUser>
     */
    public static AppEnum.SystemOperatorUser getSystemOperatorUser(String text, Integer code) {
        if ( StrUtil.isNotEmpty(text) ) {
            return Enum.valueOf(AppEnum.SystemOperatorUser.class, text.toUpperCase(Locale.ROOT));
        }
        return AppEnumInitializer.systemOperatorCodeMap.get(code);
    }

    public static Integer getSystemOperatorUser(String text) {
        AppEnum.SystemOperatorUser bo = AppEnumTranslatorUtil.getSystemOperatorUser(text, null);
        return bo==null ? null : bo.getCode();
    }

    public static String getSystemOperatorUser(Integer code) {
        AppEnum.SystemOperatorUser bo = AppEnumTranslatorUtil.getSystemOperatorUser(null, code);
        return bo==null ? null : bo.getText();
    }

    /**
     * <DataSort>
     */
    public static AppEnum.DataSort getDataSort(String text, Integer code) {
        if ( StrUtil.isNotEmpty(text) ) {
            return Enum.valueOf(AppEnum.DataSort.class, text.toUpperCase(Locale.ROOT));
        }
        return AppEnumInitializer.dataSortCodeMap.get(code);
    }

    public static Integer getDataSort(String text) {
        AppEnum.DataSort bo = AppEnumTranslatorUtil.getDataSort(text, null);
        return bo==null ? null : bo.getCode();
    }

    public static String getDataSort(Integer code) {
        AppEnum.DataSort bo = AppEnumTranslatorUtil.getDataSort(null, code);
        return bo==null ? null : bo.getText();
    }

    /**
     * <Status>
     */
    public static AppEnum.Status getStatus(String text, Integer code) {
        if ( StrUtil.isNotEmpty(text) ) {
            return Enum.valueOf(AppEnum.Status.class, text.toUpperCase(Locale.ROOT));
        }
        return AppEnumInitializer.statusCodeMap.get(code);
    }

    public static Integer getStatus(String text) {
        AppEnum.Status bo = AppEnumTranslatorUtil.getStatus(text, null);
        return bo==null ? null : bo.getCode();
    }

    public static String getStatus(Integer code) {
        AppEnum.Status bo = AppEnumTranslatorUtil.getStatus(null, code);
        return bo==null ? null : bo.getText();
    }
}
