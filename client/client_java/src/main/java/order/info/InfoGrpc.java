package order.info;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The greeter service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0-SNAPSHOT)",
    comments = "Source: order/info/info.proto")
public final class InfoGrpc {

  private InfoGrpc() {}

  public static final String SERVICE_NAME = "order.info.Info";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<order.info.InfoOuterClass.AddRequest,
      order.info.InfoOuterClass.AddResponse> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Add",
      requestType = order.info.InfoOuterClass.AddRequest.class,
      responseType = order.info.InfoOuterClass.AddResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<order.info.InfoOuterClass.AddRequest,
      order.info.InfoOuterClass.AddResponse> getAddMethod() {
    io.grpc.MethodDescriptor<order.info.InfoOuterClass.AddRequest, order.info.InfoOuterClass.AddResponse> getAddMethod;
    if ((getAddMethod = InfoGrpc.getAddMethod) == null) {
      synchronized (InfoGrpc.class) {
        if ((getAddMethod = InfoGrpc.getAddMethod) == null) {
          InfoGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<order.info.InfoOuterClass.AddRequest, order.info.InfoOuterClass.AddResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  order.info.InfoOuterClass.AddRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  order.info.InfoOuterClass.AddResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InfoMethodDescriptorSupplier("Add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<order.info.InfoOuterClass.ListRequest,
      order.info.InfoOuterClass.ListResponse> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = order.info.InfoOuterClass.ListRequest.class,
      responseType = order.info.InfoOuterClass.ListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<order.info.InfoOuterClass.ListRequest,
      order.info.InfoOuterClass.ListResponse> getListMethod() {
    io.grpc.MethodDescriptor<order.info.InfoOuterClass.ListRequest, order.info.InfoOuterClass.ListResponse> getListMethod;
    if ((getListMethod = InfoGrpc.getListMethod) == null) {
      synchronized (InfoGrpc.class) {
        if ((getListMethod = InfoGrpc.getListMethod) == null) {
          InfoGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<order.info.InfoOuterClass.ListRequest, order.info.InfoOuterClass.ListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  order.info.InfoOuterClass.ListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  order.info.InfoOuterClass.ListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InfoMethodDescriptorSupplier("List"))
              .build();
        }
      }
    }
    return getListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InfoStub newStub(io.grpc.Channel channel) {
    return new InfoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InfoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new InfoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InfoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new InfoFutureStub(channel);
  }

  /**
   * <pre>
   * The greeter service definition.
   * </pre>
   */
  public static abstract class InfoImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void add(order.info.InfoOuterClass.AddRequest request,
        io.grpc.stub.StreamObserver<order.info.InfoOuterClass.AddResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     */
    public void list(order.info.InfoOuterClass.ListRequest request,
        io.grpc.stub.StreamObserver<order.info.InfoOuterClass.ListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                order.info.InfoOuterClass.AddRequest,
                order.info.InfoOuterClass.AddResponse>(
                  this, METHODID_ADD)))
          .addMethod(
            getListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                order.info.InfoOuterClass.ListRequest,
                order.info.InfoOuterClass.ListResponse>(
                  this, METHODID_LIST)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeter service definition.
   * </pre>
   */
  public static final class InfoStub extends io.grpc.stub.AbstractStub<InfoStub> {
    private InfoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InfoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InfoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InfoStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void add(order.info.InfoOuterClass.AddRequest request,
        io.grpc.stub.StreamObserver<order.info.InfoOuterClass.AddResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void list(order.info.InfoOuterClass.ListRequest request,
        io.grpc.stub.StreamObserver<order.info.InfoOuterClass.ListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeter service definition.
   * </pre>
   */
  public static final class InfoBlockingStub extends io.grpc.stub.AbstractStub<InfoBlockingStub> {
    private InfoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InfoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InfoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InfoBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public order.info.InfoOuterClass.AddResponse add(order.info.InfoOuterClass.AddRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     */
    public order.info.InfoOuterClass.ListResponse list(order.info.InfoOuterClass.ListRequest request) {
      return blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeter service definition.
   * </pre>
   */
  public static final class InfoFutureStub extends io.grpc.stub.AbstractStub<InfoFutureStub> {
    private InfoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InfoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InfoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InfoFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<order.info.InfoOuterClass.AddResponse> add(
        order.info.InfoOuterClass.AddRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<order.info.InfoOuterClass.ListResponse> list(
        order.info.InfoOuterClass.ListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;
  private static final int METHODID_LIST = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InfoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InfoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD:
          serviceImpl.add((order.info.InfoOuterClass.AddRequest) request,
              (io.grpc.stub.StreamObserver<order.info.InfoOuterClass.AddResponse>) responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list((order.info.InfoOuterClass.ListRequest) request,
              (io.grpc.stub.StreamObserver<order.info.InfoOuterClass.ListResponse>) responseObserver);
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

  private static abstract class InfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InfoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return order.info.InfoOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Info");
    }
  }

  private static final class InfoFileDescriptorSupplier
      extends InfoBaseDescriptorSupplier {
    InfoFileDescriptorSupplier() {}
  }

  private static final class InfoMethodDescriptorSupplier
      extends InfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    InfoMethodDescriptorSupplier(String methodName) {
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
      synchronized (InfoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InfoFileDescriptorSupplier())
              .addMethod(getAddMethod())
              .addMethod(getListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
