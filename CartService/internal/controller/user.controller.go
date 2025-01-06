package controller

import (
	"nxc/hcmus/cartservice/internal/service"

	"github.com/gin-gonic/gin"
)

type UserController struct {
	userService *service.UserService
}

func NewUserController() *UserController {
	return &UserController{
		userService: service.NewUserService(),
	}
}

// controller -> service -> repo -> models -> dbs
func (uc *UserController) GetUserByID(c *gin.Context) {
	// response.SuccessResponse(c, 20001, []string{"chien", "m10", "m11"})
	// response.ErrorResponse(c, 20003, "No need!!")
}
