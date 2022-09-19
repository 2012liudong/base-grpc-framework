package com.zd.baseframework.common.entity.convert;


import com.zd.baseframework.common.constant.Constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author shaocx
 * @Title: com.zd.baseframework.common.entity.mapstruct
 * @Description common mapstrut tool class. Notice the classpath of MapStructTransaltorUtil when use @Mapping(expression) annocation of Mapstruct.
 *              using 'imports={MapStructMapperUtil.class}'
 * @date 2022/1/7 下午3:40
 */
public class MapStructTransaltorUtil {

    //localdatetime to date and time
    public static String localDateToDate (LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(Constants.YYYY_MM_DD);
        return dtf2.format(localDateTime);
    }

    public static String localDateToTime (LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(Constants.HH_MM_SS);
        return dtf2.format(localDateTime);
    }

}

