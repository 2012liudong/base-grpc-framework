package com.zd.baseframework.core.api.systemlog;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.1)",
    comments = "Source: systemlog.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ISystemLogServiceGrpc {

  private ISystemLogServiceGrpc() {}

  public static final String SERVICE_NAME = "com.zd.baseframework.core.api.systemlog.ISystemLogService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest,
      com.zd.baseframework.core.api.systemlog.SystemLogOperatorResponse> getCreateSystemLogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSystemLog",
      requestType = com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest.class,
      responseType = com.zd.baseframework.core.api.systemlog.SystemLogOperatorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest,
      com.zd.baseframework.core.api.systemlog.SystemLogOperatorResponse> getCreateSystemLogMethod() {
    io.grpc.MethodDescriptor<com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest, com.zd.baseframework.core.api.systemlog.SystemLogOperatorResponse> getCreateSystemLogMethod;
    if ((getCreateSystemLogMethod = ISystemLogServiceGrpc.getCreateSystemLogMethod) == null) {
      synchronized (ISystemLogServiceGrpc.class) {
        if ((getCreateSystemLogMethod = ISystemLogServiceGrpc.getCreateSystemLogMethod) == null) {
          ISystemLogServiceGrpc.getCreateSystemLogMethod = getCreateSystemLogMethod =
              io.grpc.MethodDescriptor.<com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest, com.zd.baseframework.core.api.systemlog.SystemLogOperatorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSystemLog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zd.baseframework.core.api.systemlog.SystemLogOperatorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ISystemLogServiceMethodDescriptorSupplier("CreateSystemLog"))
              .build();
        }
      }
    }
    return getCreateSystemLogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.zd.baseframework.core.api.systemlog.ListSystemLogRequest,
      com.zd.baseframework.core.api.systemlog.ListSystemLogResponse> getListSystemLogByConditionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSystemLogByCondition",
      requestType = com.zd.baseframework.core.api.systemlog.ListSystemLogRequest.class,
      responseType = com.zd.baseframework.core.api.systemlog.ListSystemLogResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.zd.baseframework.core.api.systemlog.ListSystemLogRequest,
      com.zd.baseframework.core.api.systemlog.ListSystemLogResponse> getListSystemLogByConditionMethod() {
    io.grpc.MethodDescriptor<com.zd.baseframework.core.api.systemlog.ListSystemLogRequest, com.zd.baseframework.core.api.systemlog.ListSystemLogResponse> getListSystemLogByConditionMethod;
    if ((getListSystemLogByConditionMethod = ISystemLogServiceGrpc.getListSystemLogByConditionMethod) == null) {
      synchronized (ISystemLogServiceGrpc.class) {
        if ((getListSystemLogByConditionMethod = ISystemLogServiceGrpc.getListSystemLogByConditionMethod) == null) {
          ISystemLogServiceGrpc.getListSystemLogByConditionMethod = getListSystemLogByConditionMethod =
              io.grpc.MethodDescriptor.<com.zd.baseframework.core.api.systemlog.ListSystemLogRequest, com.zd.baseframework.core.api.systemlog.ListSystemLogResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSystemLogByCondition"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zd.baseframework.core.api.systemlog.ListSystemLogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zd.baseframework.core.api.systemlog.ListSystemLogResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ISystemLogServiceMethodDescriptorSupplier("ListSystemLogByCondition"))
              .build();
        }
      }
    }
    return getListSystemLogByConditionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.zd.baseframework.core.api.systemlog.PageSystemLogRequest,
      com.zd.baseframework.core.api.systemlog.PageSystemLogResponse> getPageSystemLogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PageSystemLog",
      requestType = com.zd.baseframework.core.api.systemlog.PageSystemLogRequest.class,
      responseType = com.zd.baseframework.core.api.systemlog.PageSystemLogResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.zd.baseframework.core.api.systemlog.PageSystemLogRequest,
      com.zd.baseframework.core.api.systemlog.PageSystemLogResponse> getPageSystemLogMethod() {
    io.grpc.MethodDescriptor<com.zd.baseframework.core.api.systemlog.PageSystemLogRequest, com.zd.baseframework.core.api.systemlog.PageSystemLogResponse> getPageSystemLogMethod;
    if ((getPageSystemLogMethod = ISystemLogServiceGrpc.getPageSystemLogMethod) == null) {
      synchronized (ISystemLogServiceGrpc.class) {
        if ((getPageSystemLogMethod = ISystemLogServiceGrpc.getPageSystemLogMethod) == null) {
          ISystemLogServiceGrpc.getPageSystemLogMethod = getPageSystemLogMethod =
              io.grpc.MethodDescriptor.<com.zd.baseframework.core.api.systemlog.PageSystemLogRequest, com.zd.baseframework.core.api.systemlog.PageSystemLogResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PageSystemLog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zd.baseframework.core.api.systemlog.PageSystemLogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zd.baseframework.core.api.systemlog.PageSystemLogResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ISystemLogServiceMethodDescriptorSupplier("PageSystemLog"))
              .build();
        }
      }
    }
    return getPageSystemLogMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ISystemLogServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ISystemLogServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ISystemLogServiceStub>() {
        @java.lang.Override
        public ISystemLogServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ISystemLogServiceStub(channel, callOptions);
        }
      };
    return ISystemLogServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ISystemLogServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ISystemLogServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ISystemLogServiceBlockingStub>() {
        @java.lang.Override
        public ISystemLogServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ISystemLogServiceBlockingStub(channel, callOptions);
        }
      };
    return ISystemLogServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ISystemLogServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ISystemLogServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ISystemLogServiceFutureStub>() {
        @java.lang.Override
        public ISystemLogServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ISystemLogServiceFutureStub(channel, callOptions);
        }
      };
    return ISystemLogServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ISystemLogServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *创建
     * </pre>
     */
    public void createSystemLog(com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest request,
        io.grpc.stub.StreamObserver<com.zd.baseframework.core.api.systemlog.SystemLogOperatorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSystemLogMethod(), responseObserver);
    }

    /**
     * <pre>
     *列表查询
     * </pre>
     */
    public void listSystemLogByCondition(com.zd.baseframework.core.api.systemlog.ListSystemLogRequest request,
        io.grpc.stub.StreamObserver<com.zd.baseframework.core.api.systemlog.ListSystemLogResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSystemLogByConditionMethod(), responseObserver);
    }

    /**
     * <pre>
     *分页查询
     * </pre>
     */
    public void pageSystemLog(com.zd.baseframework.core.api.systemlog.PageSystemLogRequest request,
        io.grpc.stub.StreamObserver<com.zd.baseframework.core.api.systemlog.PageSystemLogResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPageSystemLogMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSystemLogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest,
                com.zd.baseframework.core.api.systemlog.SystemLogOperatorResponse>(
                  this, METHODID_CREATE_SYSTEM_LOG)))
          .addMethod(
            getListSystemLogByConditionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.zd.baseframework.core.api.systemlog.ListSystemLogRequest,
                com.zd.baseframework.core.api.systemlog.ListSystemLogResponse>(
                  this, METHODID_LIST_SYSTEM_LOG_BY_CONDITION)))
          .addMethod(
            getPageSystemLogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.zd.baseframework.core.api.systemlog.PageSystemLogRequest,
                com.zd.baseframework.core.api.systemlog.PageSystemLogResponse>(
                  this, METHODID_PAGE_SYSTEM_LOG)))
          .build();
    }
  }

  /**
   */
  public static final class ISystemLogServiceStub extends io.grpc.stub.AbstractAsyncStub<ISystemLogServiceStub> {
    private ISystemLogServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ISystemLogServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ISystemLogServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *创建
     * </pre>
     */
    public void createSystemLog(com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest request,
        io.grpc.stub.StreamObserver<com.zd.baseframework.core.api.systemlog.SystemLogOperatorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSystemLogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *列表查询
     * </pre>
     */
    public void listSystemLogByCondition(com.zd.baseframework.core.api.systemlog.ListSystemLogRequest request,
        io.grpc.stub.StreamObserver<com.zd.baseframework.core.api.systemlog.ListSystemLogResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSystemLogByConditionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *分页查询
     * </pre>
     */
    public void pageSystemLog(com.zd.baseframework.core.api.systemlog.PageSystemLogRequest request,
        io.grpc.stub.StreamObserver<com.zd.baseframework.core.api.systemlog.PageSystemLogResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPageSystemLogMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ISystemLogServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ISystemLogServiceBlockingStub> {
    private ISystemLogServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ISystemLogServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ISystemLogServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *创建
     * </pre>
     */
    public com.zd.baseframework.core.api.systemlog.SystemLogOperatorResponse createSystemLog(com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSystemLogMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *列表查询
     * </pre>
     */
    public com.zd.baseframework.core.api.systemlog.ListSystemLogResponse listSystemLogByCondition(com.zd.baseframework.core.api.systemlog.ListSystemLogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSystemLogByConditionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *分页查询
     * </pre>
     */
    public com.zd.baseframework.core.api.systemlog.PageSystemLogResponse pageSystemLog(com.zd.baseframework.core.api.systemlog.PageSystemLogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPageSystemLogMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ISystemLogServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ISystemLogServiceFutureStub> {
    private ISystemLogServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ISystemLogServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ISystemLogServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *创建
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.zd.baseframework.core.api.systemlog.SystemLogOperatorResponse> createSystemLog(
        com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSystemLogMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *列表查询
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.zd.baseframework.core.api.systemlog.ListSystemLogResponse> listSystemLogByCondition(
        com.zd.baseframework.core.api.systemlog.ListSystemLogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSystemLogByConditionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *分页查询
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.zd.baseframework.core.api.systemlog.PageSystemLogResponse> pageSystemLog(
        com.zd.baseframework.core.api.systemlog.PageSystemLogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPageSystemLogMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SYSTEM_LOG = 0;
  private static final int METHODID_LIST_SYSTEM_LOG_BY_CONDITION = 1;
  private static final int METHODID_PAGE_SYSTEM_LOG = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ISystemLogServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ISystemLogServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SYSTEM_LOG:
          serviceImpl.createSystemLog((com.zd.baseframework.core.api.systemlog.CreateSystemLogRequest) request,
              (io.grpc.stub.StreamObserver<com.zd.baseframework.core.api.systemlog.SystemLogOperatorResponse>) responseObserver);
          break;
        case METHODID_LIST_SYSTEM_LOG_BY_CONDITION:
          serviceImpl.listSystemLogByCondition((com.zd.baseframework.core.api.systemlog.ListSystemLogRequest) request,
              (io.grpc.stub.StreamObserver<com.zd.baseframework.core.api.systemlog.ListSystemLogResponse>) responseObserver);
          break;
        case METHODID_PAGE_SYSTEM_LOG:
          serviceImpl.pageSystemLog((com.zd.baseframework.core.api.systemlog.PageSystemLogRequest) request,
              (io.grpc.stub.StreamObserver<com.zd.baseframework.core.api.systemlog.PageSystemLogResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ISystemLogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ISystemLogServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.zd.baseframework.core.api.systemlog.SystemLogProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ISystemLogService");
    }
  }

  private static final class ISystemLogServiceFileDescriptorSupplier
      extends ISystemLogServiceBaseDescriptorSupplier {
    ISystemLogServiceFileDescriptorSupplier() {}
  }

  private static final class ISystemLogServiceMethodDescriptorSupplier
      extends ISystemLogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ISystemLogServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ISystemLogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ISystemLogServiceFileDescriptorSupplier())
              .addMethod(getCreateSystemLogMethod())
              .addMethod(getListSystemLogByConditionMethod())
              .addMethod(getPageSystemLogMethod())
              .build();
        }
      }
    }
    return result;
  }
}
