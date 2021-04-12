

package main

import (
"fmt"
"reflect"
)

type Student struct {

	Name string
	Age  int
}

func main2() {

	var stu Student

	typeOfStu := reflect.TypeOf(stu)

	fmt.Println(typeOfStu.Name(), typeOfStu.Kind())
}


type user struct {
	Name string
	Age  int
}

func main5() {
	var u = user{
		Age:  18,
		Name: "wuqq",
	}
	v := reflect.ValueOf(u)
	v.Elem().FieldByName("Name").SetString("curry")
	fmt.Printf("v的值:%+v",v)
}

func main() {
	var u = user{
		Age:  18,
		Name: "wuqq",
	}
	v := reflect.ValueOf(&u)
	v.Elem().FieldByName("Name").SetString("curry")
	fmt.Printf("v的值:%+v",v)
}
