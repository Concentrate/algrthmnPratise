package main

import (
	"fmt"
	"runtime"
)

var quit1 =make(chan int)

func loop1() {
	for i := 0; i < 100; i++ { //为了观察，跑多些
		fmt.Printf("%d ", i)
		runtime.Gosched() // 显式地让出CPU时间给其他goroutine
	}
	quit1 <- 0
}

func main() {
	//runtime.GOMAXPROCS(1) // 最多使用2个核

	go loop1()
	go loop1()

	for i := 0; i < 2; i++ {
		<-quit1
	}
}
