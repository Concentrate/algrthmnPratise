package main

import (
	"fmt"
	"sync"
	"sync/atomic"
)

type Singleton1 struct {
	hello string
	code  int
}

var (
	mutex     sync.Mutex
	loaded    int32
	singleton *Singleton1
)

func GetSingleton() *Singleton1 {
	if atomic.LoadInt32(&loaded) == 1 {
		return singleton
	}
	defer mutex.Unlock()
	mutex.Lock()
	if singleton == nil {
		defer atomic.StoreInt32(&loaded, 1)
		singleton = &Singleton1{hello: "ok", code: 11}
		return singleton
	}
	return singleton
}

func main() {

	var wg sync.WaitGroup
	wg.Add(10)
	for i := 0; i < 10; i++ {
		go func() {
			defer wg.Done()
			fmt.Println(*GetSingleton())
		}()
	}
	wg.Wait()
}
