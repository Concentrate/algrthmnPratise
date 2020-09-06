package main

import (
	"fmt"
	"time"
)

func main() {
	_, err := NewHelloServiceServer(":1234")
	if err != nil {
		return
	}

	cli, err := NewHelloRpcClicent("localhost:1234")
	if err != nil {
		return
	}
	for a1 := 0; a1 < 100; a1++ {
		cli.Hello(fmt.Sprintf("gentalman %v",a1))
	}

	time.Sleep(3 * time.Minute)
}
