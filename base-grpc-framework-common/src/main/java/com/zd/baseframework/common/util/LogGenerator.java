package com.zd.baseframework.common.util;


import cn.hutool.core.util.StrUtil;
import com.zd.baseframework.common.constant.Constants;
import org.slf4j.MDC;


/**
 * Log content format :
 * - for analycis：tid=7537479305976007099 appid=Bearer ip=/127.0.0.1:64446 uri=universe.core.cases.ICaseService/GetCaseByCaseNum inTime=1642129705403 k=s act=xxx
 * - for exception：tid=7537479305976007099 appid=Bearer ip=/127.0.0.1:64446 uri=universe.core.cases.ICaseService/GetCaseByCaseNum inTime=1642129705403 ep=xxx
 * Created by liudong on 16/5/25.
 */
public final class LogGenerator {

    /*get tracklog*/
    public static String trackLog() {
        StringBuilder processLog = new StringBuilder()
                .append("tid=").append(MDC.get(Constants.TID))
                .append(StrUtil.SPACE);
        return processLog.toString();
    }

    /*get trackuid*/
    public static String trackUid() {
        return MDC.get(Constants.TID);
    }

    /**
     * analycisLog
     * @param act :  analycis identify
     */
    public static String analysisLog(String act) {
        StringBuilder sb = new StringBuilder()
                .append(" k=s")
                .append(" act=").append(act)
                .append(StrUtil.SPACE);
        return sb.toString();
    }
}
