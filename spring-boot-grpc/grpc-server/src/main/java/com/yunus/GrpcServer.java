package com.yunus;

import com.yunus.api.RPCDateServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author gaoyunfeng
 */
public class GrpcServer {

    private static final int PORT = 9999;

    public static void main(String[] args) throws InterruptedException, IOException {

        //设置service端口
        Server server = ServerBuilder.forPort(PORT)
                .addService(new RPCDateServiceImpl())
                .build().start();
        System.out.printf("GRpc服务端启动成功, 端口号: %d.%n", PORT);

        server.awaitTermination();
    }
}