package main

import (
	"fmt"
	"reflect"
)

func tmpOne()  {
	v := reflect.ValueOf(1)
	t1:=reflect.TypeOf(1)
	i := v.Interface().(int)
	fmt.Println(i,t1,v.Kind(),reflect.TypeOf(1))

}
func main() {


	tmpOne()
	i := 1
	v := reflect.ValueOf(&i)
	v.Elem().SetInt(10)
	fmt.Println(i)
}
