package hello.springgrpc.service;

import hello.springgrpc.simple.HelloReply;
import hello.springgrpc.simple.SimpleGrpc;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import static hello.springgrpc.simple.HelloRequest.newBuilder;

@Service
public class HelloClientService {

    @GrpcClient("hello-grpc")
    private SimpleGrpc.SimpleBlockingStub simpleStub;

    public String sendMessage(final String name) {
        try {
            HelloReply response = simpleStub.sayHello(newBuilder().setName(name).build());
            return response.getMessage();
        } catch (StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }
}
