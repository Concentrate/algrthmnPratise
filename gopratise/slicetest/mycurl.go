package main

import (
	"fmt"
	"io"
	"net/http"
	"os"
)

func init() {
	if len(os.Args) < 2 {
		fmt.Println("usgage ./mycurl url ")
		os.Exit(1)
	}
}
func main() {

	url := os.Args[1]
	content, err := http.Get(url)
	if err != nil {
		fmt.Errorf(" %v", err)
	}
	io.Copy(os.Stdout, content.Body)
	defer content.Body.Close()
}
