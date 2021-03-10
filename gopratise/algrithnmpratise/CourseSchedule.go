package main

import (
	"fmt"
)

/**course schedual
@link https://leetcode-cn.com/problems/course-schedule/
*/
type CourseBeforeStr struct {
	before  int
	current int
}

const TRVEL_ING = 1
const TRVEL_ED = 2

func canFinish(numCourses int, prerequisites [][]int) bool {
	var tmpArr = make([]CourseBeforeStr, 0)
	for i := 0; i < len(prerequisites); i++ {
		tmpArr = append(tmpArr, CourseBeforeStr{prerequisites[i][0], prerequisites[i][1]})
	}
	return isCourseSchedleOk(numCourses, tmpArr)
}

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
		graph = append(graph, []int{})
		graph[i] = make([]int, 0)
	}

	for i := 0; i < len(beforeArr); i++ {
		graph[beforeArr[i].before] = append(graph[beforeArr[i].before], beforeArr[i].current)
	}

	var travelState = make([]int, courseNum)

	for i := 0; i < courseNum; i++ {
		if haveCycle(i, travelState, graph) {
			return false
		}
	}

	return true
}

func findOrder(numCourses int, prerequisites [][]int) []int {
	var tmpArr = make([]CourseBeforeStr, 0)
	for i := 0; i < len(prerequisites); i++ {
		tmpArr = append(tmpArr, CourseBeforeStr{prerequisites[i][1], prerequisites[i][0]})
	}

	return CourseScheduleArray(numCourses, tmpArr)

}

// splite line *****

func travelRecordStateAndHadCycle(curCourse int, travelState []int, graph [][]int, travelRecord *[]int) bool {
	if travelState[curCourse] == TRVEL_ED {
		return false
	}
	if travelState[curCourse] == TRVEL_ING {
		return true
	}
	travelState[curCourse] = TRVEL_ING

	for a1 := 0; a1 < len(graph[curCourse]); a1++ {
		if travelRecordStateAndHadCycle(graph[curCourse][a1], travelState, graph, travelRecord) {
			return true
		}
	}
	travelState[curCourse] = TRVEL_ED
	*travelRecord = append(*travelRecord, curCourse)

	return false

}
func CourseScheduleArray(courseNum int, beforeArr []CourseBeforeStr) []int {
	if courseNum <= 0 || beforeArr == nil {
		return []int{}
	}

	var graph = [][]int{}
	for i := 0; i < courseNum; i++ {
		graph = append(graph, []int{})
	}

	for i := 0; i < len(beforeArr); i++ {
		graph[beforeArr[i].before] = append(graph[beforeArr[i].before], beforeArr[i].current)
	}

	var travelRecord = make([]int, 0)
	var travelState = make([]int, courseNum)

	for i := 0; i < courseNum; i++ {
		if travelRecordStateAndHadCycle(i, travelState, graph, &travelRecord) {
			return []int{}
		}
	}

	return reverArray(travelRecord)

}
func reverArray(tmp []int) []int {
	var res = []int{}
	for i := len(tmp) - 1; i >= 0; i-- {
		res = append(res, tmp[i])
	}
	return res
}

func main() {
	//fmt.Println("ok")
	//var beforeCourseArr = []CourseBeforeStr{{before: 1, current: 2}, {before: 2, current: 4},
	//	{before: 3, current: 4}}
	//fmt.Println(isCourseSchedleOk(5, beforeCourseArr))
	//fmt.Println(CourseScheduleArray(5, beforeCourseArr))
	fmt.Println(findOrder(2, [][]int{{1, 0}}))
}
