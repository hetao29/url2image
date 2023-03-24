package user.info;

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
    comments = "Source: user/info/info.proto")
public final class InfoGrpc {

  private InfoGrpc() {}

  public static final String SERVICE_NAME = "user.info.Info";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<user.info.InfoOuterClass.LoginRequest,
      user.info.InfoOuterClass.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = user.info.InfoOuterClass.LoginRequest.class,
      responseType = user.info.InfoOuterClass.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<user.info.InfoOuterClass.LoginRequest,
      user.info.InfoOuterClass.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<user.info.InfoOuterClass.LoginRequest, user.info.InfoOuterClass.LoginResponse> getLoginMethod;
    if ((getLoginMethod = InfoGrpc.getLoginMethod) == null) {
      synchronized (InfoGrpc.class) {
        if ((getLoginMethod = InfoGrpc.getLoginMethod) == null) {
          InfoGrpc.getLoginMethod = getLoginMethod =
              io.grpc.MethodDescriptor.<user.info.InfoOuterClass.LoginRequest, user.info.InfoOuterClass.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  user.info.InfoOuterClass.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  user.info.InfoOuterClass.LoginResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InfoMethodDescriptorSupplier("login"))
              .build();
        }
      }
    }
    return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<user.info.InfoOuterClass.LogoutRequest,
      user.info.InfoOuterClass.LogoutResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = user.info.InfoOuterClass.LogoutRequest.class,
      responseType = user.info.InfoOuterClass.LogoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<user.info.InfoOuterClass.LogoutRequest,
      user.info.InfoOuterClass.LogoutResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<user.info.InfoOuterClass.LogoutRequest, user.info.InfoOuterClass.LogoutResponse> getLogoutMethod;
    if ((getLogoutMethod = InfoGrpc.getLogoutMethod) == null) {
      synchronized (InfoGrpc.class) {
        if ((getLogoutMethod = InfoGrpc.getLogoutMethod) == null) {
          InfoGrpc.getLogoutMethod = getLogoutMethod =
              io.grpc.MethodDescriptor.<user.info.InfoOuterClass.LogoutRequest, user.info.InfoOuterClass.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  user.info.InfoOuterClass.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  user.info.InfoOuterClass.LogoutResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InfoMethodDescriptorSupplier("logout"))
              .build();
        }
      }
    }
    return getLogoutMethod;
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
    public void login(user.info.InfoOuterClass.LoginRequest request,
        io.grpc.stub.StreamObserver<user.info.InfoOuterClass.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void logout(user.info.InfoOuterClass.LogoutRequest request,
        io.grpc.stub.StreamObserver<user.info.InfoOuterClass.LogoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                user.info.InfoOuterClass.LoginRequest,
                user.info.InfoOuterClass.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                user.info.InfoOuterClass.LogoutRequest,
                user.info.InfoOuterClass.LogoutResponse>(
                  this, METHODID_LOGOUT)))
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
    public void login(user.info.InfoOuterClass.LoginRequest request,
        io.grpc.stub.StreamObserver<user.info.InfoOuterClass.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(user.info.InfoOuterClass.LogoutRequest request,
        io.grpc.stub.StreamObserver<user.info.InfoOuterClass.LogoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
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
    public user.info.InfoOuterClass.LoginResponse login(user.info.InfoOuterClass.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public user.info.InfoOuterClass.LogoutResponse logout(user.info.InfoOuterClass.LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<user.info.InfoOuterClass.LoginResponse> login(
        user.info.InfoOuterClass.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<user.info.InfoOuterClass.LogoutResponse> logout(
        user.info.InfoOuterClass.LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_LOGOUT = 1;

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
        case METHODID_LOGIN:
          serviceImpl.login((user.info.InfoOuterClass.LoginRequest) request,
              (io.grpc.stub.StreamObserver<user.info.InfoOuterClass.LoginResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((user.info.InfoOuterClass.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<user.info.InfoOuterClass.LogoutResponse>) responseObserver);
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
      return user.info.InfoOuterClass.getDescriptor();
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
              .addMethod(getLoginMethod())
              .addMethod(getLogoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
