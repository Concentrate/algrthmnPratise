package main

import (
	"fmt"
	"sync"
	"time"
)

func enterAndLeaveCall(tag string) string {
	fmt.Printf("\nenter  %v<<<<<\n", tag)
	return fmt.Sprintf("\nleave  %v>>>>>>\n", tag)
}

func selectAndDefaultUse() {
	tmpChan := make(chan int, 3)
	go func() {
		for i := 0; i < 10; i++ {
			tmpChan <- i
			time.Sleep(time.Second)
		}
	}()

	go func() {
		for {
			select {
			case a1 := <-tmpChan:
				fmt.Printf("select case value is %v \n", a1)

			case <-time.After(300 * time.Millisecond):
				fmt.Println("after duration ")

				//default:
				//	fmt.Printf("default case\n ")
				//	time.Sleep(300 * time.Millisecond)

			}
		}
	}()

}

func rangeUseChannelConsume() {
	defer fmt.Println(enterAndLeaveCall("rangeUseChannelConsume"))

	waitDone := sync.WaitGroup{}
	tmpChan := make(chan int, 3)
	waitDone.Add(10)
	go func() {
		for i := 0; i < 10; i++ {
			tmpChan <- i
			time.Sleep(time.Second)
		}
	}()

	go func() {
		for a1 := range tmpChan {
			fmt.Println("range use ", a1)
			waitDone.Done()
		}
	}()

	//for a1 := range tmpChan {
	//	fmt.Println("range use ", a1)
	//	waitDone.Done()
	//}
	waitDone.Wait()
}

/*channel 里面传递channel*/
func channelPassChannel() {

	tmpChan := make(chan chan int, 3)
	subChan := make(chan int, 2)
	intchanFun := func(aChan chan<- int) {
		for i := 0; i < 5; i++ {
			aChan <- i
		}
	}
	go intchanFun(subChan)
	outChanFun := func(bChan <-chan chan int) {

		cSubChan := <-bChan
		for a1 := 0; a1 < 3; a1++ {
			fmt.Println(<-cSubChan)
		}
	}
	tmpChan <- subChan
	go outChanFun(tmpChan)

}

func main() {
	//withoutBuffer()
	//withBuffer()
	//selectAndDefaultUse()
	//rangeUseChannelConsume()
	channelPassChannel()
	time.Sleep(time.Minute)
}

func withBuffer() {
	defer fmt.Print(enterAndLeaveCall("withBuffer "))
	produceAndConsumer(3)

}
func withoutBuffer() {
	defer fmt.Print(enterAndLeaveCall("withoutBuffer "))
	produceAndConsumer(0)
}

func produceAndConsumer(buffer int) {
	tmpChan := make(chan int, buffer)

	//go func() {
	//	for i := 0; i < 3; i++ {
	//		tmpChan <- i
	//		fmt.Printf("produce %v\n", i)
	//	}
	//}()

	consuFun := func(tag string) {
		select {
		case tmpva, ok := <-tmpChan:
			fmt.Printf("tag %v, and consume %v,isok %v\n", tag, tmpva, ok)
		}
	}

	testChannelCopy := func(aChan chan int) {
		fmt.Println(aChan)
		select {
		case _, ok := <-aChan:
			if !ok {
				fmt.Println("close channel")
			}

		}
	}

	fmt.Println(tmpChan)
	go testChannelCopy(tmpChan)
	go testChannelCopy(tmpChan)

	go consuFun("c1")
	go consuFun("c2")
	go consuFun("c3")
	time.Sleep(3 * time.Second)
	close(tmpChan)
	//close(tmpChan)
	//tmpChan <- 9
	time.Sleep(10 * time.Second)

}
