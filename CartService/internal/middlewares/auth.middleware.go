package middlewares

import (
	"nxc/hcmus/cartservice/pkg/response"

	"github.com/gin-gonic/gin"
)

func AuthenMiddleware() gin.HandlerFunc {
	return func(c *gin.Context) {
		token := c.GetHeader("Authorization")
		if token != "valid-token" {
			response.ErrorResponse(c, response.ErrInvalidToken, "Invalid token")
			c.Abort()
			return
		}
		c.Next()
	}
}
