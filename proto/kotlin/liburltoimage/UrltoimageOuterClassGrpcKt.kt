package liburltoimage

import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import liburltoimage.UrltoimageGrpc.getServiceDescriptor

/**
 * Holder for Kotlin coroutine-based client and server APIs for liburltoimage.Urltoimage.
 */
public object UrltoimageGrpcKt {
  public const val SERVICE_NAME: String = UrltoimageGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = getServiceDescriptor()

  public val convertMethod:
      MethodDescriptor<UrltoimageOuterClass.Request, UrltoimageOuterClass.Response>
    @JvmStatic
    get() = UrltoimageGrpc.getConvertMethod()

  /**
   * A stub for issuing RPCs to a(n) liburltoimage.Urltoimage service as suspending coroutines.
   */
  @StubFor(UrltoimageGrpc::class)
  public class UrltoimageCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<UrltoimageCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): UrltoimageCoroutineStub =
        UrltoimageCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun convert(request: UrltoimageOuterClass.Request, headers: Metadata =
        Metadata()): UrltoimageOuterClass.Response = unaryRpc(
      channel,
      UrltoimageGrpc.getConvertMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the liburltoimage.Urltoimage service based on Kotlin coroutines.
   */
  public abstract class UrltoimageCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for liburltoimage.Urltoimage.Convert.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun convert(request: UrltoimageOuterClass.Request):
        UrltoimageOuterClass.Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method liburltoimage.Urltoimage.Convert is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = UrltoimageGrpc.getConvertMethod(),
      implementation = ::convert
    )).build()
  }
}
