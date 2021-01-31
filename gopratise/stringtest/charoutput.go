package main

import "fmt"

func main() {
	s:= "ok我爱你"
	fmt.Println(len(s))    // 11
	fmt.Println(len([]rune(s)))  // 5
	fmt.Println(len([]byte(s)))  // 11

	// str是int32类型
	for i, str := range s {
		fmt.Printf("%d %c", i, str)
		fmt.Println()
	}

	// str是byte类型
	for i, str := range []byte(s) {
		fmt.Printf("%d %x", i, str)
		fmt.Println()
	}

	// str是rune类型
	for i, str := range []rune(s) {
		fmt.Printf("%d %c", i, str)
		fmt.Println()
	}

}
