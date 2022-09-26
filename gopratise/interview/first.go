package main

import "fmt"

func main() {
	s1 := []int64{1, 2, 3, 4, 5}
	s2 := s1[2:3]
	fmt.Println(len(s2), cap(s2))
}
