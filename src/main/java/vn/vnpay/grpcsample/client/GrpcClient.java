package vn.vnpay.grpcsample.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import vn.vnpay.grpcsample.HelloRequest;
import vn.vnpay.grpcsample.HelloResponse;
import vn.vnpay.grpcsample.HelloServiceGrpc;

@Slf4j
public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",8090)
                .usePlaintext().build();
        HelloServiceGrpc.HelloServiceBlockingStub stub =
                HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse response = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Lan Anh")
                .setLastName("gRPC")
                .build());
        log.info("Response receive from server: {}", response);
        channel.shutdown();
    }
}
