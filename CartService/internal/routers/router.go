package routers

import (
	"fmt"
	c "nxc/hcmus/cartservice/internal/controller"
	"nxc/hcmus/cartservice/internal/middlewares"

	"github.com/gin-gonic/gin"
)

func AA() gin.HandlerFunc {
	return func(c *gin.Context) {
		fmt.Println("Before --> AA")
		c.Next()
		fmt.Println("After --> AA")
	}
}

func BB() gin.HandlerFunc {
	return func(c *gin.Context) {
		fmt.Println("Before --> BB")
		c.Next()
		fmt.Println("After --> BB")
	}
}

func CC(c *gin.Context) {
	fmt.Println("Before --> CC")
	c.Next()
	fmt.Println("After --> CC")
}

func NewRouter() *gin.Engine {
	r := gin.Default()

	// use the middleware
	r.Use(middlewares.AuthenMiddleware(), BB(), CC)

	v1 := r.Group("/v1/2024")
	{
		v1.GET("/ping", c.NewPongController().Pong)
		v1.GET("/user/1", c.NewUserController().GetUserByID)
		// v1.GET("/ping/:name", Pong)
	}

	// v2 := r.Group("/v2/2024")
	// {
	// 	v2.GET("/ping", Pong)
	// 	v2.POST("/ping", Pong)
	// 	v2.PUT("/ping", Pong)
	// 	v2.DELETE("/ping", Pong)
	// 	v2.PATCH("/ping", Pong)
	// 	v2.OPTIONS("/ping", Pong)

	// }

	return r
}
