package main

import "fmt"

/**删除数组重复元素*/
func removeOrderRedutantElement(tmpArray []int) []int{

	if(tmpArray==nil||len(tmpArray)==0){
		return []int{}
	}
	var slow =0;
	var fast=1;
	for ;fast<len(tmpArray);fast++{
		for;tmpArray[fast]!=tmpArray[slow];{
			slow++;
			tmpArray[slow]=tmpArray[fast];
			break
		}
	}
	return tmpArray[:slow+1]

}

func main() {
	//tmpArr:=[]int{1,1,2,3,4,5,5,6,8,7,9}
	tmpArr2:=[]int{1,1,1,1,1,1,1,1}
	fmt.Println(removeOrderRedutantElement(tmpArr2))

}
