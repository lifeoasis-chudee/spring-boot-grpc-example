# spring boot grpc example

## Getting Started
1. gradle run > generateProto
2. run GrpcApplication
3. run command server
    ```shell
    grpcurl --plaintext -d '{"name": "test"}' localhost:8090 hello.springgrpc.Simple.SayHello
    ```

4. run localhost:8080
