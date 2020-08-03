package main
/*
#include <stdio.h>

void sayHi() {
    printf("Hi");
}


*/
/*
void addNum(int a,int b){
 printf("\nthe result is \n,%d",a+b);
}

int subNum(int a,int b){
 return a-b;
}
 */
/*
static void sayHello(const char* content){
 puts(content);

}
 */
import "C"
import "fmt"

func main() {
	C.sayHi()
	C.addNum(1,3)

	var tmp=C.subNum(13,1);
	fmt.Println(tmp);

	C.sayHello(C.CString("hello,this world,I want to say sometimes you will find the happyiness"))
	//C.SayTomorrow(C.CString("I like you \n"))
}