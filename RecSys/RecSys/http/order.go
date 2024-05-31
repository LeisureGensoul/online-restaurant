package http

import (
	"RecSys/invoker"
	"RecSys/manager"
	"github.com/gin-gonic/gin"
)

type NewOrderReq struct {
	Order manager.Order `json:"order"`
}

func newOrder(c *gin.Context) {
	req := &NewOrderReq{}
	if err := c.BindJSON(req); err != nil {
		c.JSON(400, gin.H{
			"msg": "bad parameters",
		})
		return
	}

	err := invoker.Manager.AddOrder(req.Order)
	if err != nil {
		c.JSON(400, gin.H{
			"msg": err,
		})
		return
	}

	c.Status(204)
}

type FinishDishReq struct {
	DishName  string `json:"dish_name"`
	FinishNum int    `json:"finish_num"`
}

func finishDish(c *gin.Context) {
	req := &FinishDishReq{}
	if err := c.BindJSON(req); err != nil {
		c.JSON(400, gin.H{
			"msg": "bad parameters",
		})
		return
	}

	err := invoker.Manager.CookDish(req.DishName, req.FinishNum)
	if err != nil {
		c.JSON(400, gin.H{
			"msg": err.Error(),
		})
		return
	}

	c.Status(204)
}

func getRec(c *gin.Context) {
	entries := invoker.Manager.GetRec()
	c.JSON(200, gin.H{
		"dishes": entries,
	})
}

func serveCooked(c *gin.Context) {
	id := c.Param("id")
	invoker.Manager.ServeCooked(id)
	c.Status(204)
}

func getCooked(c *gin.Context) {
	list := invoker.Manager.GetCookList()
	c.JSON(200, gin.H{
		"cooked": list,
	})
}
