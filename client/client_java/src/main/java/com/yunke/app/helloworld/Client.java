package com.yunke.app.helloworld;

import io.grpc.Channel;
import io.grpc.ManagedChannel; 
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.info.*;

public class Client{
	private static final Logger logger = Logger.getLogger(Client.class.getName());

	private InfoGrpc.InfoBlockingStub helloWorldServiceBlockingStub;
	public void init() {
		ManagedChannel managedChannel = ManagedChannelBuilder
			.forAddress("127.0.0.1", 50000).usePlaintext().build();

		helloWorldServiceBlockingStub =
			InfoGrpc.newBlockingStub(managedChannel);
	}

	public String Get(String name, String pwd) {
		InfoOuterClass.LoginRequest request = InfoOuterClass.LoginRequest.newBuilder().setName(name)
			.setPassword(pwd).build();

		try{
		InfoOuterClass.LoginResponse response= 
			helloWorldServiceBlockingStub.login(request);
		return response.getInfo().getName();
		}catch (StatusRuntimeException e) {
			logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		}
		return null;
	}

}

