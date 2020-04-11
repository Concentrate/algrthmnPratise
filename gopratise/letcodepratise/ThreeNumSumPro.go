package main

import (
	"fmt"
	"sort"
)

type recordTwoSumStr struct {
	target     int
	otherArray [][]int
}

func getTargetTwoNumSun(nums []int, target int, chNoti chan recordTwoSumStr) {
	result := [][]int{}
	tmpSlice := make([]int, len(nums))
	copy(tmpSlice, nums)
	sort.Ints(tmpSlice)
	for i, j := 0, len(tmpSlice)-1; i < j; {
		if tmpSlice[i]+tmpSlice[j] < target {
			i++
		} else if tmpSlice[i]+tmpSlice[j] > target {
			j--
		} else {
			result = append(result, []int{tmpSlice[i], tmpSlice[j]})
			i++
		}
	}
	chNoti <- recordTwoSumStr{target: target, otherArray: result}
}

func threeSum(nums []int) [][]int {
	if nums == nil || len(nums) == 0 {
		return nil
	}
	result := [][]int{}
	firstNumSet := map[int]bool{}
	resultBook := map[string]bool{}
	parllChan := make(chan recordTwoSumStr, len(nums))
	var dealNum=0
	for i := 0; i < len(nums); i++ {
		_, exist := firstNumSet[nums[i]]
		if exist {
			continue
		}
		firstNumSet[nums[i]] = true
		dealNum++
		go getTargetTwoNumSun(nums[i+1:], -nums[i], parllChan)
	}

	for {
		select {
		case tmp := <-parllChan:
			dealNum--
			targetTwoMenArray, numOne := tmp.otherArray, tmp.target
			{
				for aindex, _ := range targetTwoMenArray {
					targetTwoMenArray[aindex] = append(targetTwoMenArray[aindex], -numOne)
					sort.Ints(targetTwoMenArray[aindex])
					if _, bexist := resultBook[fmt.Sprint(targetTwoMenArray[aindex])]; !bexist {
						result = append(result, targetTwoMenArray[aindex])
					}
					resultBook[fmt.Sprint(targetTwoMenArray[aindex])] = true
				}
			}
		}
		if(dealNum<=0){
			break
		}
	}

	return result
}

func main() {

	nums := []int{-1, 0, 1, 2, -1, -4}
	//nums := []int{0, 0, 0}

	fmt.Printf("%v", threeSum(nums))

}
