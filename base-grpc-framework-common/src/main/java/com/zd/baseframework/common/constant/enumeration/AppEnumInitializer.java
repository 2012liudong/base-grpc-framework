package com.zd.baseframework.common.constant.enumeration;

import cn.hutool.core.util.EnumUtil;

import java.util.HashMap;
import java.util.Map;

public final class AppEnumInitializer {

    public static Map<Integer, AppEnum.Enable> enableCodeMap = new HashMap<>();
    public static Map<Integer, AppEnum.SystemOperatorUser> systemOperatorCodeMap = new HashMap<>();
    public static Map<Integer, AppEnum.DataSort> dataSortCodeMap = new HashMap<>();
    public static Map<Integer, AppEnum.Status> statusCodeMap = new HashMap<>();

    static{
        //--
        for (Map.Entry<String, AppEnum.Enable> entry : EnumUtil.getEnumMap(AppEnum.Enable.class).entrySet()) {
            enableCodeMap.put(entry.getValue().getCode(), entry.getValue());
        }
        //--
        for (Map.Entry<String, AppEnum.SystemOperatorUser> entry : EnumUtil.getEnumMap(AppEnum.SystemOperatorUser.class).entrySet()) {
            systemOperatorCodeMap.put(entry.getValue().getCode(), entry.getValue());
        }
        //--
        for (Map.Entry<String, AppEnum.DataSort> entry : EnumUtil.getEnumMap(AppEnum.DataSort.class).entrySet()) {
            dataSortCodeMap.put(entry.getValue().getCode(), entry.getValue());
        }
        //--
        for (Map.Entry<String, AppEnum.Status> entry : EnumUtil.getEnumMap(AppEnum.Status.class).entrySet()) {
            statusCodeMap.put(entry.getValue().getCode(), entry.getValue());
        }

    }
}
