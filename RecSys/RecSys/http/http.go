package http

import (
	"github.com/gin-gonic/gin"
	"net/http"
)

func StartHttp() {
	r := gin.Default()
	r.Use(CORSMiddleware())

	r.POST("/order", newOrder)
	r.DELETE("/dish", finishDish)
	r.GET("/recommendation", getRec)
	r.POST("/cooked/:id", serveCooked)
	r.GET("/cooked", getCooked)

	err := r.Run(":7890")
	if err != nil {
		panic(err)
	}
}

func CORSMiddleware() gin.HandlerFunc {
	return func(c *gin.Context) {
		c.Writer.Header().Set("Access-Control-Allow-Origin", "*")
		c.Writer.Header().Set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
		c.Writer.Header().Set("Access-Control-Allow-Headers", "Content-Type, Authorization")

		if c.Request.Method == "OPTIONS" {
			c.AbortWithStatus(http.StatusNoContent)
			return
		}

		c.Next()
	}
}
