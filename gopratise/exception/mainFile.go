package main

import (
	"fmt"
	"log"
	"time"
)
func division(x,y int) (result int,err error){
	defer func(){
		if e := recover(); e != nil{
			err = e.(error)
			//fmt.Printf("%v",e)
			//log.Fatal(e)
			fmt.Println("divided by 0")
		}
	}()
	result = x / y
	return result ,nil
}


func main() {
	defer func() {
		fmt.Println("definalt final run")
		if r := recover(); r != nil {
			log.Fatal(r)
		}
	}()

	//fmt.Println(8/0)
	//division(3,0)
	//panic(1)
	fmt.Println("hello")
	time.Sleep(10*time.Second)
}
