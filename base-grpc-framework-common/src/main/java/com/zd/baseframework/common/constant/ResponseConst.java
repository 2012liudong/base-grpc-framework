package com.zd.baseframework.common.constant;

/**
 * @Title: com.zd.baseframework.common.constants.ResponseConst
 * @Description
 * @author liudong
 * @date 2022/6/15 8:48 PM
 */
public interface ResponseConst {

    int SUCCESS = 0;
    int FAIL = 1;

    int INVALID_PARAMS = -1;
    int INVALID_OPERATOR = -99;

    interface Msg{
        String SUCCESS = "success";
        String FAIL = "failed";
        String ERR_SYSTEM = "systemError";
        String ERR_SERVER = "serviceError";

        String INVALID_OPERATOR = "invalid operator";
        String INVALID_PARAMETER = "invalid parameter";
        String INVALID_STATUS = "invalid status";
        String INVALID_USER = "invalid user or invalid token";

        String ERR_SAVE = "save failed";
        String ERR_DELETE = "delete failed";
        String ERR_UPDATE = "modify failed";
        String ERR_GET = "search failed";

        String ERR_UPLOAD = "upload file failed";

        String ERR_ENTITY_IS_NOT_EXISTING = "entityObject is not exist ";
        String ERR_FILE_IS_NOT_EXISTS = "fileObject is not exist ";
    }

}
