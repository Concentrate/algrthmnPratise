package main

import (
	"fmt"
	"reflect"
)

type HelloService interface {
	Hello()
}
type People struct {
	Name string
	Age  int
}
type Enum int

const (
	ok Enum = 1
)

func (p *People) Hello() {
	fmt.Println("hello,people")
}

/**上面这种绑定接口相当于下面这种调用*/
func Hello(p *People) {
	p.Hello()
}

func main() {

	var stu People

	typeOfStu := reflect.TypeOf(stu)
	typeOfPtr := reflect.TypeOf(&stu)

	var helloService HelloService = &stu
	fmt.Println(typeOfStu.Name(), typeOfStu.Kind())

	fmt.Println(typeOfPtr.Elem().Name(), typeOfPtr.Kind())

	//var typeOfOk=reflect.TypeOf(ok)
	fmt.Println(reflect.TypeOf(ok).Name(), reflect.TypeOf(ok).Kind())
	// reflect 有些反射只对特定类型起作用
	fmt.Println(typeOfStu.NumMethod(), typeOfStu.NumField(), reflect.TypeOf(helloService).NumMethod())

	helloMe := reflect.TypeOf(helloService).Method(0)
	fmt.Println(helloMe)
	if helloMe2, ok := reflect.TypeOf(helloService).MethodByName("Hello"); ok {
		fmt.Println( /*helloMe2,helloMe2.Func,*/ helloMe2.PkgPath, helloMe2.Name, helloMe2.Type, helloMe2.Index)
		helloMe2.Func.Call([]reflect.Value{reflect.ValueOf(&stu)})

	}

}
