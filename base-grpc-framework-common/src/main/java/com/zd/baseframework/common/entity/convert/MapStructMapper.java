package com.zd.baseframework.common.entity.convert;

import cn.hutool.core.util.StrUtil;
import com.google.protobuf.*;
import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.util.Timestamps;
import com.zd.baseframework.common.constant.Constants;
import org.mapstruct.Mapper;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author liudong
 * @Title: BaseMapStructMapper
 * - java.lang.Boolean          ---  java.lang.Intege
 * - java.util.LocalDateTime    ---  java.util.Date
 * - java.util.LocalDateTime    ---  java.lang.String
 *
 * - java.lang.String           ---  com.google.protobuf.StringValue
 * - java.lang.Integer          ---  com.google.protobuf.Int32Value
 * - java.lang.Long             ---  com.google.protobuf.Int64Value
 * - java.lang.Float            ---  com.google.protobuf.FloatValue
 * - java.util.Date             ---  com.google.protobuf.util.Timestamps
 * - java.util.LocalDate        ---  com.google.protobuf.util.Timestamps
 * - java.util.LocalDateTime    ---  com.google.protobuf.util.Timestamps
 * - jsonString(java.lang.String)--- com.google.protobuf.util.Value
 * - jsonString(java.lang.String)--- com.google.protobuf.util.Struct
 *
 * @Description mapstrct tool class, user 'uses=BaseMapStructMapper.class'
 * @date 2022/2/6 4:24 AM
 */
@Mapper
public class MapStructMapper {

    /**================java basic type translator================*/

    /*Boolean---Integer*/
    public static int boolToInteger(Boolean source) {
        return source ? 1 : 0;
    }
    public static Boolean integerToBool(Integer source) {
        return (source != null && source.intValue() != 0);
    }

    /*LocalDateTime---Date*/
    public static Date localDateTimeToDate(LocalDateTime time) {
        if(time == null){
            return null;
        }
        ZonedDateTime zdt = time.atZone(ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }
    public static LocalDateTime dateToLocalDate (Date date) {
        if (date == null) {
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /*LocalDateTime --- String*/
    public static String localDateTimeToStr(LocalDateTime time, String format) {
        if (null == time) {
            return "";
        }
        if(StrUtil.isEmpty(format)){
            format = Constants.YYYY_MM_DD_HH_MM_SS;
        }
        return DateTimeFormatter.ofPattern(format).format(time);
    }
    public static LocalDateTime strToLocalDateTime(String timeStr, String format) {
        if (StrUtil.isEmpty(timeStr)) {
            return null;
        }
        if(StrUtil.isEmpty(format)){
            format = Constants.YYYY_MM_DD_HH_MM_SS;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(timeStr, df);
    }

    /**================protobuf type translator================*/
    /*java.lang.String --- com.google.protobuf.StringValue*/
    public static String stringValueToString(StringValue value) {
        return value.getValue();
    }
    public static StringValue javaStringToStringValue(String value) {
        return StringValue.of(value);
    }

    /*java.lang.Integer --- com.google.protobuf.Int32Value*/
    public static Int32Value integerToInt32(Integer value) {
        return Int32Value.of(value);
    }
    public static Integer int32ToInteger(Int32Value value) {
        return value.getValue();
    }

    /*java.lang.Long --- com.google.protobuf.Int64Value*/
    public static Int64Value longToInt64(Long value) {
        return Int64Value.of(value);
    }
    public static Long int64ToLong(Int64Value value) {
        return value.getValue();
    }

    /*java.lang.Float --- com.google.protobuf.FloatValue*/
    public static FloatValue floatToFloatValue(Float value) {
        return FloatValue.of(value);
    }
    public static Float floatValueToFloat(FloatValue value) {
        return value.getValue();
    }

    /*java.util.Date---com.google.protobuf.util.Timestamps*/
    public static Timestamp javaDateToGoogleTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return Timestamps.fromMillis(date.getTime());
    }
    public static Date googleTimestampToJavaDate(Timestamp timestamp) {
        if (timestamp == null  || timestamp.getSeconds()<=0) {
            return null;
        }
        return new Date(timestamp.getSeconds() * 1000);
    }

    /*java.util.LocalDateTime---com.google.protobuf.util.Timestamps*/
    public static Timestamp localDateTimetoGoogleTimestamp(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Timestamps.fromMillis(localDateTimeToDate(localDateTime).getTime());
//        return Timestamp.newBuilder().setSeconds(localDateTime.getSecond()).setNanos(localDateTime.getNano()).build();
//        return Timestamps.fromMillis(localDateTime.getSecond());
    }
    public static LocalDateTime googleTimestampToLocalDateTime(Timestamp timestamp) {
        //解决1970-01-01 入参 返回null问题
        if (timestamp == null || timestamp.getSeconds()< 0) {
            return null;
        }
        Date date = new Date(timestamp.getSeconds() * 1000);
        Instant instant = date.toInstant();
        return instant.atZone( ZoneId.systemDefault() ).toLocalDateTime();
    }

    /*java.util.LocalDate---com.google.protobuf.util.Timestamps*/
    public static Timestamp localDatetoGoogleTimestamp(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return MapStructMapper.localDateTimetoGoogleTimestamp(localDate.atStartOfDay());
    }
    public static LocalDate googleTimestampToLocalDate(Timestamp timestamp) {
        if (timestamp == null  || timestamp.getSeconds()<=0) {
            return null;
        }
        return MapStructMapper.googleTimestampToLocalDateTime(timestamp).toLocalDate();
    }

    /*jsonString---com.google.protobuf.util.Value*/
    public static String valueToJson(Value value) {
        String json = null;
        try {
            if(value!=null){
                json = JsonFormat.printer().includingDefaultValueFields().print(value);
            }
        } catch (InvalidProtocolBufferException e) {
            return json;
        }
        return json;
    }
    public static Value jsonToValue(String json) {
        Value.Builder builder = Value.newBuilder();
        try {
            if(StrUtil.isNotEmpty(json)){
                JsonFormat.parser().merge(json, builder);
            }
        } catch (InvalidProtocolBufferException e) {
            return builder.build();
        }
        return builder.build();
    }

    /*jsonString---com.google.protobuf.util.Struct*/
    public static String structToJson(Struct struct) {
        String json = null;
        try {
            if(struct!=null){
                json = JsonFormat.printer().includingDefaultValueFields().print(struct);
            }

        } catch (InvalidProtocolBufferException e) {
            return json;
        }
        return json;
    }
    public static Struct jsonToStruct(String json) {
        Struct.Builder builder = Struct.newBuilder();
        try {
            if(StrUtil.isNotEmpty(json)){
                JsonFormat.parser().merge(json, builder);
            }
        } catch (InvalidProtocolBufferException e) {
            return builder.build();
        }
        return builder.build();
    }

}
