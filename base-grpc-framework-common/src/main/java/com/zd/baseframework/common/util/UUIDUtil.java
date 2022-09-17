package com.zd.baseframework.common.util;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

public class UUIDUtil {

    public final static String LETTER_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final static int DEFAULT_LETTER_LEN = 2;
    public final static int DEFAULT_NUMBER_LEN = 8;

    public static String uuid32(){
        return StrUtil.replace(UUID.fastUUID().toString(), StrPool.DASHED, "");
    }

    public static String randomNumberAndLetter(String prefix){
        return UUIDUtil.randomNumberAndLetter(prefix, null, null, null);
    }

    public static String randomNumberAndLetter(String prefix, String suffix, Integer numLenght, Integer letterLength){
        StringBuilder result = new StringBuilder();
        if(StrUtil.isNotEmpty(prefix)){
            result.append(prefix);
        }
        result.append(RandomUtil.randomString(UUIDUtil.LETTER_UPPER, letterLength==null?DEFAULT_LETTER_LEN:letterLength.intValue()));
        result.append(RandomUtil.randomNumbers(numLenght==null?DEFAULT_NUMBER_LEN:numLenght.intValue()));

        if(StrUtil.isNotEmpty(suffix)){
            result.append(suffix);
        }
        return result.toString();
    }

    public static String trackingId(long param){
        long nowTime = System.currentTimeMillis();
        long logId = nowTime & 281474976710655L | (param >> 8 & 65535L) << 47;
        return String.valueOf(logId);
    }

}
