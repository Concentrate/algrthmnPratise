package main

import (
	"context"
	"fmt"
	"sync"
	"time"
)

func doSomejob(taskSignal chan int, wg *sync.WaitGroup) {
	defer wg.Done()
	for {
		select {
		default:
			fmt.Println("doing job")
		case <-taskSignal:
			fmt.Println("cancel job")
			return

		}
	}
}
func doSomejob2(context context.Context, wg *sync.WaitGroup) {
	defer wg.Done()
	for {
		select {
		default:
			fmt.Println("doing job")
		case <-context.Done():
			fmt.Println("cancel job")
			return

		}
	}
}
func main() {
	//contextSignal()
	contextNotify()
}

func contextSignal() {
	tContext, _ := context.WithTimeout(context.Background(), 15*time.Second)
	wgP := new(sync.WaitGroup)
	for i := 0; i < 10; i++ {
		wgP.Add(1)
		go doSomejob2(tContext, wgP)
	}
	time.Sleep(3 * time.Second)
	//tCancel()
	wgP.Wait()
}

func contextNotify() {
	ctx, cancel := context.WithTimeout(context.Background(), 30*time.Second)
	defer cancel()
	subCtx, canFun := context.WithCancel(ctx)
	go handle(subCtx, 200*time.Millisecond)
	time.Sleep(100 * time.Millisecond)
	canFun()
	select {
	case <-ctx.Done():
		fmt.Println("main", ctx.Err())
	}
}

func handle(ctx context.Context, duration time.Duration) {
	select {
	case <-ctx.Done():
		fmt.Println("sub handle", ctx.Err())
	case <-time.After(duration):
		fmt.Println("process request with ", duration)
		tmpCtx, _ := context.WithTimeout(ctx, 300*time.Millisecond)
		go handle(tmpCtx, 200*time.Millisecond)
	}
}

func normalSignalWithChannel() {
	wgP := new(sync.WaitGroup)
	signal := make(chan int)

	for i := 0; i < 10; i++ {
		wgP.Add(1)
		go doSomejob(signal, wgP)
	}
	time.Sleep(5 * time.Microsecond)
	close(signal)
	wgP.Wait()
}
