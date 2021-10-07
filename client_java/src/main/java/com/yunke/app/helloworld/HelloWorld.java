package com.yunke.app.helloworld;
import com.yunke.app.helloworld.*;
import io.grpc.Channel;
import io.grpc.ManagedChannel; 
import io.grpc.ManagedChannelBuilder;



public class HelloWorld{
    public String sayHello(){
        return "Hello World";
    }


    public static void main(String[] args){
	    System.out.println((new HelloWorld()).sayHello());
	    Client client = new Client();
	    System.out.println((new HelloWorld()).sayHello());
	    client.init();
	    System.out.println((new HelloWorld()).sayHello());
	    System.out.println(client.Get("admin","123456"));
	    System.out.println((new HelloWorld()).sayHello());
    }
}
