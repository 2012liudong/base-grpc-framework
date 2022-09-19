package com.zd.baseframework.core.restful;

import com.google.protobuf.StringValue;
import com.zd.baseframework.common.entity.restful.response.BaseResponse;
import com.zd.baseframework.common.entity.restful.response.ListResponse;
import com.zd.baseframework.common.entity.restful.response.PageResponse;
import com.zd.baseframework.common.exception.AppException;
import com.zd.baseframework.core.api.systemlog.*;
import com.zd.baseframework.core.restful.model.request.SystemLogQueryRequest;
import com.zd.baseframework.core.restful.model.translator.SystemLogGrpcTranslator;
import com.zd.baseframework.core.restful.model.vo.SystemLogVo;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/systemlog_grpc")
public class SystemLogGrpcController {

    @GrpcClient("inProcess")
    private ISystemLogServiceGrpc.ISystemLogServiceBlockingStub iSysRecordServiceBlockingStub;

    @GetMapping("/v1/create")
    public BaseResponse create(
            @RequestParam(value="biz_id") String bizId,
            @RequestParam(value="user_id") String userId,
            @RequestParam(value="code") String code,
            @RequestParam(value="custom_code", required=false) String customCode){
        try{
            //build grpc request dto
            CreateSystemLogRequest createSysRecordRequest  = CreateSystemLogRequest.newBuilder()
                    .setBizId(StringValue.of(bizId))
                    .setUserId(StringValue.of(userId))
                    .setCode(StringValue.of(code))
                    .setCustomCode(StringValue.of(customCode))
                    .build();

            //process grpc server response, better handle the value of response state with if statement firstly
            SystemLogOperatorResponse response = iSysRecordServiceBlockingStub.createSystemLog(createSysRecordRequest);
            return BaseResponse.success(response.getData());
        }catch(StatusRuntimeException e){
            throw  new AppException(e);
        }
    }

    @PostMapping("/v1/list")
    public ListResponse<List<SystemLogVo>> list(@RequestBody SystemLogQueryRequest pageRequest){
        try{
            //build grpc request dto
            ListSystemLogRequest listSystemLogRequest  = SystemLogGrpcTranslator.INSTANCE.toDto(pageRequest);

            ListSystemLogResponse listSystemLogResponse = iSysRecordServiceBlockingStub.listSystemLogByCondition(listSystemLogRequest);
            List<SystemLogVo> vos = SystemLogGrpcTranslator.INSTANCE.toVo(listSystemLogResponse.getDataList());

            return ListResponse.success(vos);
        } catch(StatusRuntimeException e){
            throw  new AppException(e);
        }
    }

    @PostMapping("/v1/page")
    public PageResponse<List<SystemLogVo>> page(@RequestBody SystemLogQueryRequest pageRequest){
        try{
            //build grpc request dto
            PageSystemLogRequest requestForGrpc = SystemLogGrpcTranslator.INSTANCE.toPageDto(pageRequest);
            PageSystemLogResponse gRpcresponse = iSysRecordServiceBlockingStub.pageSystemLog(requestForGrpc);

            //process grpc server response
            PageResponse<List<SystemLogVo>> pageResponse = PageResponse.success();
            pageResponse.setTotal(gRpcresponse.getCount());
            pageResponse.setPageSize(gRpcresponse.getPageSize());
            pageResponse.setCurrentPage(gRpcresponse.getCurrentPage());
            pageResponse.setOffset(gRpcresponse.getOffset());

            //add data record to pageResponse
            List<SystemLogVo> vos = SystemLogGrpcTranslator.INSTANCE.toVo(gRpcresponse.getDataList());
            pageResponse.setData(vos);

            return pageResponse;
        } catch(StatusRuntimeException e){
            throw  new AppException(e);
        }
    }
}




