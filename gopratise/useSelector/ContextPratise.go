package main

import (
	"context"
	"fmt"
	"sync"
	"time"
)

func main() {
	tmpContext, cancel := context.WithCancel(context.Background())

	var waitGroup sync.WaitGroup
	var job = func() {
		defer waitGroup.Done()
		go func() {
			for {
				fmt.Println("doing the io job")
				time.Sleep(time.Second)
			}
		}()
		select {
		case <-tmpContext.Done():
			fmt.Println("cancel the job")
		}
	}
	waitGroup.Add(3)
	go job()
	go job()
	go job()

	time.Sleep(5*time.Second)
	cancel()
	waitGroup.Wait()
	fmt.Println("done")
}
