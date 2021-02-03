package main

import (
	"bytes"
	"os"
)

func main() {
	var a bytes.Buffer
	a.Write([]byte("hello,world"))
	a.WriteTo(os.Stdout)
}
