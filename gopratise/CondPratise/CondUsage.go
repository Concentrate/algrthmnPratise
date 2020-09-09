package main

import (
	"fmt"
	"os"
	"os/signal"
	"sync"
	"time"
)

func lockUsageTeest()  {
	tmpLock:=sync.Mutex{}

	testFunc:= func(tl *sync.Mutex) {
		defer tl.Unlock()
		tl.Lock()
		fmt.Println("into this lock")
		time.Sleep(10*time.Second)
	}

	go testFunc(&tmpLock)
	go testFunc(&tmpLock)
	go testFunc(&tmpLock)
	go testFunc(&tmpLock)
	go testFunc(&tmpLock)



}

func main() {
	c := sync.NewCond(&sync.Mutex{})
	for i := 0; i < 10; i++ {
		go listen(c)
	}
	time.Sleep(3*time.Second)
	go broadcast(c)

	//lockUsageTeest()
	ch := make(chan os.Signal, 1)
	signal.Notify(ch, os.Interrupt)
	<-ch
}

func broadcast(c *sync.Cond) {
	c.L.Lock()
	c.Signal()
	c.Signal()
	c.Signal()
	c.Signal()

	c.L.Unlock()
}

func listen(c *sync.Cond) {
	c.L.Lock()
	fmt.Println("wait in cond trigger")
	// wait 里面做了 unlock 操作
	c.Wait()
	fmt.Println("listen")
	c.L.Unlock()
}
