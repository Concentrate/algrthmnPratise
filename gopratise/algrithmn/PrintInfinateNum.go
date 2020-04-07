package main

import (
	"fmt"
	"time"
)

func main() {
	tmpChan := make(chan int, 4)
	go produceNum(tmpChan)
	//time.Sleep(3 * time.Second)
	go printInfintaeNum(tmpChan)
	time.Sleep(1 * time.Hour)

}

func produceNum(chTmp chan int) {
	for i := 0; ; i++ {
		chTmp <- i
		if i > 10000 {
			return
		}
	}
}

func printInfintaeNum(chTmp chan int) {
	for ; ; {
		v := <-chTmp
		fmt.Printf("%v ", v)
		if v%100 == 0 {
			fmt.Println()
		}
	}
}
