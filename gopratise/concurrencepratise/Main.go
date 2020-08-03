package main

import "fmt"

func main() {

	var tmpSig Singleton1
	for i := 0; i < 100; i++ {
		go func() {
			fmt.Println(*tmpSig.GetSingleton())
		}()
	}
}
