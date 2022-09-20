package com.zd.baseframework.core.grpc.interceptor;

import cn.hutool.core.util.StrUtil;
import com.zd.baseframework.common.constant.enumeration.AppEnum;
import com.zd.baseframework.common.entity.restful.LoginUser;
import com.zd.baseframework.common.spring.grpc.AbstractGrpcTokenInterceptor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrpcTokenInterceptor extends AbstractGrpcTokenInterceptor {
    @Override
    protected LoginUser loginUser() {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(StrUtil.toString(AppEnum.DefaultSystemUser.SYSTEM.getCode()));
        loginUser.setUserName(AppEnum.DefaultSystemUser.SYSTEM.getText());
        return loginUser;
    }
}
