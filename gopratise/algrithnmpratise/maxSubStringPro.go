package main

import "fmt"

func maxInt(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func maxSubString(tmp1 string, tmp2 string) string {
	n := len(tmp1)
	m := len(tmp2)
	var matrix = [][]int{}
	for i := 0; i < n; i++ {
		matrix = append(matrix, []int{})
		for j := 0; j < m; j++ {
			matrix[i] = append(matrix[i], j)
		}
	}

	for i := 0; i < m; i++ {
		if tmp1[0] == tmp2[i] {
			matrix[0][i] = 1
		} else {
			matrix[0][i] = 0
		}
	}

	for i := 0; i < n; i++ {
		if tmp1[i] == tmp2[0] {
			matrix[i][0] = 1
		} else {
			matrix[i][0] = 0
		}
	}
	var maxRes = -1
	var fromFirstEndIndex = 0
	for i := 1; i < n; i++ {

		for j := 1; j < m; j++ {
			if tmp1[i] == tmp2[j] {
				matrix[i][j] = matrix[i-1][j-1] + 1
			} else {
				matrix[i][j] = 0
			}
			if matrix[i][j] > maxRes {
				fromFirstEndIndex = i
			}
			maxRes = maxInt(matrix[i][j], maxRes)
		}
	}


	fmt.Printf("max sub string length %v\n,max str1 end index is %v\n ",maxRes,fromFirstEndIndex)

	return tmp1[fromFirstEndIndex-maxRes+1:fromFirstEndIndex+1]

}

func main() {
	fmt.Println(maxSubString("abcgggde","abcgggeedfg"))
}
