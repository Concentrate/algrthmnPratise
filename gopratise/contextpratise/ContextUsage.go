package main

import (
	"context"
	"fmt"
	"time"
)

func handleCancelContext(ctx context.Context) {
	ttmpChan := make(chan int, 1)
	go func() {
		time.Sleep(1 * time.Minute)
		ttmpChan <- 8
	}()

	select {
	case <-ttmpChan:
		fmt.Println("chan get value")
	case <-ctx.Done():
		fmt.Println("ctx is done", ctx.Err())

	}
}

func main() {

	tCtx, cancel := context.WithCancel(context.Background())
	go handleCancelContext(tCtx)
	go handleCancelContext(tCtx)
	go handleCancelContext(tCtx)

	go func() {
		time.Sleep(3 * time.Second)
		cancel()
	}()

	select {
	case <-tCtx.Done():
		fmt.Println("main ctx is done", tCtx.Err())
	}

	time.Sleep(time.Minute)

}

func timeoutCtxUsage() context.CancelFunc {
	ctx, cancel := context.WithTimeout(context.Background(), 1*time.Second)
	defer cancel()

	go handle(ctx, 1500*time.Millisecond)
	go handle(ctx, 1500*time.Millisecond)
	go handle(ctx, 1500*time.Millisecond)

	select {
	case <-ctx.Done():
		fmt.Println("main", ctx.Err())
	}
	return cancel
}

func handle(ctx context.Context, duration time.Duration) {
	select {
	case <-ctx.Done():
		fmt.Println("handle", ctx.Err())
	case <-time.After(duration):
		fmt.Println("process request with", duration)
	}
}
