package main

import "net/http"

type myHandler struct {
}

func (tmp *myHandler) ServeHTTP(writer http.ResponseWriter, request *http.Request) {
	writer.Write([]byte("hello,world"))
	writer.WriteHeader(http.StatusOK)
}

func main() {

	//tmpHan := myHandler{}
	tmpHan2 := func(writer http.ResponseWriter, request *http.Request) {
		writer.Write(([]byte)("you son of"))
		writer.WriteHeader(http.StatusOK)
	}

	http.ListenAndServe(":9898", http.HandlerFunc(tmpHan2))
}
