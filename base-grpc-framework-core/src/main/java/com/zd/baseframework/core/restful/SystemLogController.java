package com.zd.baseframework.core.restful;

import com.zd.baseframework.common.entity.restful.response.BaseResponse;
import com.zd.baseframework.common.entity.restful.response.ListResponse;
import com.zd.baseframework.common.entity.restful.response.PageResponse;
import com.zd.baseframework.common.entity.service.PageBo;
import com.zd.baseframework.common.util.LogGenerator;
import com.zd.baseframework.common.util.PageUtil;
import com.zd.baseframework.core.core.systemlog.ISystemLogServcie;
import com.zd.baseframework.core.core.systemlog.model.SystemLogBo;
import com.zd.baseframework.core.core.systemlog.model.SystemLogQueryBo;
import com.zd.baseframework.core.restful.model.request.SystemLogQueryRequest;
import com.zd.baseframework.core.restful.model.translator.SystemLogRestTranslator;
import com.zd.baseframework.core.restful.model.vo.SystemLogVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: com.zd.baseframework.core.restful.SystemLogController
 * @Description demo code: suggested, rule by Controller-Service-Dao
 *  -  Param annocation：RequestParam, RequestBody, RequestHeader, RequestPath(no suggest）, RequestPart(fileUpload），can fixed
 *  -  Restful annocation：GetMapping, PostMapping. Because of system secure policies, do not suggest to use 'delete, put etc.'
 * @author liudong
 * @date 2022-09-17 2:16 p.m.
 */
@Slf4j
@RestController
@RequestMapping("/api/systemlog_restful")
public class SystemLogController {

    @Autowired
    private ISystemLogServcie iSystemLogServcie;

    @GetMapping("/v1/create")
    public BaseResponse create(
            @RequestParam(value="biz_id") String bizId,
            @RequestParam(value="user_id") String userId,
            @RequestParam(value="code") String code,
            @RequestParam(value="custom_code", required=false) String customCode){

        SystemLogBo systemLogBo = new SystemLogBo();
        systemLogBo.setBizId(bizId);
        systemLogBo.setUserId(userId);
        systemLogBo.setCode(code);
        systemLogBo.setCustomCode(customCode);

        systemLogBo.setTrackUid(LogGenerator.trackUid());

        String uuid = iSystemLogServcie.createSystemLog(systemLogBo);

        return BaseResponse.success(uuid);
    }

    @PostMapping("/v1/list")
    public ListResponse<List<SystemLogVo>> list(@RequestBody SystemLogQueryRequest systemLogRequest){

        SystemLogQueryBo queryBo = SystemLogRestTranslator.INSTANCE.toBo(systemLogRequest);

        List<SystemLogBo> systemLogBos = iSystemLogServcie.listByCondition(queryBo);
        List<SystemLogVo> systemLogVos = SystemLogRestTranslator.INSTANCE.toVo(systemLogBos);

        return ListResponse.success(systemLogVos);
    }

    @PostMapping("/v1/page")
    public PageResponse<List<SystemLogVo>> page(@RequestBody SystemLogQueryRequest pageRequest){
        //build request params
        PageBo<SystemLogBo> pageBo = iSystemLogServcie.pageSearch(PageUtil.buildServiceRequestParameter(pageRequest),
                pageRequest.getBizId(),
                pageRequest.getCode());
        List<SystemLogVo> systemLogVos = SystemLogRestTranslator.INSTANCE.toVo(pageBo.getData());

        PageResponse<List<SystemLogVo>> response = PageUtil.handleResponseToRestful(pageBo, systemLogVos);

        return response;
    }
}