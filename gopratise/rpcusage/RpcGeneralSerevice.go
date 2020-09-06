package main

import (
	"fmt"
	"net"
	"net/rpc"
	"net/rpc/jsonrpc"
)

type HelloServie interface {
	SayHello(paraName string, result *string) error
}

type HelloServer struct {
}

func (*HelloServer) SayHello(paraName string, result *string) error {
	*result = "Hello: " + paraName
	return nil
}

const HElloService = "HelloService_v1"

func startHelloService(listener net.Listener) {
	for {
		con, err := listener.Accept()
		if err != nil {
			fmt.Errorf("error happen %v", err)
			continue
		}
		go rpc.ServeCodec(jsonrpc.NewServerCodec(con))
	}

}

func NewHelloServiceServer(addr string) (*HelloServer, error) {
	listener, err := net.Listen("tcp", addr)
	if err != nil {
		return nil, err
	}
	service := &HelloServer{}
	rpc.RegisterName(HElloService, service)
	go startHelloService(listener)
	return service, nil
}

type HelloRpcClient struct {
	*rpc.Client
}

func (cli *HelloRpcClient) Hello(para string) {
	fmt.Println("calling rpc service..")
	var result string
	cli.Call(HElloService+".SayHello", para, &result)
	fmt.Println(result)
}

func NewHelloRpcClicent(addr string) (*HelloRpcClient, error) {
	con, error := net.Dial("tcp", addr)
	if error != nil {
		return nil, error
	}

	return &HelloRpcClient{Client: rpc.NewClientWithCodec(jsonrpc.NewClientCodec(con))}, nil
}
