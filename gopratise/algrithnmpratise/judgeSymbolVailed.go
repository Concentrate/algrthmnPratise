package main

import "fmt"

func init() {

}

/**判断符号是否成对*/
type mStack struct {
	Element []int
}

func (stack *mStack) push(ele int) {
	if stack.Element == nil {
		stack.Element = make([]int, 0)
	}
	stack.Element = append(stack.Element, ele)
}

func (stack *mStack) peek() int {
	if stack.Element == nil {
		stack.Element = make([]int, 0)
		return 0
	}
	if len(stack.Element) == 0 {
		return 0
	}
	return stack.Element[len(stack.Element)-1]
}

func (stack *mStack) pop() int {
	if stack.Element == nil {
		stack.Element = make([]int, 0)
		return 0
	}
	if len(stack.Element) == 0 {
		return 0
	}
	var peekNum = stack.peek()
	stack.Element = stack.Element[:len(stack.Element)-1]
	return peekNum
}

func judgeSymbolVaild(tmpContent string) bool {
	if len(tmpContent) == 0 {
		return false
	}

	var aStack = mStack{}

	for i := 0; i < len(tmpContent); i++ {
		if tmpContent[i] == '[' || tmpContent[i] == '{' || tmpContent[i] == '(' {
			aStack.push(int(tmpContent[i]))
		} else {
			RIGHT1 := uint8(']')
			RIGHT2 := uint8('}')
			RIGHT3 := uint8(')')
			var wantOne int
			switch tmpContent[i] {
			case RIGHT1:
				wantOne = int('[')
				break
			case RIGHT2:
				wantOne = int('{')
				break
			case RIGHT3:
				wantOne = int('(')
				break
			}
			if aStack.pop() != wantOne {
				return false
			}
		}
	}
	return len(aStack.Element) == 0

}
func main() {

	fmt.Println(judgeSymbolVaild("([{}])"))

}
