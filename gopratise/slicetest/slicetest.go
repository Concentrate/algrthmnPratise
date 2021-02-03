package main

import "fmt"

func main2() {
	source:= []string{"apple","pear","banana","cat"}
	another:=source[1:2:3]
	//another=append(another,"dog")
	//another=append(another,"superman")
	second:=source[1:2:2]
	second=append(second,"science")

	dict:=map[int][]string{}
	fmt.Println(source,another,second,dict)
}
