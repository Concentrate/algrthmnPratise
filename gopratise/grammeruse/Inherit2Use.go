package main

import (
	"fmt"
	"time"
)

type Car2 struct {
	Name string
	Age  int
}

func (c *Car2) Set(name string, age int) {
	c.Name = name
	c.Age = age
}

type Car22 struct {
	Name string
}

//Go有匿名字段特性
type Train2 struct {
	Car2
	Car22
	createTime time.Time
	//count int   正常写法，Go的特性可以写成
	int
}

//给Train2加方法，t指定接受变量的名字，变量可以叫this，t，p
func (t *Train2) Set(age int) {
	t.int = age
}

func main() {
	var Train2 Train2
	Train2.int = 300 //这里用的匿名字段写法，给Age赋值
	//(&Train2).Set(1000)
	Train2.Car2.Set("huas", 100 )
	Train2.Car22.Name = "test" //这里Name必须得指定结构体
	fmt.Println(Train2)

}