package main

import (
	"context"
	"fmt"
	"time"
)

func handleCancelContext(ctx context.Context) {
	fmt.Println(ctx, ctx.Done())
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

func testDefer() {
	defer fmt.Println("hello")
	panic(1)
}

func backgroundContextUse() {
	tmpCtx := context.Background()
	deadLineCtx, cancelFun := context.WithDeadline(tmpCtx, time.Now().Add(time.Second*3))

	go func(a context.Context) {
		fmt.Printf("I am doing some job\n")
		select {
		case <-a.Done():
			fmt.Printf("task done ,exit\n")

		}
	}(deadLineCtx)

	time.Sleep(14 * time.Second)
	cancelFun()
	fmt.Printf("cancel fun")
}

func mutipleCancelContextUsage() {
	paCancelCtx, paCanFun := context.WithCancel(context.Background())

	subCancelCtx, _ := context.WithCancel(paCancelCtx)
	subCancelCtx2, canFun2 := context.WithCancel(paCancelCtx)

	grandSubCtx3, _ := context.WithCancel(subCancelCtx2)
	var testSubContextUsageFun = func(tmp context.Context, tag string) {
		fmt.Printf(tag+"   doing job %v\n", tmp)
		select {
		case <-tmp.Done():
			//fmt.Printf("job done signal trigger\n")
			fmt.Println(tag, "  ", tmp.Err())

		}
	}

	go testSubContextUsageFun(subCancelCtx, "subCancelCtx")
	go testSubContextUsageFun(subCancelCtx2, "subCancelCtx2")
	go testSubContextUsageFun(grandSubCtx3, "grandSubCtx3")

	time.Sleep(5 * time.Second)
	canFun2()
	time.Sleep(15 * time.Second)
	fmt.Println("after 15 sec")

	paCanFun()

}

func main() {
	//runtime.GOMAXPROCS(3)
	cancelCtxUse()
	//testDefer()
	//backgroundContextUse()
	//mutipleCancelContextUsage()
	time.Sleep(time.Minute)

}

func cancelCtxUse() {
	parent := context.Background()
	calCtx1, _ := context.WithCancel(parent)
	tCtx, canF := context.WithCancel(calCtx1)
	go handleCancelContext(calCtx1)
	go handleCancelContext(tCtx)
	go handleCancelContext(tCtx)

	go func() {
		time.Sleep(3 * time.Second)
		//if true {
		//	cancel()
		//} else {
		//	cancelFun()
		//}
		//cancelFun()
		canF()
	}()

	select {
	case <-calCtx1.Done():
		fmt.Println("main ctx is done", tCtx.Err())

	}
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
