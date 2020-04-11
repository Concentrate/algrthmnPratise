package main

import (
	"container/list"
	"fmt"
)

func main() {
	var tmpList=list.New()
	tmpList.PushBack(1)
	tmpList.PushBack("hello")
	tmpList.PushBack(6.5)

	for a1:=tmpList.Front();a1!=nil;a1=a1.Next(){
		fmt.Printf("%v ",a1.Value)
	}
	a,b:=1,2
	b,a=a,b
	fmt.Printf("%v %v",a,b)
}
