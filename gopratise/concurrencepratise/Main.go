package main

func main2() {

	//var tmpSig Singleton1
	for i := 0; i < 100; i++ {
		go func() {
			//fmt.Println(*tmpSig.GetSingleton())
		}()
	}
}
