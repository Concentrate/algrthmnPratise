package main

/* #include<stdio.h>

 void sayHello(char *point){
   puts(point);
}
 */
import "C"

func main() {
	C.sayHello(C.CString("hello,this world"))
}