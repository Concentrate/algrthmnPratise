package main

import (
	"fmt"
	"sync"
	"time"
)

func main() {

	//mapVa:=make(map[sync.WaitGroup]bool,10)
	testFun := func(wg *sync.WaitGroup) {
		fmt.Println(wg)
		//wg.Done()
		wg.Wait()
		fmt.Println("wg wait done")

	}

	// wg 每个 goroutine 都能被唤醒
	wg := sync.WaitGroup{}
	wg.Add(3)
	go testFun(&wg)
	go testFun(&wg)
	go testFun(&wg)
	wg.Add(-3)

	//fmt.Println(mapVa)
	time.Sleep(time.Minute)
}
