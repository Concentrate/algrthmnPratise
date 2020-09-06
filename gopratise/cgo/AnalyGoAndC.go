package main
// static int add(int a,int b){
//  return a+b;
//}
import "C"
import "fmt"

func main() {
	fmt.Print(C.add(3,4))
}