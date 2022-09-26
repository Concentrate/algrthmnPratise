package main

import (
	"fmt"
	"sync"

	"github.com/go-redis/redis"

	"pratise/redis/innner"
	"pratise/redis/lua"
)

func main() {

	client := innner.InitRedisCli()
	scripts, err := lua.GetAccountIncrScript()
	if err != nil {
		fmt.Errorf("read scripts err %v", err)
		return
	}
	//fmt.Println(scripts)
	wg := sync.WaitGroup{}
	tmpChan := make(chan int)
	wg.Add(2)
	go func() {
		defer wg.Done()
		tmpChan <- 1
		for a1 := 0; a1 < 2000; a1++ {
			<-tmpChan
			transferToAccount1(client, scripts)
			tmpChan <- 1
		}

		fmt.Println("first done")

	}()

	go func() {
		defer wg.Done()

		for a1 := 0; a1 < 2000; a1++ {
			<-tmpChan
			transferToAccount2(client, scripts)
			tmpChan <- 1
		}
		<-tmpChan
		fmt.Println("second done")
	}()

	wg.Wait()
	fmt.Println("done")
}

func transferToAccount1(client *redis.Client, scripts string) error {
	cmd := client.Eval(scripts, []string{"3", "account1", "account2"}, []string{"1", "10"})
	result, err := cmd.Int()
	if err != nil {
		fmt.Println("eval err ", err)
		return err
	}
	fmt.Printf("transferToAccount1 eval result %v\n", result)
	return nil
}

func transferToAccount2(client *redis.Client, scripts string) error {
	cmd := client.Eval(scripts, []string{"3", "account2", "account1"}, []string{"1", "10"})
	result, err := cmd.Int()
	if err != nil {
		fmt.Println("eval err ", err)
		return err
	}
	fmt.Printf("transferToAccount2 eval result %v\n", result)
	return nil

}
