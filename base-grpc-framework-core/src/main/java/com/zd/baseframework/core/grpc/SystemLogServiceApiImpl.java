package com.zd.baseframework.core.grpc;

import com.zd.baseframework.common.constant.ResponseConst;
import com.zd.baseframework.common.entity.service.PageBo;
import com.zd.baseframework.common.exception.AppException;
import com.zd.baseframework.common.util.LogGenerator;
import com.zd.baseframework.core.api.systemlog.*;
import com.zd.baseframework.core.core.systemlog.ISystemLogServcie;
import com.zd.baseframework.core.core.systemlog.model.SystemLogBo;
import com.zd.baseframework.core.core.systemlog.model.SystemLogQueryBo;
import com.zd.baseframework.core.grpc.model.SystemLogDtoTranslator;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GrpcService
@Slf4j
public class SystemLogServiceApiImpl extends ISystemLogServiceGrpc.ISystemLogServiceImplBase {

    @Autowired
    private ISystemLogServcie iSystemLogServcie;

    @Override
    public void createSystemLog(CreateSystemLogRequest request, StreamObserver<SystemLogOperatorResponse> responseObserver)  {
        try{
            SystemLogBo systemLogBo = SystemLogDtoTranslator.INSTANCE.toBo(request);
            systemLogBo.setTrackUid(LogGenerator.trackUid());

            String uuid = iSystemLogServcie.createSystemLog(systemLogBo);
            SystemLogOperatorResponse response  = SystemLogOperatorResponse.newBuilder()
                    .setStatus(ResponseConst.SUCCESS)
                    .setMessage(ResponseConst.Msg.SUCCESS)
                    .setData(uuid)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(AppException e){
            //TODO 这行会返回StatusRuntimeException异常，后面可以考虑改成异常拦截器在DelegateCall中实现
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asException());
        }
    }

    @Override
    public void listSystemLogByCondition(ListSystemLogRequest request, StreamObserver<ListSystemLogResponse> responseObserver) {
        try{
            SystemLogQueryBo systemLogQueryBo = SystemLogDtoTranslator.INSTANCE.toBo(request);
            List<SystemLogBo> systemLogBoList = iSystemLogServcie.listByCondition(systemLogQueryBo);

            List<SystemLogDto> dtos = SystemLogDtoTranslator.INSTANCE.toDto(systemLogBoList);

            ListSystemLogResponse response = ListSystemLogResponse.newBuilder().addAllData(dtos).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }catch (AppException e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asException());
        }
    }

    @Override
    public void pageSystemLog(PageSystemLogRequest request, StreamObserver<PageSystemLogResponse> responseObserver) {
        try{

            String bizId = request.hasBizId()?request.getBizId().getValue():null;
            String code = request.hasCode()?request.getCode().getValue():null;

            //build service request parameter
            PageBo<SystemLogBo> pageBo = iSystemLogServcie.pageSearch(SystemLogDtoTranslator.INSTANCE.toBo(request),
                    bizId,
                    code);
            List<SystemLogDto> systemLogDtos = SystemLogDtoTranslator.INSTANCE.toDto(pageBo.getData());

            PageSystemLogResponse response = PageSystemLogResponse.newBuilder()
                    .addAllData(systemLogDtos)
                    .setCount(pageBo.getCount())
                    .setCurrentPage(pageBo.getPageNum())
                    .setPageSize(pageBo.getPageSize())
                    .setOffset(pageBo.getOffset())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (AppException e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asException());
        }
    }
}