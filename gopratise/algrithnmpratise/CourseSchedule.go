package main

import "fmt"

type CourseBeforeStr struct {
	before  int
	current int
}

const TRVEL_ING = 1
const TRVEL_ED = 2

func haveCycle(curCourse int, travelState []int, graph [][]int) bool {
	if travelState[curCourse] == TRVEL_ING {
		return true
	}
	if travelState[curCourse] == TRVEL_ED {
		return false
	}
	travelState[curCourse] = TRVEL_ING
	for a1 := 0; a1 < len(graph[curCourse]); a1++ {
		if haveCycle(graph[curCourse][a1], travelState, graph) {
			return true
		}
	}
	travelState[curCourse] = TRVEL_ED
	return false

}
func isCourseSchedleOk(courseNum int, beforeArr []CourseBeforeStr) bool {

	if courseNum <= 0 || beforeArr == nil || len(beforeArr) <= 0 {
		return true
	}

	var graph = [][]int{}
	for i := 0; i < courseNum; i++ {
		graph=append(graph,[]int{})
		graph[i] = make([]int, 0)
	}

	for i := 0; i < len(beforeArr); i++ {
		graph[beforeArr[i].before] = append(graph[beforeArr[i].before], beforeArr[i].current)
	}

	var travelState = make([]int, courseNum)

	for i := 0; i < courseNum; i++ {
		if haveCycle(i,travelState,graph) {
			return false
		}
	}
	return true
}

func main() {
	//fmt.Println("ok")
	var beforeCourseArr=[]CourseBeforeStr{{before: 1,current: 2},{before: 2,current: 3},
		{before: 3,current: 2}}
	fmt.Println(isCourseSchedleOk(5,beforeCourseArr))
}
