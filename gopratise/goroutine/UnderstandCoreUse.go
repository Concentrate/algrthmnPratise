package main

import (
"fmt"
)

func say(s string) {
	for i := 0; i < 5; i++ {
		fmt.Println(s)
	}
}

func main() {
	go say("world") //开一个新的Goroutines执行
	for {
	}
}
