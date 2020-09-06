package main

import (
	"fmt"
	"net"
	"net/rpc"
	"sync"
)

type HelloService struct{}

func (*HelloService) SayHello(paraName string, result *string) error {
	*result = "hello: " + paraName
	return nil
}

func startServer(aWait *sync.WaitGroup) {
	defer aWait.Done()
	rpc.RegisterName("HelloService", new(HelloService))
	listener, err := net.Listen("tcp", ":1234")
	if err != nil {
		fmt.Errorf("error net connect")
		return
	}
	con, aErr := listener.Accept()
	if aErr != nil {
		fmt.Errorf("error accept ")
		return
	}

	rpc.ServeConn(con)
}

func startClient(aWait *sync.WaitGroup) {
	defer aWait.Done()
	client, aErr := rpc.Dial("tcp", "localhost:1234")
	if aErr != nil {
		fmt.Errorf("client connect err")
		return
	}
	var result string
	client.Call("HelloService.SayHello", "marshal", &result)

	fmt.Println(result)
}

//func main() {
//	var aWait sync.WaitGroup
//	aWait.Add(2)
//	go startServer(&aWait)
//	go startClient(&aWait)
//
//	aWait.Wait()
//}
