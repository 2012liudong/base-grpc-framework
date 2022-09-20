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

    public static String trackLog() {
        StringBuilder processLog = new StringBuilder()
                .append(Constants.TID_TITLE).append("=").append(MDC.get(Constants.TID))
                .append(StrUtil.SPACE);
        return processLog.toString();
    }

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
                .append(StrUtil.SPACE).append(Constants.ANALYCIS_TITLE).append("=").append(act)
                .append(StrUtil.SPACE);
        return sb.toString();
    }
}
