package main

import (
	"fmt"
	"reflect"
	"unsafe"
)

func enterAndLeaveCall(tag string) string {
	fmt.Printf("\nenter  %v<<<<<\n", tag)
	return fmt.Sprintf("\nleave  %v>>>>>>\n", tag)
}

func testSliceChange(aSlice []int) {
	defer fmt.Printf(enterAndLeaveCall("testSliceChange"))

	fmt.Printf("slice value %v,address is %p\n", aSlice, aSlice)
	//fmt.Printf("unsafe Point %v \n", unsafe.Pointer(&aSlice))

	func(tSlice []int) {
		tSlice[0] = 99
		fmt.Printf("value is %v, slice address %p \n ", tSlice, tSlice)
	}(aSlice)

	fmt.Printf(" slice value %v,address is %p\n", aSlice, aSlice)
	//bSlice:=aSlice[1:2]
	//fmt.Printf("%v \n",bSlice[4])

}

func testArrayWithPoint(tmpArray *[]int) {
	defer fmt.Printf(enterAndLeaveCall("testArrayWithPoint"))
	fmt.Printf("%v , address %p \n ", *tmpArray, tmpArray)

	func(bArr *[]int) {
		(*bArr)[1] = 30
		fmt.Printf("%v , address %p \n ", *bArr, bArr)
		//var c2=bArr
		//(*c2)[2]=39

	}(tmpArray)

	/*(*tmpArray)[10]=300; // out of bounds*/
	fmt.Printf("%v , address %p \n ", *tmpArray, tmpArray)
	fmt.Printf("use len: %v \n", len(*tmpArray))

}

func pointerCaclu(tmpSlice []int) {
	defer fmt.Printf(enterAndLeaveCall("pointerCaclu"))
	p1 := unsafe.Pointer(&tmpSlice)

	fmt.Printf("change to Slice Header %v \n", *(*reflect.SliceHeader)(p1))

	fmt.Printf("slice addr is %p,slice[0] addr is %p ,and point is %v \n", &tmpSlice, &(tmpSlice[0]), p1)

	// **[]int ,指的是 *(*[]int) ,  **(**[]int) 就是 []int了
	// unsafe Point 转成啥样的指针都行，但是看意义
	var p2 = unsafe.Pointer(uintptr(p1) + uintptr(8))
	var p3 = unsafe.Pointer(uintptr(p1) + uintptr(16))
	fmt.Printf("first va is %v,len is %v,cap is %v \n", *((*int)(p1)), *((*int)(p2)), *((*int)(p3)))

	fmt.Printf("inner array firse ele is %v\n", **(**int)(p1))

	var baseArrPoint = unsafe.Pointer(uintptr(*(*int)(p1)))
	fmt.Printf("baseArr point is %p, value is %v\n", baseArrPoint, uintptr(baseArrPoint))

	var baseArr = *((*[6]int)(baseArrPoint))
	for c1 := 0; c1 < len(baseArr); c1++ {
		fmt.Printf("base array index %v , ele %v\n", c1, baseArr[c1])
	}

	var oneApple = *((**int)(p1))
	var d1 = unsafe.Pointer(oneApple)
	//d2:= unsafe.Pointer(uintptr(d1)+8);
	//d2:=(*[12]int)d1
	var oneMe = (*[336]int)(d1)

	fmt.Printf("%v,  %v,value is  %v\n ", p1, uintptr(p1), oneMe[233])
	//var forceGetArrayP = **(**[20]int)(p1)
	//for i := 0; i < 10; i++ {
	//	fmt.Printf("%v  ", forceGetArrayP[i])
	//}
}

func selfConstructSlice(tmpSlice []int) {
	defer fmt.Printf(enterAndLeaveCall("selfConstructSlice"))

	var s1 = struct {
		addr uintptr
		len  int
		cap  int
		//tmp2 int
	}{addr: uintptr(unsafe.Pointer(&tmpSlice)), len: 136, cap: 336}
	var cSlice = **(**[]int)( unsafe.Pointer(&s1)) // unsafe Point 转成啥样的指针都行，但是看意义
	// **[]int ,指的是 *(*[]int) ,  **(**[]int) 就是 []int了

	fmt.Printf("len of cSlice %v\n", len(cSlice))

	for i := 0; i < len(tmpSlice); i++ {
		fmt.Printf("%v ", cSlice[i])
	}
}

func constructWithSliceHeader(tmpSlice []int) {
	defer fmt.Printf(enterAndLeaveCall("constructWithSliceHeader"))
	var bWithSliceHead = reflect.SliceHeader{Len: len(tmpSlice) + 10, Cap: len(tmpSlice) + 10,
		Data: uintptr(unsafe.Pointer(&tmpSlice))}

	var cSlice = **(**[]int)(unsafe.Pointer(&bWithSliceHead))

	for i := 0; i < len(cSlice) /*what if put 11 */ ; i++ {
		fmt.Printf("%v ", cSlice[i])
	}
	fmt.Printf("\n")

	var sliHeadP = *(*reflect.SliceHeader)(unsafe.Pointer(&tmpSlice)) // 地址，长度，容量

	var oneMe = (*[6]int)(unsafe.Pointer(sliHeadP.Data))
	fmt.Printf("slice header is %v \n", sliHeadP)
	fmt.Printf("element is base arr %v \n", (*(oneMe))[2])

}

func testArrayChange(bArr [6]int) {
	defer fmt.Printf(enterAndLeaveCall("testArrayChange"))

	fmt.Printf(" before change array: %v,address %p \n", bArr, &bArr)

	func(cArr [6]int) {
		cArr[0] = -100
		fmt.Printf(" change array: %v, address %p \n", cArr, &cArr)
	}(bArr)

	fmt.Printf(" after change array: %v,address %p \n", bArr, &bArr)

	fmt.Printf("array addr is %p, and array 0 ele addr is %p \n", &bArr, &(bArr[0])) //the same
}

func testPrintAddressAndPoint() {
	defer fmt.Printf(enterAndLeaveCall("testPrintAddressAndPoint"))

	var num = 9
	var tmpP = &num
	fmt.Printf("num %s %p, and point %v, and tmpP %p", &num, &num, tmpP, tmpP)
}

type TestStrP struct {
	num  int
	name string
}

func printStructPoint() {
	/*struct 的地址，和其第一个变量一致，跟数组一样的逻辑*/
	defer fmt.Printf(enterAndLeaveCall("printStructPoint"))
	tP := TestStrP{num: 10, name: "apple"}
	fmt.Printf("tp point value %p, tp inner element num address %v, another name address %v \n", &tP, &(tP.num), &(tP.name))
}

func main() {

	var tmpArr = [...]int{1, 2, 3, 4, 5, 6, 7, 8}
	var tmpSlice = tmpArr[:]
	//
	//var noLengthBArr=[]int{1,2,3}
	//
	//testArrayChange(tmpArr)
	//
	//testArrayWithPoint(&noLengthBArr)
	//
	////noLengthBArr=append(noLengthBArr,30,3)
	//
	//testSliceChange(tmpSlice)

	pointerCaclu(tmpSlice)

	selfConstructSlice(tmpSlice)

	constructWithSliceHeader(tmpSlice)

	//testPrintAddressAndPoint()
	//printStructPoint()

	outputArr()

}

func outputArr() {
	defer fmt.Println(enterAndLeaveCall("outputArr"))
	aSlice := *new([]int)
	aSlice = append(aSlice, 2)
	var ber = [3]int{1, 23, 3}
	var cer = &ber
	fmt.Print(cer[2])
}
