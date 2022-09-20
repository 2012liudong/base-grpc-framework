package com.zd.baseframework.common.constant.enumeration;

import cn.hutool.core.util.StrUtil;

import java.util.Locale;

/**
 * @author liudong
 * @Title: com.zd.baseframework.common.constants.enumeration.AppEnumTranslatorUtil
 * @Description A business-related Mapstruct tool class that cannot be moved anywhere because most of the converted code
 * is written dead in strings, this tool class proxies appenumInitializer.java .Access method of enumeration values, when
 * the parameter for case-insensitive string, in the translator interface class, using imports = {AppEnumTranslatorUtil. Class},
 * introducing the detailed agent as follows:：
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
    public static AppEnum.DefaultSystemUser getSystemOperatorUser(String text, Integer code) {
        if ( StrUtil.isNotEmpty(text) ) {
            return Enum.valueOf(AppEnum.DefaultSystemUser.class, text.toUpperCase(Locale.ROOT));
        }
        return AppEnumInitializer.defaultSystemUserCodeMap.get(code);
    }

    public static Integer getSystemOperatorUser(String text) {
        AppEnum.DefaultSystemUser bo = AppEnumTranslatorUtil.getSystemOperatorUser(text, null);
        return bo==null ? null : bo.getCode();
    }

    public static String getSystemOperatorUser(Integer code) {
        AppEnum.DefaultSystemUser bo = AppEnumTranslatorUtil.getSystemOperatorUser(null, code);
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
