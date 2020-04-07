package main

import "fmt"

func Initer() chan int {
	tmp := make(chan int)
	go func() {
		for i := 2; ; i++ {
			tmp <- i
		}
	}()
	return tmp
}

func Filter(inputRaw chan int, primer int) chan int {
	out := make(chan int)
	go func() {
		for {
			if rawNum := <-inputRaw; rawNum%primer != 0 {
				out <- rawNum
			}
		}
	}()
	return out
}

func Generator(chInput chan int) chan int {
	out := make(chan int)
	go func() {
		for {
			primer := <-chInput
			chInput = Filter(chInput, primer)
			out <- primer
		}

	}()
	return out
}

func main() {
	var getPrimerNumCh = Generator(Initer())
	for {
		fmt.Printf("%v ", <-getPrimerNumCh)
	}
}
