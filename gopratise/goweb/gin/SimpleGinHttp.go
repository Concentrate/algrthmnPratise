package main

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"net/http"
)

func main() {
	r := gin.Default()
	r.GET("/ping", func(c *gin.Context) {
		c.JSON(200, gin.H{
			"message": "pong",
		})
	})

	r.GET("/user/:name/*action", func(c *gin.Context) {
		name := c.Param("name")
		action := c.Param("action")
		message := name + " is " + action
		message = message + "\n" + c.FullPath()

		c.String(http.StatusOK, message)
	})

	v1 := r.Group("/v1", func(context *gin.Context) {
		fmt.Printf("visit v1 path,and get sub path")
	})
	v1.GET("/hello", func(context *gin.Context) {
		fmt.Printf("visit hello")
		context.Writer.WriteString(context.Param("hello"))
		context.Writer.Flush()
	}, func(context *gin.Context) {
		context.String(http.StatusOK, context.Param("hello")+", hello2 ")
	})
	v1.Group("/v2", func(context *gin.Context) {
		fmt.Printf("%v ,visit v2 ",context.FullPath())
	})

	r.Run() // listen and serve on 0.0.0.0:8080 (for windows "localhost:8080")
}
