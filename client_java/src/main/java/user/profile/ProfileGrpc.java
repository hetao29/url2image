package user.profile;

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
    comments = "Source: user/profile/profile.proto")
public final class ProfileGrpc {

  private ProfileGrpc() {}

  public static final String SERVICE_NAME = "user.profile.Profile";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<user.profile.ProfileOuterClass.UpdateRequest,
      user.profile.ProfileOuterClass.UpdateResponse> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = user.profile.ProfileOuterClass.UpdateRequest.class,
      responseType = user.profile.ProfileOuterClass.UpdateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<user.profile.ProfileOuterClass.UpdateRequest,
      user.profile.ProfileOuterClass.UpdateResponse> getUpdateMethod() {
    io.grpc.MethodDescriptor<user.profile.ProfileOuterClass.UpdateRequest, user.profile.ProfileOuterClass.UpdateResponse> getUpdateMethod;
    if ((getUpdateMethod = ProfileGrpc.getUpdateMethod) == null) {
      synchronized (ProfileGrpc.class) {
        if ((getUpdateMethod = ProfileGrpc.getUpdateMethod) == null) {
          ProfileGrpc.getUpdateMethod = getUpdateMethod =
              io.grpc.MethodDescriptor.<user.profile.ProfileOuterClass.UpdateRequest, user.profile.ProfileOuterClass.UpdateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  user.profile.ProfileOuterClass.UpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  user.profile.ProfileOuterClass.UpdateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProfileMethodDescriptorSupplier("Update"))
              .build();
        }
      }
    }
    return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<user.profile.ProfileOuterClass.GetRequest,
      user.profile.ProfileOuterClass.GetResponse> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = user.profile.ProfileOuterClass.GetRequest.class,
      responseType = user.profile.ProfileOuterClass.GetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<user.profile.ProfileOuterClass.GetRequest,
      user.profile.ProfileOuterClass.GetResponse> getGetMethod() {
    io.grpc.MethodDescriptor<user.profile.ProfileOuterClass.GetRequest, user.profile.ProfileOuterClass.GetResponse> getGetMethod;
    if ((getGetMethod = ProfileGrpc.getGetMethod) == null) {
      synchronized (ProfileGrpc.class) {
        if ((getGetMethod = ProfileGrpc.getGetMethod) == null) {
          ProfileGrpc.getGetMethod = getGetMethod =
              io.grpc.MethodDescriptor.<user.profile.ProfileOuterClass.GetRequest, user.profile.ProfileOuterClass.GetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  user.profile.ProfileOuterClass.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  user.profile.ProfileOuterClass.GetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProfileMethodDescriptorSupplier("Get"))
              .build();
        }
      }
    }
    return getGetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProfileStub newStub(io.grpc.Channel channel) {
    return new ProfileStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProfileBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProfileBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProfileFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProfileFutureStub(channel);
  }

  /**
   * <pre>
   * The greeter service definition.
   * </pre>
   */
  public static abstract class ProfileImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void update(user.profile.ProfileOuterClass.UpdateRequest request,
        io.grpc.stub.StreamObserver<user.profile.ProfileOuterClass.UpdateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void get(user.profile.ProfileOuterClass.GetRequest request,
        io.grpc.stub.StreamObserver<user.profile.ProfileOuterClass.GetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                user.profile.ProfileOuterClass.UpdateRequest,
                user.profile.ProfileOuterClass.UpdateResponse>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getGetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                user.profile.ProfileOuterClass.GetRequest,
                user.profile.ProfileOuterClass.GetResponse>(
                  this, METHODID_GET)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeter service definition.
   * </pre>
   */
  public static final class ProfileStub extends io.grpc.stub.AbstractStub<ProfileStub> {
    private ProfileStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfileStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProfileStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void update(user.profile.ProfileOuterClass.UpdateRequest request,
        io.grpc.stub.StreamObserver<user.profile.ProfileOuterClass.UpdateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get(user.profile.ProfileOuterClass.GetRequest request,
        io.grpc.stub.StreamObserver<user.profile.ProfileOuterClass.GetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeter service definition.
   * </pre>
   */
  public static final class ProfileBlockingStub extends io.grpc.stub.AbstractStub<ProfileBlockingStub> {
    private ProfileBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfileBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProfileBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public user.profile.ProfileOuterClass.UpdateResponse update(user.profile.ProfileOuterClass.UpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public user.profile.ProfileOuterClass.GetResponse get(user.profile.ProfileOuterClass.GetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeter service definition.
   * </pre>
   */
  public static final class ProfileFutureStub extends io.grpc.stub.AbstractStub<ProfileFutureStub> {
    private ProfileFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfileFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProfileFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<user.profile.ProfileOuterClass.UpdateResponse> update(
        user.profile.ProfileOuterClass.UpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<user.profile.ProfileOuterClass.GetResponse> get(
        user.profile.ProfileOuterClass.GetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE = 0;
  private static final int METHODID_GET = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProfileImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProfileImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPDATE:
          serviceImpl.update((user.profile.ProfileOuterClass.UpdateRequest) request,
              (io.grpc.stub.StreamObserver<user.profile.ProfileOuterClass.UpdateResponse>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((user.profile.ProfileOuterClass.GetRequest) request,
              (io.grpc.stub.StreamObserver<user.profile.ProfileOuterClass.GetResponse>) responseObserver);
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

  private static abstract class ProfileBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProfileBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return user.profile.ProfileOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Profile");
    }
  }

  private static final class ProfileFileDescriptorSupplier
      extends ProfileBaseDescriptorSupplier {
    ProfileFileDescriptorSupplier() {}
  }

  private static final class ProfileMethodDescriptorSupplier
      extends ProfileBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProfileMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProfileGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProfileFileDescriptorSupplier())
              .addMethod(getUpdateMethod())
              .addMethod(getGetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
