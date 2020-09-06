package main

import (
	"fmt"
	"reflect"
	"unsafe"
)

type X struct {
}

type Y struct {
}

func main() {

	var p []X
	var q []Y

	p=append(p,X{})
	q=append(q,Y{})

	pHdr := (*reflect.SliceHeader)(unsafe.Pointer(&p))
	qHdr := (*reflect.SliceHeader)(unsafe.Pointer(&q))

	pHdr.Data = qHdr.Data
	pHdr.Len = qHdr.Len * int(unsafe.Sizeof(q[0])/unsafe.Sizeof(p[0]))
	pHdr.Cap = qHdr.Cap * int(unsafe.Sizeof(q[0])/unsafe.Sizeof(p[0]))
	fmt.Printf("%v",*pHdr)
}
