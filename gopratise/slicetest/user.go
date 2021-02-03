package main

import "fmt"

type user struct {
	name string
	age  int
}

type admin struct {
	user
	isPermit bool
}

func (tmp *user) String() {
	fmt.Printf(" %v ,%v\n",tmp.name,tmp.age)
}

func main() {
	tmpAdmin:=admin{
		user: user{
			name: "xiaoming",
			age: 13,
		},

	}
	tmpAdmin.user.String()
	tmpAdmin.String()
}
