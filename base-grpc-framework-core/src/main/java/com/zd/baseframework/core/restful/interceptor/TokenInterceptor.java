package com.zd.baseframework.core.restful.interceptor;

import cn.hutool.core.util.StrUtil;
import com.zd.baseframework.common.constant.enumeration.AppEnum;
import com.zd.baseframework.common.entity.restful.LoginUser;
import com.zd.baseframework.common.spring.restful.AbstractTokenInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TokenInterceptor extends AbstractTokenInterceptor {

    @Override
    protected LoginUser loginUser() {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(StrUtil.toString(AppEnum.DefaultSystemUser.SYSTEM.getCode()));
        loginUser.setUserName(AppEnum.DefaultSystemUser.SYSTEM.getText());
        return loginUser;
    }
}
