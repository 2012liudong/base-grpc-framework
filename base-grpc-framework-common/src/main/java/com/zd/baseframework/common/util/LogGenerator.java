package com.zd.baseframework.common.util;


import cn.hutool.core.util.StrUtil;
import com.zd.baseframework.common.constant.Constants;
import org.slf4j.MDC;


/**
 * 用于调用方logStr生成和埋点日志生成
 * 日志格式:
 * 埋点日志：tid=7537479305976007099 appid=Bearer ip=/127.0.0.1:64446 uri=universe.core.cases.ICaseService/GetCaseByCaseNum inTime=1642129705403 k=s act=xxx
 * 异常日志：tid=7537479305976007099 appid=Bearer ip=/127.0.0.1:64446 uri=universe.core.cases.ICaseService/GetCaseByCaseNum inTime=1642129705403 ep=xxx
 * Created by liudong on 16/5/25.
 */
public final class LogGenerator {

    /*track日志获取*/
    public static String trackLog() {
        StringBuilder processLog = new StringBuilder()
                .append("tid=").append(MDC.get(Constants.TID))
                .append(StrUtil.SPACE);
        return processLog.toString();
    }

    /*track日志获取*/
    public static String trackUid() {
        return MDC.get(Constants.TID);
    }

    /**
     * 生成统计日志串，用于日志埋点，一般需要和其它方法合并使用：
     * 日志格式 k=s act=自定义埋点标识,可自定义
     * @param act 埋点标识
     */
    public static String analysisLog(String act) {
        StringBuilder sb = new StringBuilder()
                .append(" k=s")
                .append(" act=").append(act)
                .append(StrUtil.SPACE);
        return sb.toString();
    }
}
