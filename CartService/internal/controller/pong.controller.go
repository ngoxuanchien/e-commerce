package controller

import (
	"fmt"
	"net/http"

	"github.com/gin-gonic/gin"
)

type PongController struct{}

func NewPongController() *PongController {
	return &PongController{}
}

func (p *PongController) Pong(c *gin.Context) {
	fmt.Println("---> My Handler")
	name := c.DefaultQuery("name", "Chien")
	// c.ShouldBindJSON()
	uid := c.Query("uid")
	c.JSON(http.StatusOK, gin.H{ // map string go
		"message": "pong..ping" + name,
		"uid":     uid,
		"users":   []string{"cr7", "m10", "chien"},
	})
}
