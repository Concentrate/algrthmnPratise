package lua

import (
	"fmt"
	"io/ioutil"
	"os"
)

const path = "C:\\Users\\ldy\\project\\algrthmnPratise\\gopratise\\redis\\lua\\incr_decr.lua"

func GetAccountIncrScript() (string, error) {
	file, err := os.OpenFile(path, os.O_RDONLY, 0666)
	if err != nil {
		return "", fmt.Errorf("error open file ,%v", err)
	}

	content, err := ioutil.ReadFile(file.Name())
	if err != nil {
		return "", fmt.Errorf("error read file content %v", err)
	}
	//fmt.Println("read content len", content)
	return string(content), nil
}
