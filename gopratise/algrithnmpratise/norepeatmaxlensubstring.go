package main

import "fmt"

/**不重复子串的最长长度*/

func notRepeatSubStringMaxLen(content string) int {
	if len(content) <= 1 {
		return len(content)
	}
	var left, right = 0, 0
	var res = - 1
	var charmap = map[uint8]int{}

	//for i := 0; i < len(content); i++ {
	//	if va, exist := charmap[content[i]]; !exist {
	//		charmap[content[i]] = 0
	//	} else {
	//		charmap[content[i]] = va + 1
	//	}
	//}
	var putMapFun= func(index int) {
			if va, exist := charmap[content[index]]; !exist {
				charmap[content[index]] = 1
			} else {
				charmap[content[index]] = va + 1
			}
	}

	for ; right < len(content); {
		for ; !isMeetResult(content, left, right,charmap); {
			if v1,bEx:=charmap[content[left]];bEx{
				charmap[content[left]]=v1-1
			}
			left++
		}
		putMapFun(right)
		res = MaxInt2(res, right-left+1)
		right++
	}

	return res

}
func MaxInt2(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func isMeetResult(content string, left int, right int,aMap map[uint8]int) bool {

	if va,exist:=aMap[content[right]];!exist{
		return true
	}else{
		return va<=0
	}
}

func main() {

	fmt.Println(notRepeatSubStringMaxLen("abegbde"))
}
